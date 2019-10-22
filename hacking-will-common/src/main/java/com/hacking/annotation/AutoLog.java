package com.hacking.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 *
 * </p>
 *
 * @author jintingying
 * @version 1.0
 * @date 2019/10/22
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AutoLog {

    enum OperateType {OTHER, SELECT, ADD, MODIFY, DELETE}
    /**
     * 日志内容
     *
     * @return
     */
    String context() default "";

    /**
     * 操作日志类型
     *
     * @return （1查询，2添加，3修改，4删除）
     */
    OperateType operateType() default OperateType.OTHER;
}
