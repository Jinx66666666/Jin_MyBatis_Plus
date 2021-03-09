package com.jin.sys.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.jin.core.entity.DataEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author Jin
 * @since 2020-06-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends DataEntity {

//    private static final long serialVersionUID=1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;
    //数据库为对应字段
    @TableField(exist = false)//为对应字段注解@TableField(exist = false)
    private String Jin;

/*    @TableLogic     //逻辑删除属性
    private Integer logic_flag;*/
    /**
     * 版本号
     */
    @Version
//    @TableField(fill = FieldFill.INSERT)
    private Integer version;


}
