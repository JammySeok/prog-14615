package com.example.prog_14615.global.initData;

import com.example.prog_14615.domain.wise.WiseService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@RequiredArgsConstructor
@Configuration
@Profile("test")
public class TestInitData {

    private final WiseService wiseService;

    @Bean
    public ApplicationRunner testInitDataRunner() {
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
                wiseService.write("테스트 작가1", "테스트 내용2");
                wiseService.write("테스트 작가2", "테스트 내용2");
                wiseService.write("테스트 작가3", "테스트 내용3");

                System.out.println("테스트 전용 데이터 생성 완료");
            }
        };
    }
}
