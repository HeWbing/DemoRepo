package com.hwb.service.impl;

import com.hwb.bean.UserTest;
import com.hwb.dao.UserTestMapper;
import com.hwb.service.UserTestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by He on 2017/7/30.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class UserTestServiceImpl implements UserTestService {

    @Resource
    private UserTestMapper userTestMapper;


    public List<UserTest> getAllUser() {
        return  userTestMapper.selectAllUser();
    }

    public List<UserTest> getUserBySex(Long sex) {
        return  userTestMapper.selectUserBySex(sex);
    }

    public UserTest getUserById(Long userId) {
        return userTestMapper.selectUserById(userId);
    }
}
