package com.wh.workSubmission.service;

import com.wh.workSubmission.dto.User;
import com.wh.workSubmission.dto.PasswordVO;

public interface LoginService {
    User login(String username, String password);

    void changePassword(PasswordVO passwordVO);
}
