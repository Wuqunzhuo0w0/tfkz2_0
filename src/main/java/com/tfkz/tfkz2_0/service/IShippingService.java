package com.tfkz.tfkz2_0.service;


import com.tfkz.tfkz2_0.common.ServerResponse;
import com.tfkz.tfkz2_0.pojo.Shipping;

import javax.servlet.http.HttpSession;

/**
 *@Author teacher.wei
 * */
public interface IShippingService {
    public ServerResponse add(Integer userId, Shipping shipping);
    public ServerResponse del(Integer shippingId);
    public ServerResponse update(Shipping shipping);
    public ServerResponse select(Integer shippingId);
    public ServerResponse list(HttpSession session,Integer pageNum, Integer pageSize);

}
