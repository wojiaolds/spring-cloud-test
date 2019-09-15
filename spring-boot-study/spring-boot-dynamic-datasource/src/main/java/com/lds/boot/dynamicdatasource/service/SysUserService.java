package com.lds.boot.dynamicdatasource.service;/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 13:50 2019/9/11
 */

import com.lds.boot.dynamicdatasource.bean.SysUser;

import java.util.List;

/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 13:50 2019/9/11
 */
public interface SysUserService {
    /**
     * 查找全部用户信息
     * @return
     */
    List<SysUser> findAll();
}
