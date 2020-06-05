package com.jin.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jin.sys.entity.User;
import com.jin.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jin
 * @since 2020-06-03
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {
    @Autowired
    private UserService service;
    @RequestMapping("/jin")
    private List getUserList(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        List<User> lists = service.list(new QueryWrapper<User>()
                .in("id",list)
//                .eq("id","2L")
        );
        return lists;
    }
    @RequestMapping("/jinx")
    private User getUserById(){
        User byId = service.getById(1);
        return byId;
    }
    @RequestMapping("/save")
    private void saveUser(){
        User user = new User();
        user.setAge(18);
        user.setName("Jin");
        user.setEmail("1215976530@qq.com");
        service.save(user);
    }
    @RequestMapping("/update")
    private void update(){
        User user = new User();
        user.setId(1L);
        user.setAge(18);
        user.setName("JinX");
        user.setEmail("1215976530@qq.com");
        service.updateById(user);
    }

}

