package hello.hellospring.service;


import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class MemberServiceIntergrationTest {



    @Autowired MemberRepository repository;
    @Autowired MemberService memberService;



    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("spring3");
        //when
        Long saveId = memberService.join(member);

        //then
        Member one = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(one.getName());
    }

    @Test
    void duplicatedJoin() {
        //given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        try{
            memberService.join(member2);

        } catch (IllegalStateException e){
            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }


        //then
       //Assertions.assertThat(member2.getId()).isEqualTo(saveId);
    }


    @Test
    void findMembers() {

    }

    @Test
    void findOne() {

    }
}