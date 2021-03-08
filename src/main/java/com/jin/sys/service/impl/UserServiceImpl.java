package com.jin.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jin.sys.entity.User;
import com.jin.sys.mapper.UserMapper;
import com.jin.sys.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Jin
 * @since 2020-06-03
 */
@Slf4j
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
        System.out.println("dasfddddddddddddddddddddddddddddd" + i);
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
        map.put("name", "Jin");
        map.put("age", 18);
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
        map.put("name", "aaa");
        map.put("age", 18);
        int i = userMapper.deleteByMap(map);
        System.out.println("======================" + i);
    }

    @Override
    public List<User> entityWrapperSelect() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Jin");


        QueryWrapper<User> queryWrapper = Wrappers.query();
//        List<User> users = userMapper.selectList(queryWrapper.select("name","age").allEq(map));
        //查询姓名为Jack的数据
        List<User> users = userMapper.selectList(queryWrapper.like("name", "Jack").eq("age", 20).or().like("name", "Jin"));

        return users;
    }

    @Override
    public void entityWrapperUpdate() {
        User user = new User();
        user.setName("JinX");
        user.setAge(20);
        userMapper.update(user, new UpdateWrapper<User>().eq("name", "Jin").eq("age", 18));

    }

    @Override
    public Integer selectCount() {
        Integer integer = userMapper.selectCount(new QueryWrapper<User>().eq("name", "Jin"));
        return integer;
    }

    @Override
    public Integer deleteFlag() {
        int i = userMapper.deleteById(12);
        return i;
    }


}
