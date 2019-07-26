package com.atguigu.gamll.service;

import com.atguigu.gamll.beans.PmsBaseCatalog1;
import com.atguigu.gamll.beans.PmsBaseCatalog2;
import com.atguigu.gamll.beans.PmsBaseCatalog3;

import java.util.List;

public interface PmsBaseCatalogService {
    List<PmsBaseCatalog1> getCatalog1();

    List<PmsBaseCatalog2> getCatalog2(String catalog1Id);

    List<PmsBaseCatalog3> getCatalog3(String catalog2Id);
}
