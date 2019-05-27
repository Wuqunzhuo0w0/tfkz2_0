package com.tfkz.tfkz2_0.controller;


import com.tfkz.tfkz2_0.common.ServerResponse;
import com.tfkz.tfkz2_0.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author teacher.guo
 * */
@RestController
@RequestMapping(value = "/portal/product/")
public class ProductController {
    @Autowired
    private IProductService productService;



    /*获取产品detail*/
    @RequestMapping("detail.do")
    public ServerResponse getDetail(Integer productId,
                                    @RequestParam(required = false,defaultValue="0") Integer is_new,
                                    @RequestParam(required = false,defaultValue="0") Integer is_hot,
                                    @RequestParam(required = false,defaultValue="0") Integer is_banner){
        ServerResponse sr = productService.getDetail(productId,is_new,is_hot,is_banner);

        return sr;
    }

    /*获取产品分类*/
    @CrossOrigin
    @RequestMapping("topcategory.do")
    public ServerResponse topcategory(@RequestParam(required = false,defaultValue="0") Integer sid){
        ServerResponse sr = productService.topcategory(sid);

        return sr;
    }


}
