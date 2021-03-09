package com.jin.sys.controller;

import com.jin.sys.entity.User;
import com.jin.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Jin
 * @Date: 2021/3/9 10:05
 * @Description: Plug
 * @version: V1.0
 */
@RestController
@RequestMapping("/plug")
public class PlugController {

    @Autowired
    private UserService userService;

    /**
     * 乐观锁
     */
    @PostMapping("/update/{id}")
    public void updateVersion(@PathVariable("id") long id) {
        //查询
        User user = userService.getById(id);
        //查询
        user.setAge(20);
        //执行更新
        userService.updateById(user);

    }
}
