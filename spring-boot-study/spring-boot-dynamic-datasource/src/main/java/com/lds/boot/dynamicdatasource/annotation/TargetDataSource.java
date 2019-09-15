package com.lds.boot.dynamicdatasource.annotation;/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 13:36 2019/9/11
 */

import java.lang.annotation.*;

/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 13:36 2019/9/11
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    /**
     * 数据源key值
     * @return
     */
    String value();
}
