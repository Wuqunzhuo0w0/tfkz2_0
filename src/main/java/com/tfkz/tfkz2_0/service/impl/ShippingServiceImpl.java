package com.tfkz.tfkz2_0.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.tfkz.tfkz2_0.common.Const;
import com.tfkz.tfkz2_0.common.ServerResponse;
import com.tfkz.tfkz2_0.mapper.ShippingMapper;
import com.tfkz.tfkz2_0.pojo.Shipping;
import com.tfkz.tfkz2_0.pojo.UserInfo;
import com.tfkz.tfkz2_0.service.IShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShippingServiceImpl implements IShippingService {
    @Autowired
    private ShippingMapper shippingMapper;

    @Override
    public ServerResponse add(Integer userId, Shipping shipping){
        if(shipping == null){
           return ServerResponse.createServerResponseByError("参数错误");
        }
        shipping.setUserId(userId);

        if(shipping.getId() == null){
            return ServerResponse.createServerResponseBySuccess(1,"新建地址失败");//新件地址成功但id未定定义
        }
        shippingMapper.insert(shipping);
        Map<String,Integer> map = new HashMap<>();
        map.put("shippingId",shipping.getId());
        return ServerResponse.createServerResponseBySuccess(map,"新建地址成功");
    }

    @Override
    public ServerResponse del(Integer shippingId){
        if(shippingId == null){
            return ServerResponse.createServerResponseByError("参数不能为空");
        }
        int flag = shippingMapper.deleteByPrimaryKey(shippingId);
        if (flag > 0){
            return ServerResponse.createServerResponseBySuccess("删除地址成功");
        }
        return ServerResponse.createServerResponseByError(1,"删除地址失败");
    }

    @Override
    public ServerResponse update(Shipping shipping){
        if(shipping == null || shipping.getId() == null){
            return ServerResponse.createServerResponseByError("参数错误");
        }
        int flag = shippingMapper.updateByPrimaryKeySelective(shipping);
        if(flag > 0){
            return ServerResponse.createServerResponseBySuccess("更新地址成功");
        }
        return  ServerResponse.createServerResponseBySuccess(1,"更新地址失败");
    }

    @Override
    public ServerResponse select(Integer shippingId){
        if(shippingId == null){
            return ServerResponse.createServerResponseByError("参数不能为空");
        }
        Shipping shipping = shippingMapper.selectByPrimaryKey(shippingId);
        return ServerResponse.createServerResponseBySuccess(shipping);
    }

    @Override
    public ServerResponse list(HttpSession session,Integer pageNum, Integer pageSize){
        UserInfo ui = (UserInfo) session.getAttribute(Const.RoleEnum.ROLE_CUSTOMER.getDesc());
        if(ui == null){
            ServerResponse sr = ServerResponse.createServerResponseByError(Const.ReponseCodeEnum.FORCE_EXIT.getCode(),Const.ReponseCodeEnum.FORCE_EXIT.getDesc());
            return sr;
        }else{
            PageHelper.startPage(pageNum,pageSize);
            List<Shipping> shippingList = shippingMapper.selectAll(ui.getId());
            PageInfo pageInfo = new PageInfo(shippingList);
            return ServerResponse.createServerResponseBySuccess(pageInfo);
        }

    }

}
