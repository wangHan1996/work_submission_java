package com.wh.workSubmission.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.wh.workSubmission.annotation.Access;
import com.wh.workSubmission.dto.Response;
import com.wh.workSubmission.entity.Profession;
import com.wh.workSubmission.util.ResponseUtil;
import com.wh.workSubmission.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author null123
 * @since 2018-04-07
 */
@RestController
@RequestMapping("/profession")
public class ProfessionController {

    @Autowired
    private ProfessionService professionService;

    @GetMapping("")
    public Response findAll(@RequestParam(value = "currentPage") String currentPage,
                            @RequestParam(value = "size") String size,
                            @RequestParam(value = "keyword") String keyword,
                            @RequestParam(value = "type",required = false) String type,
                            @RequestParam(value = "id",required = false) String id) {
        Page page = new Page(Integer.parseInt(currentPage),Integer.parseInt(size));
        Page<Profession> professionPage = professionService.findAll(page, keyword, type, id);
        return ResponseUtil.success(professionPage);
    }

    @GetMapping("/{id}")
    public Response getOne(@PathVariable("id") String id) {
        Profession profession = professionService.selectById(id);
        return ResponseUtil.success(profession);
    }

    @PostMapping("")
    @Access(authorities = {"0"})
    public Response addProfession(@RequestBody Profession profession) {
        professionService.addProfession(profession);
        return ResponseUtil.success();
    }

    @DeleteMapping("/{id}")
    @Access(authorities = {"0"})
    public Response deleteOne(@PathVariable("id") String id) {
        professionService.deleteById(id);
        return ResponseUtil.success();
    }

    @PutMapping("")
    @Access(authorities = {"0"})
    public Response updateCourse(@RequestBody Profession profession) {
        professionService.updateProfession(profession);
        return ResponseUtil.success();
    }
}

