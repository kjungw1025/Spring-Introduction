package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    /*
        private final MemberService memberService = new MemberService();
        이런식으로 new를 통해서 service를 가져다 사용할 수 있음.
        그러나 스프링이 관리하게 되면, 다 스프링 컨테이너에 등록하고 받아서쓰도록 바꿔야함
        new 사용해서 가져다 쓰면 MemberController 말고, 다른 여러 컨트롤러들이 MemberService를 가져다 쓸 수 있음
        즉, 하나만 생성하고 공유해서 쓰는게 더 나음
    */
    private final MemberService memberService;

//    // 필드 주입
//    @Autowired private MemberService memberService;

//    // setter 주입
//    @Autowired
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }


    // ctrl + n --> constructor 검색 후 memberService 선택하여 생성자 생성 가능
    // 생성자 주입
    @Autowired  // Autowired를 하면, 스프링 컨테이너에서 memberService를 가져다가 연결해줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
