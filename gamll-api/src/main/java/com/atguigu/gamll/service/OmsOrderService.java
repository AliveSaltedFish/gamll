package com.atguigu.gamll.service;

import com.atguigu.gamll.beans.OmsOrder;

public interface OmsOrderService {
    String getTradeCode(String memberId);

    Boolean checkTradeCode(String tradeCode,String memberId);

    void addOrder(OmsOrder order);

    boolean checkOrder(String memberId, String orderSn);

    OmsOrder getOrderByOrderSn(String orderSn);

    void updateProcessStatus(OmsOrder order);

    void sendOrderPayQueue(String orderSn);
}
