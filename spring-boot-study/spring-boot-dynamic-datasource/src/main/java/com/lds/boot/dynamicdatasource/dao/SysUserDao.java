package com.lds.boot.dynamicdatasource.dao;/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 13:46 2019/9/11
 */

import com.lds.boot.dynamicdatasource.bean.SysUser;

import java.util.List;

/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 13:46 2019/9/11
 */
public interface SysUserDao {
//    int deleteByPrimaryKey(Long id);
//
//    int insert(SysUser record);
//
//    int insertSelective(SysUser record);
//
//    SysUser selectByPrimaryKey(Long id);
//
//    int updateByPrimaryKeySelective(SysUser record);
//
//    int updateByPrimaryKey(SysUser record);

    List<SysUser> findAll();
}
