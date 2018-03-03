package com.ken.rynoa.web;

import com.ken.rynoa.model.RyUser;
import com.ken.rynoa.model.RyUserExample;
import com.ken.rynoa.service.IUserService;
import com.ken.rynoa.utils.JwtUtil;
import com.ken.rynoa.utils.MD5Util;
import com.ken.rynoa.utils.ResponseData;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author joseph
 * @create 2018-02-08 下午 2:17
 * @desc 用户控制层
 **/
@Controller
@RequestMapping(value = "/user")
public class UserController {
    //注入service
    @Resource
    private IUserService IUserService;
    private ResponseData responseData;

    MD5Util md5Util = new MD5Util();

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData login(String username, String password, HttpServletRequest request) throws IOException, NoSuchAlgorithmException {
        Logger logger = Logger.getLogger(UserController.class);
        password = md5Util.EncoderByMD5(password);
        RyUser user= IUserService.userLogin(username,password);
        if(null != user){
           responseData = responseData.ok();
           responseData.putDataValue("loginId",user.getUid());
           responseData.putDataValue("username",user.getUsername());
            //给用户jwt加密生成token
            String token = JwtUtil.sign(user,60L*1000L*60L*10L);
            //封装成对象返回给客户端
            responseData.putDataValue("token",token);
           return responseData;
        } else {
            responseData = responseData.notFound();
            return responseData;
        }
    }

    /**
     * 用户注册
     * @param ryUser
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Map register(RyUser ryUser, HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=utf-8");//设置响应的编码格式，不然会出现中文乱码现象

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String loginRole = request.getParameter("loginRole");
        String newPass = md5Util.EncoderByMD5(password);

        Map<String,String> map = new HashMap<String,String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date nowday = new Date();

        if(!checkUsername(username) && !checkEmail(email)){
            ryUser.setUsername(username);
            ryUser.setEmail(email);
        }else if(checkUsername(username) && !checkEmail(email)){
            map.put("username",username);
            map.put("userError","用户名已存在");
            ryUser.setUsername("");
            return map;
        }else{
            map.put("username",username);
            map.put("userError","用户名已存在");
            map.put("email",email);
            map.put("emailError","邮箱地址已存在");
            ryUser.setUsername("");
            ryUser.setEmail("");
            return map;
        }
        ryUser.setPassword(newPass);
        ryUser.setLoginrole(loginRole);
        ryUser.setCreatetime(sdf.format(nowday));
        map.put("username",username);
        map.put("email",email);
        IUserService.insertSelective(ryUser);
        return map;
    }

    /**
     * 检查用户名是否存在
     *
     * @param username
     * @return
     */
    public boolean checkUsername(String username){
        boolean flag = false;
        RyUserExample userExample = new RyUserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        int num = IUserService.countByExample(userExample);
        if(num > 0){
            flag = true;
        }
        return flag;
    }

    /**
     * 检查邮箱是否存在
     * @param email
     * @return
     */
    public boolean checkEmail(String email){
        boolean flag = false;
        RyUserExample userExample = new RyUserExample();
        userExample.createCriteria().andEmailEqualTo(email);
        int num = IUserService.countByExample(userExample);
        if(num > 0){
            flag = true;
        }
        return flag;
    }

/*    public String checkPassword(String newPass, String oldPass) throws IOException, NoSuchAlgorithmException {
        if(md5Util.EncoderByMD5(newPass).equals(oldPass)) {
            return newPass;
        }
        return oldPass;
    }*/
}