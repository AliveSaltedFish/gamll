package com.atguigu.gmall.member.controller;

import com.atguigu.gmall.member.entity.UmsMember;
import com.atguigu.gmall.member.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UmsMemberController {
    @Autowired
    private UmsMemberService umsMemberService;

    @ResponseBody
    @RequestMapping("query/all")
    public List<UmsMember> queryAll(){
        return umsMemberService.getMemberAll();
    }

    @ResponseBody
    @RequestMapping("query/member/{id}")
    public UmsMember queryMemberById(@PathVariable("id") String id){
        return umsMemberService.getMemberById(id);
    }

    @RequestMapping("update/member/by/id")
    public void updateMemberById(UmsMember umsMember){
        umsMemberService.updateMemberById(umsMember);
    }

    @RequestMapping("save/member")
    public void saveMember(UmsMember umsMember){
        umsMemberService.addMember(umsMember);
    }

    @RequestMapping("remove/member/{id}")
    public void removeMember(@PathVariable("id") String id){
        umsMemberService.deleteMemberById(id);
    }

}
