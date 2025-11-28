package com.example.prog_14615.domain.post.post;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RsData {

    private String resultCode;
    private String message;
    private String data;  // 어떻게 되었는지 결과, 부연설명, 필요한 데이터 등...
}
