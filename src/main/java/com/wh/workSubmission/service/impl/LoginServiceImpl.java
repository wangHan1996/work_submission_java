package com.wh.workSubmission.service.impl;

import com.wh.workSubmission.mapper.ClassesMapper;
import com.wh.workSubmission.dto.PasswordVO;
import com.wh.workSubmission.dto.User;
import com.wh.workSubmission.entity.Admin;
import com.wh.workSubmission.entity.Student;
import com.wh.workSubmission.entity.Teacher;
import com.wh.workSubmission.exception.WorkException;
import com.wh.workSubmission.mapper.AdminMapper;
import com.wh.workSubmission.mapper.StudentMapper;
import com.wh.workSubmission.mapper.TeacherMapper;
import com.wh.workSubmission.service.LoginService;
import com.wh.workSubmission.service.TokenService;
import com.wh.workSubmission.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private ClassesMapper classesMapper;
    @Autowired
    private TokenService tokenService;

    @Override
    public User login(String username, String password) {

        User user = new User();
        Admin admin = adminMapper.selectByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            user.setId(admin.getId());
            user.setType("0");
            user.setName(admin.getName());
            user.setUsername(username);
            String token = tokenService.createToken(user);
            user.setToken(token);
            return user;
        }
        Teacher teacher = teacherMapper.selectByUsername(username);
        if (teacher != null && teacher.getPassword().equals(password)) {
            user.setId(teacher.getId());
            user.setType("1");
            user.setUsername(username);
            user.setName(teacher.getName());
            String token = tokenService.createToken(user);
            user.setToken(token);
            return user;
        }
        Student student = studentMapper.selectByUsername(username);
        if (student != null && student.getPassword().equals(password)) {
            String professionId = studentMapper.selectProfessionId(student.getId());
            user.setId(student.getId());
            user.setType("2");
            user.setName(student.getName());
            user.setProfessionId(professionId);
            user.setSex(student.getSex());
            user.setClassesName(classesMapper.selectById(student.getClassesNo()).getClassesName());
            user.setUsername(username);
            String token = tokenService.createToken(user);
            user.setToken(token);
            return user;
        }
        throw new WorkException("用户名或密码错误");
    }

    @Override
    public void changePassword(PasswordVO passwordVO) {
        String id = passwordVO.getId();
        String oldPassword = passwordVO.getOldPassword();
        String newPassword = passwordVO.getNewPassword();
        switch (passwordVO.getType()) {
            case "0" : {
               Admin admin = adminMapper.selectById(id);
               if (admin != null && admin.getPassword().equals(oldPassword)) {
                   adminMapper.updatePassword(id, newPassword);
                   return;
               }
               break;
            }
            case "1" : {
                Teacher teacher = teacherMapper.selectById(id);
                if (teacher != null && teacher.getPassword().equals(oldPassword)) {
                    teacherMapper.updatePassword(id, newPassword);
                    return;
                }
                break;
            }
            case "2" : {
                Student student = studentMapper.selectById(id);
                if (student != null && student.getPassword().equals(oldPassword)) {
                    studentMapper.updatePassword(id, newPassword);
                    return;
                }
                break;
            }
            default : {
                break;
            }
        }
        throw new WorkException("原密码错误");
    }
}
