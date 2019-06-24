package com.atguigu.gmall.member.service;

import com.atguigu.gmall.member.entity.UmsMember;

import java.util.List;

public interface UmsMemberService {
    public List<UmsMember> getMemberAll();
    public UmsMember getMemberById(String id);
    public boolean updateMemberById(UmsMember umsMember);
    public boolean addMember(UmsMember umsMember);
    public boolean deleteMemberById(String id);
}
