package com.lds.boot.dynamicdatasource.service.impl;/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 13:51 2019/9/11
 */

import com.lds.boot.dynamicdatasource.bean.SysUser;
import com.lds.boot.dynamicdatasource.dao.SysUserDao;
import com.lds.boot.dynamicdatasource.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.List;

/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 13:51 2019/9/11
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;

    /**
     * 查找全部用户信息
     * @return
     */
    public List<SysUser> findAll() {
        return sysUserDao.findAll();
    }
}
