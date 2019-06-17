package com.tfkz.tfkz2_0.controller;


import com.tfkz.tfkz2_0.common.Const;
import com.tfkz.tfkz2_0.common.ServerResponse;
import com.tfkz.tfkz2_0.pojo.Shipping;
import com.tfkz.tfkz2_0.pojo.UserInfo;
import com.tfkz.tfkz2_0.service.IShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 *@Author teacher.wei
 * */
@RestController
@RequestMapping(value = "/portal/shipping/")
public class ShippingController {
    @Autowired
   private IShippingService shippingService;

    /**
     * 添加地址
     * @param session
     * @param shipping
     * @return
     */
    @PostMapping("add.do")
    public ServerResponse add(HttpSession session, Shipping shipping){

        UserInfo userInfo = (UserInfo) session.getAttribute(Const.RoleEnum.ROLE_CUSTOMER.getDesc());
        System.out.println(userInfo.getId()+"进来");
        return shippingService.add(userInfo.getId(),shipping);
        /*
        return shippingService.add(1,shipping);
        */
    }

    @GetMapping("del.do")
    public ServerResponse del(Integer shippingId){
        return shippingService.del(shippingId);
    }

    @PostMapping("update.do")
    public ServerResponse update(Shipping shipping){
        return shippingService.update(shipping);
    }

    @GetMapping("select.do")
    public ServerResponse select(Integer shippingId){
        return shippingService.select(shippingId);
    }

    @GetMapping("list.do")
    public ServerResponse list( HttpSession session,
                                @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                               @RequestParam(value = "pageSize",required = false,defaultValue = "10")Integer pageSize){

        return shippingService.list(session,pageNum,pageSize);
    }
}
