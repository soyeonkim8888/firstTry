package com.example.firstTry;

import com.example.firstTry.repository.MemberRepository;
import com.example.firstTry.repository.MemoryMemberRepository;
import com.example.firstTry.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FirstTryConfig {

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

}
