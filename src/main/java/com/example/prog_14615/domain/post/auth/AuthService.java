package com.example.prog_14615.domain.post.auth;

import com.example.prog_14615.domain.post.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final MemberRepository memberRepository;


}
