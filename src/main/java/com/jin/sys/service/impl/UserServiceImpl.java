package com.jin.sys.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jin.sys.entity.User;
import com.jin.sys.mapper.UserMapper;
import com.jin.sys.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jin
 * @since 2020-06-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public void insertUser() {
        User user = new User();
//        user.setId(1L);
        user.setAge(18);
        user.setName("JinX");
        user.setEmail("1215976530@qq.com");
        int i = userMapper.insert(user);
        System.out.println("dasfddddddddddddddddddddddddddddd"+i);
        Long id = user.getId();
        System.out.println(id);
    }

    @Override
    public List<User> selectBatchIds() {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<User> users = userMapper.selectBatchIds(list);
        return users;
    }

    @Override
    public List<User> selectByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name","Jin");
        map.put("age",18);
        List<User> users = userMapper.selectByMap(map);

        return users;
    }

    @Override
    public List<User> selectPage() {
        List<User> userPage = (List<User>) userMapper.selectPage(new Page<>(3, 2), null);
        return userPage;
    }

    @Override
    public void deleteByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name","aaa");
        map.put("age",18);
        int i = userMapper.deleteByMap(map);
        System.out.println("======================"+i);
    }
}
