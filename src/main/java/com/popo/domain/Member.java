package com.popo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import com.popo.dto.JoinFormDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
    @GeneratedValue(strategy = GenerationType.AUTO)	  
    @Column(name = "MEMBER_SEQ", length = 36)			
    private Long mid;											  

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

//    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
//    private List<Board> boardList;
//
//    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
//    private List<ParkInfo> parkInfoList;
//
//    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
//    private List<Flight> flightList;
    
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Board> boardList;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<ParkInfo> parkInfoList;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Flight> flightList;
    
    
}
