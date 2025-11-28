package com.example.prog_14615.global.initData;

import com.example.prog_14615.domain.post.member.Member;
import com.example.prog_14615.domain.post.member.MemberService;
import com.example.prog_14615.domain.post.post.Post;
import com.example.prog_14615.domain.post.post.PostService;
import com.example.prog_14615.domain.wise.Wise;
import com.example.prog_14615.domain.wise.WiseService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

@Configuration  // 빈을 등록하겠다(설정하겠다)
@RequiredArgsConstructor  // new 안해도 스프링이 자동으로 클래스 연결해준다
public class BaseInitData {

    private final PostService postService;
    private final MemberService memberService;
    private final WiseService wiseService;

    // 스프링 내부에서 제공하는 도구
    @Bean
    public ApplicationRunner initData() {

        // ApplicationRunner를 bean 으로 등록하겠다.
        // Spring이 시작할때 반드시 이 Runner가 실행된다.
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {

                writeMember();
                writePost();
                writeWise();
            }
        };
    }

    void writeMember() {
        if(memberService.count() > 0) return;

        memberService.join("user1","1234","userA");
        memberService.join("user2","1234","userB");
        memberService.join("user3","1234","userC");
    }

    void writePost() {
        if(postService.count() > 0) return;

        postService.write("첫번재 게시글", "첫번재 게시글 내용입니다.");
        postService.write("두번재 게시글", "두번재 게시글 내용입니다.");
        postService.write("세번재 게시글", "세번재 게시글 내용입니다.");
    }

    // transaction 으로 묶이면 (성공시) 전부 적용되거나, (하나라도 실패시) 전부 적용이 안되야함
    @Transactional
    void writeWise() {
        if(wiseService.count() > 0) return;

        wiseService.write("현자1", "내가 현자로다1");
        wiseService.write("현자2", "내가 현자로다2");
        wiseService.write("현자3", "내가 현자로다3");
    }
}