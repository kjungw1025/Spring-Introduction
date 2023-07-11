package hello.hellospring.domain;

import jakarta.persistence.*;

@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Id : pk mapping, @GeneratedValue(strategy = GenerationType.IDENTITY) : DB가 id를 자동으로 생성
    private Long id;
    // @Column(name = "username")
    // DB의 username column과 mapping
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
