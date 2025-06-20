package com.example.firstTry.controller;

import com.example.firstTry.domain.Member;
import com.example.firstTry.service.MemberService;
import com.example.firstTry.repository.MemoryMemberRepository;
import com.example.firstTry.repository.MemberRepository;

import org.springframework.web.bind.annotation.PostMapping;

public class MemberForm {
    private String name;

    public void setName(String name){
        this.name =name;
    }
    public String getName(){
        return name;
    }

}
