package com.jin.sys.mapper;

import com.jin.sys.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Jin
 * @since 2020-06-03
 */
public interface UserMapper extends BaseMapper<User> {
    int deleteAll(Integer id);
}
