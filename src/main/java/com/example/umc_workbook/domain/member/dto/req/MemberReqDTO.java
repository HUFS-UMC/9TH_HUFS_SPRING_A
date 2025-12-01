package com.example.umc_workbook.domain.member.dto.req;

import com.example.umc_workbook.domain.member.enums.Gender;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.time.LocalDate;
import java.util.List;

public class MemberReqDTO {
    public record JoinDTO(
            String name,
            Gender gender,
            LocalDate birth,
            RabbitConnectionDetails.Address address,
            String specAddress,
            List<Long> preferCategory
    ){}
}
