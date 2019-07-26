package com.atguigu.gamll.service;

import com.atguigu.gamll.beans.PmsBaseAttrInfo;
import com.atguigu.gamll.beans.PmsBaseAttrValue;

import java.util.List;
import java.util.Set;

public interface PmsBaseAttrService {
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);

    List<PmsBaseAttrInfo> getAttrValueByValueIds(Set<String> valueIdSet);
}
