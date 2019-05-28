package com.tfkz.tfkz2_0.service;

import com.tfkz.tfkz2_0.common.ServerResponse;

import javax.servlet.http.HttpSession;

public interface ICartService {
    /*购物车List列表*/
    ServerResponse getDetail(HttpSession session);

    /*购物车添加商品*/
    ServerResponse addNew(HttpSession session,Integer productId,Integer count);

    /*更新购物车某个产品数量*/
    ServerResponse updateCart(HttpSession session, Integer productId, Integer count);

    /*移除购物车某个产品数量*/
    ServerResponse deleteProduct(HttpSession session, String productIds);

    /*购物车选中某个商品*/
    ServerResponse selectProduct(HttpSession session, Integer productId);

    ServerResponse unSelectProduct(HttpSession session, Integer productId);

    ServerResponse getCartProductCount(HttpSession session);

    ServerResponse selectAllProduct(HttpSession session);

    ServerResponse unSelectAll(HttpSession session);
}
