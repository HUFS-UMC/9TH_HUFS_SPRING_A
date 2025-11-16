package com.example.umc_workbook.global.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor

public enum GeneralSuccessCode implements BaseSuccessCode {
    OK(HttpStatus.OK, "COMMON_OK", "요청이 성공적으로 처리되었습니다."),
    CREATED(HttpStatus.CREATED, "RESOURCE_CREATED", "리소스가 생성되었습니다."),
    DELETED(HttpStatus.NO_CONTENT, "RESOURCE_DELETED", "리소스가 삭제되었습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;

}
