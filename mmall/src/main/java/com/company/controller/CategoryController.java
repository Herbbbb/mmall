package com.company.controller;

import com.company.common.ServerResponse;
import com.company.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/11/28.
 */
@Controller
@RequestMapping("/manage/category/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "get_category.do" ,method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getChildrenNodes(@RequestParam(value = "categoryId",defaultValue = "0") Integer categoryId){
        return categoryService.getChildrenNodes(categoryId);
    }

    @RequestMapping("add_category.do")
    @ResponseBody
    public ServerResponse addCategoryChildNode(@RequestParam(value = "parentId",defaultValue = "0") Integer parentId,String categoryName){
        return categoryService.addCategoryChildNode(parentId,categoryName);
    }

    @RequestMapping("set_category_name.do")
    @ResponseBody
    public ServerResponse updateCategoryName(Integer categoryId,String categoryNmae){
        return categoryService.updateCategoryName(categoryId,categoryNmae);
    }

    @RequestMapping("get_deep_category.do")
    @ResponseBody
    public ServerResponse getCategoryIdAndChildrenNodes(Integer categoryId){
        return categoryService.getCategoryIdAndChildrenNodes(categoryId);
    }
}
