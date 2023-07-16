package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{
    // spring data jpa가 jpaRepository를 받고 있으면 구현체를 자동으로 만들어줌, 스프링 빈을 자동으로 등록. 그러면 우리는 가져다 쓰면 됨
    @Override
    Optional<Member> findByName(String name);
//    Optional<Member> findByNameAndId(String name, Long id);
}
