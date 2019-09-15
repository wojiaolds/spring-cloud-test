package com.lds.boot.dynamicdatasource.controller;/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 13:43 2019/9/11
 */

import com.lds.boot.dynamicdatasource.annotation.TargetDataSource;
import com.lds.boot.dynamicdatasource.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 13:43 2019/9/11
 */
@Api(value = "SysUserController")
@RestController
@RequestMapping("user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @ApiOperation(value = "所有用户信息")
    @TargetDataSource("slave")
    @RequestMapping(value="/findAll")
    public Object findAll() {
        return sysUserService.findAll();
    }

    @ApiOperation(value = "所有用户信息")
    @TargetDataSource("slave")
    @RequestMapping (value="/findAll2")
    public Object findAll2() {
        return sysUserService.findAll();
    }

}
