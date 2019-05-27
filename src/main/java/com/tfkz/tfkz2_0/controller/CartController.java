package com.tfkz.tfkz2_0.controller;


import com.tfkz.tfkz2_0.common.ServerResponse;
import com.tfkz.tfkz2_0.service.ICartService;
import com.tfkz.tfkz2_0.utils.OpinionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping(value = "/portal/cart/")
public class CartController {
    @Autowired
    private ICartService cartService;

    /*购物车List列表*/
    @RequestMapping("list.do")
    public ServerResponse getDetail(HttpSession session){
        ServerResponse sr = OpinionUtils.isSession(session);
        //判断登录状态
        if(sr.isSuccess()){
            sr = cartService.getDetail(session);
            return sr;
        }else{
            return sr;
        }
    }

    /*购物车添加商品*/
    @RequestMapping("add.do")
    public ServerResponse addCart(HttpSession session,Integer productId,Integer count){
        ServerResponse sr = OpinionUtils.isSession(session);
        //判断登录状态
        if(sr.isSuccess()){
            sr = cartService.addNew(session,productId,count);
            return sr;
        }else{
            return sr;
        }
    }


}
