package com.jin.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jin.sys.entity.User;
import com.jin.sys.model.Result;
import com.jin.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Jin
 * @since 2020-06-03
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping("/jin")
    private List getUserList() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        List<User> lists = service.list(new QueryWrapper<User>()
                        .in("id", list)
//                .eq("id","2L")
        );
        return lists;
    }

    @RequestMapping("/jinx/{id}")
    private User getUserById(@PathVariable("id") long id) {
        User byId = service.getById(id);
        return byId;
    }

    @RequestMapping("/save")
    private void saveUser() {
        User user = new User();
        user.setAge(18);
        user.setName("Jin");
        user.setEmail("1215976530@qq.com");
        user.setJin("数据库未对应字段");
        service.save(user);
    }

    @RequestMapping("/update/{id}")
    private void update(@PathVariable("id") long id) {
        User user = new User();
        user.setId(id);
        user.setAge(18);
        user.setName("JinX");
        user.setEmail("1215976530@qq.com");
        service.updateById(user);
    }

    @RequestMapping("/delete")
    private void delete(@RequestParam("id") long id) {

        service.removeById(id);
    }

    //Mapper CRUD接口
    @RequestMapping("/insert")
    public void insert() {
        service.insertUser();
    }

    /**
     * 通过多个ID查询
     */
    @RequestMapping("/selectBatchIds")
    public Result selectBatchIds() {

        List<User> userList = service.selectBatchIds();

        return Result.ok("获取成功", userList);

    }

    /**
     * 通过Map封装条件查询
     */

    @RequestMapping("/selectByMap")
    public Result selectByMap() {

        List<User> userList = service.selectByMap();

        return Result.ok("获取成功", userList);

    }

    /**
     * 通过Map封装条件查询
     */

    @RequestMapping("/selectPage")
    public Result selectPage() {

        List<User> userList = service.selectPage();

        return Result.ok("获取成功", userList);

    }

    /**
     * 根据条件进行删除
     */
    @RequestMapping("/deleteByMap")
    public Result deleteByMap() {

        service.deleteByMap();

        return Result.ok("获取成功");

    }

    /**
     * 条件构造器
     */
    @RequestMapping("/entityWrapperSelect")
    public Result entityWrapperSelect() {

        List<User> userList = service.entityWrapperSelect();

        return Result.ok("获取成功", userList);

    }

    @RequestMapping("/entityWrapperUpdate")
    public Result entityWrapperUpdate() {

        service.entityWrapperUpdate();

        return Result.ok("获取成功");

    }

    /**
     * 统计查询
     */
    @RequestMapping("/selectCount")
    public Result selectCount() {

        Integer count = service.selectCount();

        return Result.ok("获取成功", count);

    }

    /**
     * 统计查询
     */
    @RequestMapping("/deleteFlag")
    public Result deleteFlag() {

        Integer count = service.deleteFlag();

        return Result.ok("删除成功", count);

    }


}

