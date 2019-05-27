package com.tfkz.tfkz2_0.service;

import com.tfkz.tfkz2_0.common.ServerResponse;
import org.springframework.web.bind.annotation.RequestParam;

public interface IProductService {


    /*获取产品detail*/
    ServerResponse getDetail(Integer productId,
                             @RequestParam(required = false,defaultValue="0") Integer is_new,
                             @RequestParam(required = false,defaultValue="0") Integer is_hot,
                             @RequestParam(required = false,defaultValue="0") Integer is_banner);

    /*获取产品顶级分类*/
    ServerResponse topcategory(Integer sid);
}
