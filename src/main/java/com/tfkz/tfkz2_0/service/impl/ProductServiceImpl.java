package com.tfkz.tfkz2_0.service.impl;


import com.tfkz.tfkz2_0.common.Const;
import com.tfkz.tfkz2_0.common.ServerResponse;
import com.tfkz.tfkz2_0.mapper.CategoryMapper;
import com.tfkz.tfkz2_0.mapper.ProductMapper;
import com.tfkz.tfkz2_0.pojo.Category;
import com.tfkz.tfkz2_0.pojo.Product;
import com.tfkz.tfkz2_0.pojo.vo.ProductVO;
import com.tfkz.tfkz2_0.service.IProductService;
import com.tfkz.tfkz2_0.utils.POJOtoVOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public ServerResponse getDetail(Integer productId, Integer is_new, Integer is_hot, Integer is_banner) {
        ServerResponse sr = null;
        System.out.println(productId+"             =-------------------------");
        //判断参数
        if(productId == null && is_new == null && is_hot == null && is_banner == null){
            sr = ServerResponse.createServerResponseByError(Const.ProductStatusEnum.ERROR_PAMAR.getCode(),Const.ProductStatusEnum.ERROR_PAMAR.getDesc());
            return sr;
        }


        if(productId == null){
            List<Product> productList = new ArrayList<>();
            List<ProductVO> voList = new ArrayList<>();
            //搜索最新商品
//            if(is_new ==1 || is_hot ==1 || is_banner == 1){
//                productList = productMapper.selectBys_NewAndIs_HotAndIs_Banner(is_new,is_hot,is_banner);
//            }
//
//            //参数都为0查询所有数据
//            if(is_new ==0 && is_hot ==0 && is_banner == 0){
//                productList = productMapper.selectAll();
//            }

            productList = productMapper.selectBys_NewAndIs_HotAndIs_Banner(is_new,is_hot,is_banner);

            if(productList == null){
                sr = ServerResponse.createServerResponseByError(Const.ProductStatusEnum.NO_PRODUCT.getCode(),Const.ProductStatusEnum.NO_PRODUCT.getDesc());
                return sr;
            }else{
                for (Product product : productList) {
                    //参数不为空_商品存在_校验商品状态
                    if(product.getStatus() != Const.ProductStatusEnum.PRODUCT_ONLINE.getCode()){
                        //商品不在售
                        sr = ServerResponse.createServerResponseByError(Const.ProductStatusEnum.NO_PRODUCT.getCode(),Const.ProductStatusEnum.NO_PRODUCT.getDesc());
                        return sr;
                    }else{
                        //商品在售，返回商品数据
                        //日期转换成字符串
                        ProductVO productVO = POJOtoVOUtils.getNew(product);
                        voList.add(productVO);
                    }
                }
                sr = ServerResponse.createServerResponseBySuccess(voList);
                return sr;
            }

        }else{

            Product product = null;
            //搜索最新商品
            if(is_new ==1 ){
                System.out.println("is_New==1");
                product = productMapper.selectByIdAndIs_New(productId,is_new);
            }
            //搜索最热商品
            else if(is_hot ==1 ){
                System.out.println("is_hot==1");
                product = productMapper.selectByIdAndIs_Hot(productId,is_hot);
                System.out.println(product.toString());
            }
            //搜索banner商品
            else if(is_banner == 1){
                System.out.println("is_banner==1");
                product = productMapper.selectByIdAndIs_Banner(productId,is_banner);
            }else{
                //搜索普通商品
                product = productMapper.selectByPrimaryKey(productId);
            }


            //参数不为空但商品不存在
            if(product == null){
                sr = ServerResponse.createServerResponseByError(Const.ProductStatusEnum.NO_PRODUCT.getCode(),Const.ProductStatusEnum.NO_PRODUCT.getDesc());
                return sr;
            }else{
                //参数不为空_商品存在_校验商品状态
                if(product.getStatus() != Const.ProductStatusEnum.PRODUCT_ONLINE.getCode()){
                    //商品不在售
                    sr = ServerResponse.createServerResponseByError(Const.ProductStatusEnum.NO_PRODUCT.getCode(),Const.ProductStatusEnum.NO_PRODUCT.getDesc());
                    return sr;
                }else{
                    //商品在售，返回商品数据
                    //日期转换成字符串
                    ProductVO productVO = POJOtoVOUtils.getNew(product);

                    sr = ServerResponse.createServerResponseBySuccess(productVO);
                    return sr;
                }
            }
        }
    }

    @Override
    public ServerResponse topcategory(Integer sid) {
        ServerResponse sr = null;
        List<Category> categories = categoryMapper.selectTopCategory(sid);
        sr = ServerResponse.createServerResponseBySuccess(categories);
        return sr;
    }

    @Override
    public ServerResponse getList(Integer categoryId, String keyword, Integer pageNum, Integer pageSize, String orderBy) {
        return null;
    }
}
