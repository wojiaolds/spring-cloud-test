package com.lds.boot.dynamicdatasource.core;/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 13:38 2019/9/11
 */

import com.lds.boot.dynamicdatasource.annotation.TargetDataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * 创建一个AOP切面，拦截带 @TargetDataSource 注解的方法，在方法执行前切换至目标数据源，执行完成后恢复到默认数据源
 * @Author: lds
 * @Desc:
 * @Date: Create in 13:38 2019/9/11
 */

@Aspect
@Order(-1)  //保证该AOP在@Transactional之前执行
@Component
public class DynamicDataSourceAspect {

    /**
     * 切换数据源
     * @param point
     * @param dataSource
     */

    @Before("@annotation(dataSource))")
    public void switchDataSource(JoinPoint point, TargetDataSource dataSource) {
        if (!DynamicDataSourceContextHolder.containDataSourceKey(dataSource.value())) {
            System.out.println("DataSource [{}] doesn't exist, use default DataSource [{}] " + dataSource.value());
        } else {
            // 切换数据源
            DynamicDataSourceContextHolder.setDataSourceKey(dataSource.value());
            System.out.println("Switch DataSource to [" + DynamicDataSourceContextHolder.getDataSourceKey()
                    + "] in Method [" + point.getSignature() + "]");
        }
    }

    /**
     * 重置数据源
     * @param point
     * @param dataSource
     */
    @After("@annotation(dataSource))")
    public void restoreDataSource(JoinPoint point, TargetDataSource dataSource) {
        // 将数据源置为默认数据源
        DynamicDataSourceContextHolder.clearDataSourceKey();
        System.out.println("Restore DataSource to [" + DynamicDataSourceContextHolder.getDataSourceKey()
                + "] in Method [" + point.getSignature() + "]");
    }
}
