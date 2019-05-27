package com.tfkz.tfkz2_0.utils;


import com.tfkz.tfkz2_0.pojo.Product;
import com.tfkz.tfkz2_0.pojo.vo.ProductVO;

public class POJOtoVOUtils {
    /*product to productVO*/
    public static ProductVO getNew(Product product){
        ProductVO p = new ProductVO();
        p.setId(product.getId());
        p.setCategoryId(product.getCategoryId());
        p.setName(product.getName());
        p.setSubTitle(product.getSubtitle());
        p.setMainImage(product.getMainImage());
        p.setSubImages(product.getSubImages());
        p.setDetail(product.getDetail());
        p.setPrice(product.getPrice());
        p.setStock(product.getStock());
        p.setStatus(product.getStatus());
        p.setIsNew(product.getIsNew());
        p.setIsHot(product.getIsHot());
        p.setIsBanner(product.getIsBanner());
        p.setCreateTime(DateUtils.dateToStr(product.getCreateTime()));
        p.setUpdateTime(DateUtils.dateToStr(product.getUpdateTime()));
        //设置图片服务器
        p.setImageHost(PropertiesUtils.readByKey("imageHost"));
        return p;
    }
}
