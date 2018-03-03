package com.ken.rynoa.service;

import com.ken.rynoa.model.RyUser;
import com.ken.rynoa.model.RyUserExample;


/**
 * @author joseph
 * @create 2018-02-23 上午 10:26
 * @desc 业务接口
 **/

public interface IUserService {
    public boolean insertSelective(RyUser ryUser);
    public RyUser userLogin(String username,String password);
    public int countByExample(RyUserExample userExample);
}
