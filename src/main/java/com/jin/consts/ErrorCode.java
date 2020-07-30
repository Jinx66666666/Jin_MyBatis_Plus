package com.jin.consts;

/**
 * @Description: 错误码
 * @author: HuangJing
 * @create: 2020-07-30 12:01
 * @version: V1.0
 */
public interface ErrorCode {
    int OK = 0;

    int COMMON_ERROR = 10000;


    int UNAUTHORIZED_ERROR = 40001;
    int FORBIDDEN_ERROR = 40003;

    int INTERNAL_SERVER_ERROR = 50000;

    int VALIDATION_ERROR = 30000;
}
