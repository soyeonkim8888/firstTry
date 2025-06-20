package com.example.firstTry.service;

import com.example.firstTry.domain.Member;
import com.example.firstTry.repository.MemoryMemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;

public class MemberServiceTest {
   MemberService memberService;
   MemoryMemberRepository memberRepository;

   @BeforeEach
    public void beforeEach(){
       memberRepository = new MemoryMemberRepository();
       memberService = new MemberService(memberRepository);
   }

   @AfterEach
    public void afterEach(){
       memberRepository.clearStore();
   }

   @Test
    public void 회원가입 () throws Exception{
       Member member = new Member();
       member.setName("soyeon");

       Long saveId = memberService.join(member);

       Member findMember= memberRepository.findById(saveId).get();
       assertThat(findMember.getName()).isEqualTo(member.getName());
   }

   @Test
    public void 회원중복 () throws Exception{
       Member member1 = new Member();
       member1.setName("soyeon");
       memberService.join(member1);

       Member member2 = new Member();
       member2.setName("soyeon");

       IllegalStateException e = assertThrows(IllegalStateException.class, ()->memberService.join(member2));

       assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
   }
}

    /*

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    //회원가입
    @Test
    public void 회원가입() throws Exception{
        Member member = new Member();
        member.setName("hello");

        Long saveId = memberService.join(member); // join(파라미터) 하면 getId로  id 넘겨줌. 그럼  saveId 변수에 저장

        Member findMember = memberRepository.findById(saveId).get();   //저장한 아이디를 가지고 멤버를 찾아서 get()해서  새로운 변수 findMember저장. 리턴값이 Member 객체가 맞지 맞지!
        assertEquals(member.getName(), findMember.getName());   //맨처음 member 변수에 저장했던 이름을 getName() 그리고 findMember에 저장했던 getName()들고와서 비교
    }

    //중복조회
    @Test
    public void 중복회원예외() throws Exception{
        //일단 회원 한 명 가입을 받고, 그리고 다음 회원이 가입할때 가입된 회원 리스트 중에 현재 가입할 사림이 있는지 없는지 확인하는 거임.
        //그러니까 member1만 join으로 id발급받으면. -> MemberService class에서 join메소드에서 memberRepository.save(member); 이렇게 저장함
        Member member1 = new Member();
        member1.setName("spring");
        memberService.join(member1);

        Member member2 = new Member();
        member2.setName("spring");

        IllegalStateException e = assertThrows(IllegalStateException.class, ()->memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }


}
*/
