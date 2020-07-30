package com.jin.sys.service;

import com.jin.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Jin
 * @since 2020-06-03
 */
public interface UserService extends IService<User> {

    void insertUser();

    List<User> selectBatchIds();

    List<User> selectByMap();

    List<User> selectPage();

    void deleteByMap();
}
