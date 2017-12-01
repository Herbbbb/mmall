package com.company.dao;

import com.company.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectByUserId(Integer userId);

    Order selectByOrderNoUserId(@Param(value = "userId") Integer userId,@Param(value = "orderNo") Long orderNo);

    List<Order> selectAllOrder();

    Order selectByOrderNo(Long orderNo);
}
