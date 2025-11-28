package com.example.prog_14615.domain.wise;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WiseService {

    private final WiseRepository wiseRepository;

    public Wise write(String author, String saying) {

        Wise wise = new Wise();
        wise.setAuthor(author);
        wise.setSaying(saying);
        
        return wiseRepository.save(wise);
    }

    // 명시적으로 표시 (이것을 읽기 전용 메서드임)
    // JPA에 읽기 전용이라 알림 (최적화)
    @Transactional(readOnly = true)
    public List<Wise> getList() {
        return wiseRepository.findAll();
    }

    public long count() {
        return wiseRepository.count();
    }

    public void delete(long id) {
        wiseRepository.deleteById(id);
    }

    // (가정) 1~2 삭제하고 3하기 전에 예외가 터진 상황
    // 트랜젝션 적용 안했을 때: 1, 2 삭제되고, 3은 삭제 안됨
    // 트랜잭션 적용 했을 때: 1, 2, 3, 전부 삭제 안됨
    @Transactional
    public void deleteOneTwoThree() {
        wiseRepository.deleteById(1L);
        wiseRepository.deleteById(2L);

        // 무조건 예외가 발생하게
        if(true) {
            try {
                throw new Exception("테스트 예외 발생");
            } catch (Exception e) {
                System.out.println("예외가 발생했습니다.");
            } finally {
                System.out.println("반드시 실행해야하는 중요한 코드");
                System.out.println("예를 들면 자원 해제 이런거...");
            }
        }

        wiseRepository.deleteById(3L);
    }
}
