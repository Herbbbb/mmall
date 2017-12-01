package com.company.service;

import com.company.common.ServerResponse;
import com.company.pojo.Category;

import java.util.List;

/**
 * Created by Administrator on 2017/11/28.
 */
public interface CategoryService {
    ServerResponse<List<Category>> getChildrenNodes(Integer categoryId);
    ServerResponse addCategoryChildNode(Integer parentId,String categoryName);
    ServerResponse updateCategoryName(Integer categoryId, String categoryNmae);
    ServerResponse<List<Integer>> getCategoryIdAndChildrenNodes(Integer categoryId);
}
