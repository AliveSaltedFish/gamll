package com.atguigu.gamll.service;


import com.atguigu.gamll.beans.UmsMember;
import com.atguigu.gamll.beans.UmsMemberReceiveAddress;

import java.util.List;

public interface UmsMemberService {
    List<UmsMember> getMemberAll();
    UmsMember getMemberById(String id);
    boolean updateMemberById(UmsMember umsMember);
    boolean addMember(UmsMember umsMember);
    boolean deleteMemberById(String id);

    UmsMember login(UmsMember umsMember);

    List<UmsMemberReceiveAddress> getMemberAddressesById(String memberId);

    UmsMemberReceiveAddress getMemberReceiveAddressById(String receiveAddressId);
}
