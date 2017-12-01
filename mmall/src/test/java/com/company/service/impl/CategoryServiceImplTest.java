package com.company.service.impl;

import com.company.common.ServerResponse;
import com.company.pojo.Category;
import com.company.service.CategoryService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2017/11/28.
 */
public class CategoryServiceImplTest {
    //private Logger logger = LoggerFactory.getLogger(CategoryServiceImplTest.class);
//    @Autowired
    CategoryService categoryService = null;
    ApplicationContext ctx = null;

    @Before
    public void testSetUp() {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
         categoryService = ctx.getBean(CategoryService.class);

    }

    @Test
    public void testGetChildrenNodes() throws Exception {
        System.out.println(categoryService);
        ServerResponse<List<Category>> listServiceResponse = categoryService.getChildrenNodes(100001);
        System.out.println(listServiceResponse);
    }

    @Test
    public void testAddCategoryChildNode() throws Exception {
        ServerResponse serviceResponse = categoryService.addCategoryChildNode(100001,"aa");
        System.out.println(serviceResponse);
    }

    @Test
    public void testUpdateCategoryName() throws Exception {
        ServerResponse serviceResponse = categoryService.updateCategoryName(100051,"bb");
        System.out.println(serviceResponse);
    }

    @Test
    public void testGetCategoryIdAndChildrenNodes() throws Exception {
        ServerResponse<List<Integer>> serviceResponse = categoryService.getCategoryIdAndChildrenNodes(100001);
        System.out.println(serviceResponse);
        List<Integer> integers = serviceResponse.getData();
        for(Integer a : integers){
            System.out.println(a);
        }
    }

}