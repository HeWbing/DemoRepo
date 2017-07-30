package com.hwb.service;

import com.hwb.bean.UserTest;

import java.util.List;

/**
 * Created by He on 2017/7/30.
 */
public interface UserTestService {
    List<UserTest> getAllUser();

    List<UserTest> getUserBySex(Long sex);

    UserTest getUserById(Long userId);
}
