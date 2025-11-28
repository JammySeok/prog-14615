package com.example.prog_14615.domain.post.member;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // 회원번호
    private String username;  // 아이디
    private String nickname;  // 별명
    private String password;  // 비밀번호
    
    private String apiKey;  // api 키
}
