package com.atguigu.gamll.service;

import com.atguigu.gamll.beans.OmsCartItem;

import java.util.List;

public interface PmsCartService {
    void addToCart(OmsCartItem omsCartItem);

    List<OmsCartItem> cartList(String memberId);

    List<OmsCartItem> checkCart(OmsCartItem omsCartItem);

    void removeCartItemByMemberId(String memberId);
}
