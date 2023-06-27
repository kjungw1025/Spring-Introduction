package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    
    @GetMapping("hello")    // 웹 어플리케이션에서 /hello로 접근하면 아래 메서드를 호출
    public String hello (Model model) {
        model.addAttribute("data", "hello!!");  // attributeName: "data", attributeValue: "hello!!"
        return "hello"; // templates > hello.html를 찾아서 랜더링하라는 의미
    }
}
