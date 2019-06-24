package com.atguigu.gmall.member.service.impl;

import com.atguigu.gmall.member.entity.UmsMember;
import com.atguigu.gmall.member.mapper.UmsMemberMapper;
import com.atguigu.gmall.member.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    private UmsMemberMapper umsMemberMapper;


    @Override
    public List<UmsMember> getMemberAll() {
        List<UmsMember> umsMembers = umsMemberMapper.selectAll();
        return umsMembers;
    }

    @Override
    public UmsMember getMemberById(String id) {
        UmsMember umsMember = new UmsMember();
        umsMember.setId(id);
        return umsMemberMapper.selectOne(umsMember);
    }

    @Override
    public boolean updateMemberById(UmsMember umsMember) {
        if(umsMemberMapper.updateByPrimaryKey(umsMember) == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean addMember(UmsMember umsMember) {
        if(umsMemberMapper.insert(umsMember) == 1) return true;
        return false;
    }

    @Override
    public boolean deleteMemberById(String id) {
        UmsMember umsMember = new UmsMember();
        umsMember.setId(id);
        if(umsMemberMapper.delete(umsMember) == 1) return true;
        return false;
    }
}
