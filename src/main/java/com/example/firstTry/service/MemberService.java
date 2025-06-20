package com.example.firstTry.service;

import com.example.firstTry.domain.Member;
import com.example.firstTry.repository.MemberRepository;
import com.example.firstTry.repository.MemoryMemberRepository;

import java.util.*;


public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService (MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    //회원가입
    public Long join(Member member){
        validDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    //중복 조회
    private void validDuplicateMember(Member member){
        memberRepository.findByName(member.getName())
                .ifPresent(foundMember -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    //전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    //아이디로 특정 회원 조회
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
