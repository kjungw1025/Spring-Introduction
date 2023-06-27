package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {
    
    @GetMapping("hello")    // 웹 어플리케이션에서 /hello로 접근하면 아래 메서드를 호출
    public String hello (Model model) {
        model.addAttribute("data", "hello!!");  // attributeName: "data", attributeValue: "hello!!"
        return "hello"; // templates > hello.html를 찾아서 랜더링하라는 의미
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name); //parameter로 넘어온 name을 넘겨줌
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // HTTP protocol의 body부분에 return 값을 직접 넣어주겠다는 의미 (ex. "hello spring")
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }
    // 데이터를 그대로 내려줌

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
