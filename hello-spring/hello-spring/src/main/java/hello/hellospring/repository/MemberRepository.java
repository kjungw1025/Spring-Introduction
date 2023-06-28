package hello.hellospring.repository;
import hello.hellospring.domain.Member;
import java.util.Optional;
import java.util.List;

public interface MemberRepository {
    Member save(Member member); // 저장소에 회원 저장
    Optional<Member> findById(Long id); // 저장소에서 Id로 찾아오기
    Optional<Member> findByName(String name);   // 저장소에서 Name으로 찾아오기
    List<Member> findAll(); // 저장된 모든 회원들을 list로 반환
}
