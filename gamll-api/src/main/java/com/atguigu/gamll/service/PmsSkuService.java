package com.atguigu.gamll.service;

import com.atguigu.gamll.beans.OmsCartItem;
import com.atguigu.gamll.beans.PmsProductSaleAttr;
import com.atguigu.gamll.beans.PmsSkuInfo;

import java.util.List;

public interface PmsSkuService {
    String checkSkuByValueIds(List<String> ids);

    boolean saveSkuInfo(PmsSkuInfo pmsSkuInfo);

    PmsSkuInfo getSkuById(String skuId) throws InterruptedException;

    List<PmsSkuInfo> getSkuBySpuId(String ... productId);

    List<PmsProductSaleAttr> getSaleAttrValue(String spuId, String skuId);

    List<PmsSkuInfo> getSkuInfoAll();

    PmsSkuInfo getSkuInfoBySkuId(String productSkuId);

}
