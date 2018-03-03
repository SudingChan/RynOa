package com.ken.rynoa.service.impl;

import com.ken.rynoa.dao.RyUserDao;
import com.ken.rynoa.model.RyUser;
import com.ken.rynoa.model.RyUserExample;
import com.ken.rynoa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author joseph
 * @create 2018-02-23 上午 10:46
 * @desc 用户业务逻辑层
 **/
@Service("UserService")
public class IUserServiceImpl implements IUserService {
    @Autowired
    private RyUserDao ryUserDao;

    /**
     * 注册方法
     * @param ryUser
     * @return
     */
    public boolean insertSelective(RyUser ryUser) {
        try{
           return ryUserDao.insertSelective(ryUser);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */
    public RyUser userLogin(String username, String password) {
        return ryUserDao.userLogin(username,password);
    }

    /**
     * 返回行记录
     * @param userExample
     * @return
     */
    public int countByExample(RyUserExample userExample) {
        try{
            return ryUserDao.countByExample(userExample);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
