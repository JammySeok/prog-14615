package com.example.prog_14615.domain.wise;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

// 테스트 할려면 기존 진행하는 프로젝트 꺼야 함(DB 접근은 하나의 프로세스만 접근 가능하기 때문에)
// -> ActiveProfiles으로 환경 분리(application-test.yml을 읽음)
@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class WiseRepositoryTest {

    @Autowired
    private WiseRepository wiseRepository;

    @Test
    @DisplayName("2번글 조회")
    void t1() {
        Wise wise = wiseRepository.findById(2L).get();

        assertThat(wise.getId()).isEqualTo(2L);
        assertThat(wise.getAuthor()).isEqualTo("테스트 작가2");
    }

    @Test
    @DisplayName("글 생성")
    @Transactional  // 아래 t3 의 문제를 해결하기위해 transaction 걸고
    @Rollback  // 메서드 종료되면 rollback 하도록
    void t2() {

        Wise newWise = new Wise();
        newWise.setAuthor("new 작가");
        newWise.setSaying("new 개소리");

        assertThat(newWise.getId()).isNull();

        Wise savedWise = wiseRepository.save(newWise);

        assertThat(savedWise.getId()).isNotNull();
        assertThat(savedWise.getAuthor()).isEqualTo("new 작가");
        assertThat(savedWise.getSaying()).isEqualTo("new 개소리");
    }

    // 원래는 위의 t2(글생성)이 영향을 받아서 원래 초기값인 3L이 안나옴
    @Test
    @DisplayName("글 개수 조회")
    void t3() {
        long cnt = wiseRepository.count();

        assertThat(cnt).isEqualTo(3L);
    }
}
