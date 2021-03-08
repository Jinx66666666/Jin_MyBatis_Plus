package com.jin.handlers;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.jin.core.entity.DataEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Description: 字段数据自动填充
 * @author: HuangJing
 * @create: 2020-08-03 16:00
 * @version: V1.0
 */
@Slf4j
@Component
public class DataEntityMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        if (!(metaObject.getOriginalObject() instanceof DataEntity)) {
            return;
        }

        DataEntity entity = (DataEntity) metaObject.getOriginalObject();
        entity.setCreator("Jin");
        entity.setGmtCreate(LocalDateTime.now());
        entity.setGmtModified(LocalDateTime.now());

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.setFieldValByName("gmtModified", LocalDateTime.now(), metaObject);
    }
}
