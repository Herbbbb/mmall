package com.company.service.impl;

import com.company.common.ServerResponse;
import com.company.dao.CategoryMapper;
import com.company.pojo.Category;
import com.company.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/11/28.
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public ServerResponse<List<Category>> getChildrenNodes(Integer categoryId) {
        List<Category> categoryList = categoryMapper.getChildrenNodes(categoryId);
        if(categoryList == null || categoryList.size() == 0){
            return ServerResponse.createByErrorMessage("未找到该品类");
        }
        return ServerResponse.createBySuccess(categoryList);
    }

    @Override
    public ServerResponse addCategoryChildNode(Integer parentId, String categoryName) {
        Category category = new Category();
        category.setParentId(parentId);
        category.setName(categoryName);
        int result = categoryMapper.insertSelective(category);
        if(result == 0){
            return ServerResponse.createByErrorMessage("添加品类失败");
        }
        return ServerResponse.createBySuccessMessage("添加品类成功");
    }

    @Override
    public ServerResponse updateCategoryName(Integer categoryId, String categoryNmae) {
        Category category = new Category();
        category.setId(categoryId);
        category.setName(categoryNmae);
        int result = categoryMapper.updateByPrimaryKeySelective(category);
        if(result == 0){
            return ServerResponse.createByErrorMessage("更新品类名字失败");
        }
        return ServerResponse.createBySuccessMessage("更新品类名字成功");
    }

    @Override
    public ServerResponse<List<Integer>> getCategoryIdAndChildrenNodes(Integer categoryId) {
        Set<Integer> resultSet = new HashSet<Integer>();
        findChildren(resultSet,categoryId);

        List<Integer> integerList = new ArrayList<Integer>();
        integerList.addAll(resultSet);
        return ServerResponse.createBySuccess(integerList);
    }

    public Set<Integer> findChildren(Set<Integer> resultSet,Integer parentId){
        Category category = categoryMapper.selectByPrimaryKey(parentId);
        if(category != null){
            resultSet.add(parentId);
        }
        List<Integer> resultList = categoryMapper.selectChildrenNodes(parentId);
        for(Integer result : resultList){
            findChildren(resultSet,result);
        }
        return resultSet;
    }
}
