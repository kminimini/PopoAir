package com.popo.domain;

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
