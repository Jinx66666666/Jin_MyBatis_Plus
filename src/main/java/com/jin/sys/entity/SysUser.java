package com.jin.sys.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class SysUser implements Serializable {

    private static final long serialVersionUID=1L;
/**
 *  @TableId
 *   value :指定表中的主键列的列名，如果实体属性名与列名一致，可以省略不指定，
 *   type：指定主键策略
 */
    /**
     * 主键ID
     */
    @TableId
//    @TableField(value = "sys_id")
    private Long sysId;

    /**
     * 姓名
     */
    private String sysName;

    /**
     * 年龄
     */
    private Integer sysAge;

    /**
     * 邮箱
     */
    private String sysEmail;


}
