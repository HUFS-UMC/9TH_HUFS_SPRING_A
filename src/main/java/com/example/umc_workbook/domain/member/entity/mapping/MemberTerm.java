package com.example.umc_workbook.domain.member.entity.mapping;

import com.example.umc_workbook.domain.member.entity.Member;
import jakarta.persistence.*;

@Entity
@Table(name = "member_term")
public class MemberTerm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    // 기타 컬럼들...
}

