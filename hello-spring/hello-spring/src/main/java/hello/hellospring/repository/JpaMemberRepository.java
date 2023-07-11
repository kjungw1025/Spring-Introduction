package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }
    /*
        JPA는 EntityManager로 모든 걸 동작함.
        build.gradle에서 data-jpa 라이브러리를 등록했으니 스프링부트가 자동으로 EntityManager를 생성해줌
        우리는 만들어진 걸 인젝션 해주면됨
     */


    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
//        alt + enter -> line variable
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
//        jpql query 언어 : 객체를 대상으로 query를 날림. 그럼 이게 sql로 변형됨

//        List<Member> result = em.createQuery("select m from Member m", Member.class)
//                .getResultList();
//        return result;
    }

    // data jpa를 사용하면 findByname, findAll에서 jpql로 작성하지 않아도됨
}
