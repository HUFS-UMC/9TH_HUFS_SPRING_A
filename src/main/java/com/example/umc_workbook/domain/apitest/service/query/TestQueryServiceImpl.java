package com.example.umc_workbook.domain.apitest.service.query;

import com.example.umc_workbook.domain.apitest.exeption.TestException;
import com.example.umc_workbook.domain.apitest.exeption.code.TestErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestQueryServiceImpl implements TestQueryService {

    @Override
    public void checkFlag(Long flag){
        if (flag == 1){
            throw new TestException(TestErrorCode.TEST_EXCEPTION);
        }
    }
}
