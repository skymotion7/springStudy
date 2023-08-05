package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void each(){
        repository.eachClear();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("jjang");
        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findId(){
        Member member1 = new Member();
        member1.setName("stive1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("stive2");
        repository.save(member2);

        Member result = repository.findById(member1.getId()).get();
        Assertions.assertThat(member1).isEqualTo(result);
    }

    @Test
    public void findName(){
        Member member1 = new Member();
        member1.setName("stive1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("stive2");
        repository.save(member2);

        Member result = repository.findByName("stive1").get();
        Assertions.assertThat(member1).isEqualTo(result);
    }


    @Test
    public  void findAll(){
        Member member1 = new Member();
        member1.setName("stive3");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("stive4");
        repository.save(member2);

        List<Member> arr = repository.findAll();
        System.out.println(arr.get(0).getName());
        System.out.println(arr.get(1).getName());

    }
}
