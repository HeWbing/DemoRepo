package com.hwb.dao;

import com.hwb.bean.UserTest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by He on 2017/7/30.
 */
@Repository
public interface UserTestMapper {
    UserTest selectUserById(@Param("userId") Long userId);

    List<UserTest> selectUserBySex(@Param("sex") Long sex);

    List<UserTest> selectAllUser();
}
