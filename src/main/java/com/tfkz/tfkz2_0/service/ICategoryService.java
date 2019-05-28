package com.tfkz.tfkz2_0.service;

import com.tfkz.tfkz2_0.common.ServerResponse;
import com.tfkz.tfkz2_0.pojo.Category;

/**
 *@Author teacher.wei
 * */
public interface ICategoryService {
    public ServerResponse<Category> getChilds(Integer parentId);
    public ServerResponse<Category> add(String name, Integer parentId);
    public ServerResponse<Category> updateName(String name, Integer categoryId);
    public ServerResponse<Category> getAllChilds(Integer parentId);
    public ServerResponse getDeepCategory(Integer parentId);
}
