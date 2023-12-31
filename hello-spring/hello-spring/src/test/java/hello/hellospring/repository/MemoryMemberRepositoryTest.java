package hello.hellospring.repository;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 각 메서드가 끝날 때마다 동작함
    public void afterEach() {
        repository.clearStore();    // repository를 다 지우므로 테스트 순서가 상관없어짐
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
//        System.out.println("result = " + (result == member);
//        Assertions.assertEquals(member, result); // 성공하면 녹색 불만 뜨고, 실패하면 빨간색과 실패했다는 메시지 발생
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();  // shift + f6으로 같은 이름 한꺼번에 변경 가능
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
