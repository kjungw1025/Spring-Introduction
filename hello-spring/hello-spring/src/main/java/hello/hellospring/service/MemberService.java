package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service // memberService.java에 @Service를 추가해주면 스프링이 올라올 때, 컨테이너에 memberService에 등록해줌
public class MemberService {
    private final MemberRepository memberRepository;
    
    // 외부에서 입력하도록
//    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원 가입
    public Long join(Member member) {
        // 중복 회원 검증
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
        
        // findByName의 결과는 Optional<Member>이므로 아래와 같이 변경 가능함
//        memberRepository.findByName(member.getName())
//                .ifPresent(m -> {
//                    throw new IllegalStateException("이미 존재하는 회원입니다.");
//                });
        // Refactor > Extract Method > validateDuplicateMember 이름의 메서드로 생성

        validateDuplicateMember(member);    // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // ID로 회원 한명 조회
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
    
    // service에서의 이름은 비즈니스에 가까운 용어를 쓰는게 좋음
}
