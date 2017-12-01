package com.company.service;

import com.company.common.ServerResponse;
import com.company.vo.OrderItemVo;
import com.company.vo.OrderProductInfoVo;
import com.company.vo.OrderVo;
import com.github.pagehelper.PageInfo;

/**
 * Created by Administrator on 2017/11/28.
 */
public interface OrderService {
    ServerResponse<OrderVo> createOrder(Integer userId, Integer shippingId);
    ServerResponse<OrderProductInfoVo> getOrderProduct(Integer userId);
    ServerResponse<PageInfo<OrderVo>> getOrderList(Integer userId,Integer pageSize,Integer pageNum);
    ServerResponse<OrderVo> getOrderDetail(Integer userId,Long orderNo);
    ServerResponse cancelOrder(Integer userId,Long orderNo);

    ServerResponse<PageInfo<OrderVo>> manageOrderList(Integer pageSize,Integer pageNum);
    ServerResponse<PageInfo<OrderVo>> manageSearchByOrderNo(Integer pageSize,Integer pageNum,Long orderNo);
    ServerResponse<OrderVo> manageOrderDetail(Long orderNo);
    ServerResponse managerOrderSendGood(Long orderNo);
}
