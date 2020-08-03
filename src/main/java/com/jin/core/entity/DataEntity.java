package com.jin.core.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Description: DataEntity
 * @author: HuangJing
 * @create: 2020-08-03 17:07
 * @version: V1.0
 */
@JsonIgnoreProperties(value="newRecord", allowGetters = false, allowSetters = false)
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(exclude = {"creator", "gmtCreate"})
@Accessors(chain = true)
public class DataEntity extends BaseEntity implements Serializable {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JSONField(deserialize = false, serialize = false)
    @TableField(value = "creator", fill = FieldFill.INSERT)
    public String creator;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JSONField(deserialize = false)
    @TableField(value = "gmt_create", fill = FieldFill.INSERT)
    public LocalDateTime gmtCreate;
}
