package com.wh.workSubmission.controller;

import com.wh.workSubmission.dto.Response;
import com.wh.workSubmission.util.ResponseUtil;
import com.wh.workSubmission.util.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
@RequestMapping("/file")
public class FileController {


    @PostMapping("/upload")
    @ResponseBody
    public Response upload(@RequestParam("file")MultipartFile file, HttpServletRequest request) {
        String username = request.getParameter("username");
        String type = request.getParameter("type");
        String str = "";
        if ("1".equals(type)) {
            str = "teacher/" + username;
        } else if ("2".equals(type)) {
            str = "student/" + username;
        }
        if (!file.isEmpty()) {
            String saveFileName = file.getOriginalFilename();
            String filePath = "/upload/" + str + "/" + DateUtil.formatNowDate()+"-" + saveFileName;
            File saveFile = new File(request.getSession().getServletContext().getRealPath(filePath));
            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdirs();
            }
            try {
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
                out.write(file.getBytes());
                out.flush();
                out.close();
                return ResponseUtil.success(filePath);
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseUtil.error("500", "上传失败," + e.getMessage());
            }
        } else {
            return ResponseUtil.error("500", "上传失败，因为文件为空.");
        }
    }

    @GetMapping("/download")
    public void downloadFileAction(@RequestParam("address") String address, HttpServletRequest request,
                                   HttpServletResponse response) {
        String fileName = StringUtils.substring(address,address.lastIndexOf("/")+1);
        File file = new File(request.getSession().getServletContext().getRealPath(address));
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        try {
            response.setHeader("Content-Disposition", "attachment;filename="
                    + URLEncoder.encode(fileName, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(file));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
