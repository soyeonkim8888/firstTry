package com.example.firstTry.controller;

import com.example.firstTry.domain.Member;
import com.example.firstTry.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping(value = "/members/new")
    public String createform(){
        return "members/createMemberForm";
    }


    @GetMapping(value = "/members")
    public String list(Model model){
        List< Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }


}
