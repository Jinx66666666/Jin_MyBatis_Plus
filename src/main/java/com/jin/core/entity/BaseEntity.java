package com.jin.core.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.beans.Transient;

/**
 * @Description:
 * @author: HuangJing
 * @create: 2020-08-03 17:04
 * @version: V1.0
 */
public class BaseEntity extends Model {
    /**
     * 删除标记（0：正常；1：删除；）
     */
    @TableField(exist = false)
    public static final String DEL_FLAG_NORMAL = "0";
    @TableField(exist = false)
    public static final String DEL_FLAG_DELETE = "1";

    @JSONField(serialize = false,deserialize = false)
    @Transient
    public String getDbType() {
        return "mysql";
    }
}
