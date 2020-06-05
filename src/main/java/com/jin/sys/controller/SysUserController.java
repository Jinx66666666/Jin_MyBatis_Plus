package com.jin.sys.controller;


import com.jin.sys.entity.SysUser;
import com.jin.sys.entity.User;
import com.jin.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jin
 * @since 2020-06-03
 */
@RestController
@RequestMapping("/sys/sys-user")
public class SysUserController {

    @Autowired
    private SysUserService service;
    @RequestMapping("/jinx")
    private SysUser getUserById(){
        SysUser byId = service.getById(1);
        return byId;
    }

}

