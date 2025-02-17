package com.study.welfare.member.infrastructure;

import com.study.welfare.member.domain.Member;
import com.study.welfare.member.domain.Role;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.EnumSet;
import java.util.Set;

@Entity
@Table(name="member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberJpaEntity {

    @Id
    private String id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @ElementCollection(fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = EnumSet.of(Role.BUYER);

    public static MemberJpaEntity from(Member member){
        MemberJpaEntity entity =new MemberJpaEntity();
        entity.id=member.getMemberId();
        entity.name= member.getMemberName();
        entity.email= member.getEmail();
        entity.password= member.getPassword();
        entity.roles=member.getRoles();
        return entity;
    }

    public Member toModel(){
        return Member.builder()
                .memberId(this.id)
                .memberName(this.name)
                .email(this.email)
                .password(this.password)
                .roles(this.roles)
                .build();
    }

}
