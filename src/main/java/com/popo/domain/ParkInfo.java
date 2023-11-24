package com.popo.domain;

import javax.persistence.*;

import lombok.*;

/*
 * 주차장 정보 En
 */

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ParkInfo")
public class ParkInfo {

	@Id
	private String parkingGetdate;

	private String aprEng;
	private String aprKor;
	private String parkingAirportCodeName;
	private int parkingFullSpace;
	private String parkingGettime;
	private int parkingIincnt;
	private int parkingIoutcnt;
	private int parkingIstay;

	@ManyToOne
	@JoinColumn(name = "MEMBER_SEQ", nullable = false, updatable = false)
	private Member member;
}
