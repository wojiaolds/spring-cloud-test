package com.lds.boot.springbootscheduler.config;/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 0:07 2019/9/9
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 0:07 2019/9/9
 */
@EnableAsync
@EnableScheduling
@Configuration
public class SchedulerConfig {
    /**
     * 很关键：默认情况下 TaskScheduler 的 poolSize = 1
     *
     * @return 线程池
     */
    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setThreadNamePrefix("cus-");
        taskScheduler.setPoolSize(3);
        return taskScheduler;
    }
}
