package com.study.welfare.member.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.EnumSet;
import java.util.Set;
import java.util.UUID;

@Builder
@Getter
public class Member {

    // 사용자 등록 및 관리, 사용자 정보 수정, 역할 관리
    private final String memberId;
    private final String memberName;
    private String nickName;
    private final String email;
    private String password;
    private Set<Role> roles;


    public static Member createMember(String name, String nickName, String email, String password) {
        return Member.builder()
                .memberId(UUID.randomUUID().toString())
                .memberName(name)
                .nickName(nickName)
                .email(email)
                .password(password)
                .roles(EnumSet.of(Role.BUYER))
                .build();
    }
}

