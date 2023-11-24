package com.popo.domain;

import java.util.*;

import javax.persistence.*;

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
    @Column(name = "MEMBER_SEQ")
    private String id;

    private String name;    
    private String password;
    private String address;
    private String detaileAddress;
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
