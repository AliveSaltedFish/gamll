package com.atguigu.gamll.service;

import com.atguigu.gamll.beans.PmsBaseSaleAttr;
import com.atguigu.gamll.beans.PmsProductImage;
import com.atguigu.gamll.beans.PmsProductInfo;
import com.atguigu.gamll.beans.PmsProductSaleAttr;

import java.util.List;

public interface PmsProductService {
    List<PmsProductInfo> spuList(String catalog3Id);

    List<PmsBaseSaleAttr> baseSaleAttrList();

    void saveSpuInfo(PmsProductInfo pmsProductInfo);

    List<PmsProductSaleAttr> spuSaleAttrList(String spuId);

    List<PmsProductImage> spuImageList(String spuId);
}
