package com.ken.rynoa.service;

import com.ken.rynoa.model.RyUser;
import com.ken.rynoa.model.RyUserExample;
import com.ken.rynoa.model.RyUserinfo;


/**
 * @author joseph
 * @create 2018-02-23 上午 10:26
 * @desc 业务接口
 **/

public interface IUserService {
    //用户注册接口
    boolean insertSelective(RyUser ryUser);
    //用户登录接口
    RyUser userLogin(String username,String password);
    //返回用户表记录行接口
    int countByExample(RyUserExample userExample);
    //插入用户信息接口
    int insertSelective(RyUserinfo record);

}
