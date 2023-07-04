package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    @GetMapping("/members/new")
    public String CreateForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create (MemberForm form) {
        Member member = new Member();
        member.setName(form.getName()); //form양식 안의 input의 "name"을 가져와서 setter 수행

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members); // member의 list 자체들을 model에 다 담아줌
        return "members/memberList";
    }
}
