package com.popo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * 항공편 정보 En
 */

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Flight")
public class Flight {

    @Id
    @Column(name = "vihicleId")	
    private String vihicleId;		

    private String airlineNm;

    private long depPlandTime;

    private long arrPlandTime;

    private int economyCharge;

    private int prestigeCharge;

    private String depAirportNm;

    private String arrAirportNm;

    private String startPortName;

    private String endPortName;

    private String startDate;

    private String airline;

    private String endPN_ko;

    private Integer pageNo;

    private int totalCount;

    @ManyToOne
    @JoinColumn(name = "MEMBER_SEQ", nullable = false, updatable = false)
    private Member member;
}
