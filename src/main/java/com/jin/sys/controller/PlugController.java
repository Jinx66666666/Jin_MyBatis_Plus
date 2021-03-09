package com.jin.sys.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jin.sys.entity.User;
import com.jin.sys.mapper.UserMapper;
import com.jin.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @Resource
    private UserMapper userMapper;

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

    @GetMapping("/testPage")
    public void testPage() {
        //传入2个参数：当前页和每页显示记录数
        Page<User> page = new Page<>(1, 3);
        //调用mp分页查询方法，分页查询过程中，底层封装，把分页的所有数据封装到page对象里面
        userMapper.selectPage(page, null);
        System.out.println("当前页：" + page.getCurrent());
        System.out.println("每页数据的List集合：" + page.getRecords());
        System.out.println("每页显示的记录数：" + page.getSize());
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("总页数：" + page.getPages());
        System.out.println("是否有下一页: " + page.hasNext());
        System.out.println("是否有上一页：" + page.hasPrevious());//
    }
}
