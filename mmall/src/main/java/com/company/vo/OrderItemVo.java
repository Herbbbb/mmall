package com.company.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/11/28.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class OrderItemVo {
    private Long orderNo;
    private Integer prductId;
    private String productName;
    private String prodduceImage;
    private BigDecimal currentUnitPrice;
    private Integer quantity;
    private BigDecimal totalPrice;
    private String createTime;

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getPrductId() {
        return prductId;
    }

    public void setPrductId(Integer prductId) {
        this.prductId = prductId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProdduceImage() {
        return prodduceImage;
    }

    public void setProdduceImage(String prodduceImage) {
        this.prodduceImage = prodduceImage;
    }

    public BigDecimal getCurrentUnitPrice() {
        return currentUnitPrice;
    }

    public void setCurrentUnitPrice(BigDecimal currentUnitPrice) {
        this.currentUnitPrice = currentUnitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public OrderItemVo() {

    }

    @Override
    public String toString() {
        return "OrderItemVo{" +
                "orderNo=" + orderNo +
                ", prductId=" + prductId +
                ", productName='" + productName + '\'' +
                ", prodduceImage='" + prodduceImage + '\'' +
                ", currentUnitPrice=" + currentUnitPrice +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
