package com.lds.boot.rediscache.monitor;/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 18:31 2019/9/8
 */

import com.zaxxer.hikari.HikariConfigMXBean;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariPoolMXBean;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;


/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 18:31 2019/9/8
 */
@Endpoint(id = "hikariCP")
public class HikariCPEndpoint {
    HikariDataSource dataSource;

    public HikariCPEndpoint(HikariDataSource dataSource){
        this.dataSource = dataSource;
    }

    @ReadOperation
    public Map<String,Object> info(){

        HashMap<String,Object> hashMap =  new HashMap<>();

        HikariConfigMXBean configBean = dataSource.getHikariConfigMXBean();
        //最大连接数
        hashMap.put("total",configBean.getMaximumPoolSize());

        HikariPoolMXBean mxBean = dataSource.getHikariPoolMXBean();
        hashMap.put("active",mxBean.getActiveConnections());
        hashMap.put("idle",mxBean.getIdleConnections());
        //等待获取连接的线程个数
        hashMap.put("threadWait",mxBean.getThreadsAwaitingConnection());

        return hashMap;
    }

    @WriteOperation
    public void setMax(int max){
        dataSource.getHikariConfigMXBean().setMaximumPoolSize(max);

    }

}
