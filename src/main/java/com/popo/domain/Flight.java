package com.popo.domain;

import javax.persistence.*;

import lombok.*;

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
