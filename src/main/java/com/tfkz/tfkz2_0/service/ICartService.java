package com.tfkz.tfkz2_0.service;

import com.tfkz.tfkz2_0.common.ServerResponse;

import javax.servlet.http.HttpSession;

public interface ICartService {
    /*购物车List列表*/
    ServerResponse getDetail(HttpSession session);

    /*购物车添加商品*/
    ServerResponse addNew(HttpSession session,Integer productId,Integer count);
}
