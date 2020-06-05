package com.jin.sys.entity;

import java.io.Serializable;

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
     * 主键ID
     */
//    @TableId
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
