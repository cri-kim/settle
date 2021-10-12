package com.pilot.api.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberDto {
    private String memberId;
    private String passwd;
    private String memberNm;
    private String role;
    private String state;
}
