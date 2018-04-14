package com.wh.workSubmission.controller;

import com.wh.workSubmission.annotation.IgnoreSecurity;
import com.wh.workSubmission.dto.Response;
import com.wh.workSubmission.service.LoginService;
import com.wh.workSubmission.service.TokenService;
import com.wh.workSubmission.util.ResponseUtil;
import com.wh.workSubmission.dto.User;
import com.wh.workSubmission.dto.PasswordVO;
import com.wh.workSubmission.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@RestController
@RequestMapping("")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private TokenService tokenService;

    @PostMapping(path = {"/","/login"})
    @IgnoreSecurity
    public Response login( @RequestBody Map<String, String> map) {
        String username = map.get("username");
        String password = map.get("password");
        User user = loginService.login(username, password);
        return ResponseUtil.success(user);
    }

    @PostMapping("/changePassword")
    public Response changePassword(@RequestBody PasswordVO passwordVO) {
        loginService.changePassword(passwordVO);
        return ResponseUtil.success();
    }

    @PostMapping("/logout")
    public Response logout() {
        return ResponseUtil.success();
    }
}
