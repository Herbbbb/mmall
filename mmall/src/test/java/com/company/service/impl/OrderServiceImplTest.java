package com.company.service.impl;

import com.company.service.CategoryService;
import com.company.service.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/11/30.
 */
public class OrderServiceImplTest {
    OrderService orderService = null;
    ApplicationContext ctx = null;

    @Before
    public void setUp() throws Exception {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        orderService = ctx.getBean(OrderService.class);
    }

    @Test
    public void testCreateOrder() throws Exception {
        System.out.println(orderService.createOrder(21,4));
    }

    @Test
    public void testGetOrderProduct() throws Exception {
        System.out.println(orderService.getOrderDetail(1,1492091003128l));
    }

    @Test
    public void testGetOrderList() throws Exception {
        System.out.println(orderService.getOrderList(1,10,1));

    }

    @Test
    public void testGetOrderDetail() throws Exception {
        System.out.println(orderService.getOrderDetail(1,1492091003128l));

    }

    @Test
    public void testCancelOrder() throws Exception {
        System.out.println(orderService.cancelOrder(1,1492091051313l));

    }

    @Test
    public void testManageOrderList() throws Exception {
        System.out.println(orderService.getOrderList(1,1,5));
    }

    @Test
    public void testManageSearchByOrderNo() throws Exception {
        System.out.println(orderService.manageSearchByOrderNo(1,5,1492091051313l));

    }

    @Test
    public void testManageOrderDetail() throws Exception {
        System.out.println(orderService.manageOrderDetail(1492091051313l));

    }

    @Test
    public void testManagerOrderSendGood() throws Exception {

    }
}