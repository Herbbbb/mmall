package com.company.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/11/28.
 */
public class OrderProductInfoVo {
    private List<OrderItemVo> orderItemVoList;
    private String imageHost;
    private BigDecimal productTotalPrice;

    @Override
    public String toString() {
        return "OrderProductInfoVo{" +
                "orderItemVoList=" + orderItemVoList +
                ", imageHost='" + imageHost + '\'' +
                ", productTotalPrice=" + productTotalPrice +
                '}';
    }

    public List<OrderItemVo> getOrderItemVoList() {
        return orderItemVoList;
    }

    public void setOrderItemVoList(List<OrderItemVo> orderItemVoList) {
        this.orderItemVoList = orderItemVoList;
    }

    public String getImageHost() {
        return imageHost;
    }

    public void setImageHost(String imageHost) {
        this.imageHost = imageHost;
    }

    public BigDecimal getProductTotalPrice() {
        return productTotalPrice;
    }

    public void setProductTotalPrice(BigDecimal productTotalPrice) {
        this.productTotalPrice = productTotalPrice;
    }

    public OrderProductInfoVo() {

    }
}
