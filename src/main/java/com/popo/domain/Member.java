package com.popo.domain;

import java.util.*;

import javax.persistence.*;

import org.springframework.security.crypto.password.PasswordEncoder;

//import com.popo.dto.JoinFormDto;

import lombok.*;

/*
 * 고객 En
 */

@Entity
@Getter
@Setter
@ToString(exclude = {"boardList", "parkInfoList", "flightList"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Member")
public class Member {

    @Id
    @Column(name = "MEMBER_SEQ", unique = true)
    private String id;

    private String name;    
    private String password;
    private String address;
    private String detaileAddress;
    @Column(unique = true)	// 회원은 이메일 통해 구분히야 하기 때문에, 동일한 값이 들어올 수 없도록 지정
    private String email;
    private String phone;

    @Enumerated(EnumType.STRING)
    private Role role;
    
    private String 	enabled;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Board> boardList;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<ParkInfo> parkInfoList;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Flight> flightList;
    

    
}
