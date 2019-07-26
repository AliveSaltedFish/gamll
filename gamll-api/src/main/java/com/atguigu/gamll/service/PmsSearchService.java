package com.atguigu.gamll.service;

import com.atguigu.gamll.beans.PmsSearchParam;
import com.atguigu.gamll.beans.PmsSearchSkuInfo;

import java.util.List;

public interface PmsSearchService {
    List<PmsSearchSkuInfo> getSearchSkuInfo(PmsSearchParam searchParam);
}
