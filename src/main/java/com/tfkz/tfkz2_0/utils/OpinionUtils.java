package com.tfkz.tfkz2_0.utils;

import com.tfkz.tfkz2_0.common.Const;
import com.tfkz.tfkz2_0.common.ServerResponse;
import com.tfkz.tfkz2_0.pojo.UserInfo;

import javax.servlet.http.HttpSession;

/*
* 一系列判断工具类
* by zhangxin
* */
public class OpinionUtils {
    /*字符串非空判断*/
    public static boolean emptyString(String obj){
        boolean flag = true;
        if(obj == null || obj.equals("") || obj.length()==0){
            flag =  false;
        }
        return flag;
    }

    /*判断登录状态*/
    /*统一判断登录状态*/
    public static ServerResponse isSession(HttpSession session){
        ServerResponse sr = null;
        UserInfo ui = (UserInfo) session.getAttribute(Const.RoleEnum.ROLE_CUSTOMER.getDesc());
        if (ui == null){
            sr = ServerResponse.createServerResponseByError(Const.CartCheckedEnum.NO_SESSION.getCode(),Const.CartCheckedEnum.NO_SESSION.getDesc());
        }else{
            sr = ServerResponse.createServerResponseBySuccess();
        }
        return sr;
    }

    /*获取登录用户ID*/
    public static Integer getUID(HttpSession session){
        UserInfo ui = (UserInfo) session.getAttribute(Const.RoleEnum.ROLE_CUSTOMER.getDesc());
        System.out.println(ui.getId()+" ------------------------");
        return ui.getId();
    }
}
