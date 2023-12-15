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
    private String vihicleId;		// 항공편명

    private String airlineNm;		// 항공사명

    private long depPlandTime;		// 출발시간

    private long arrPlandTime;		// 도착시간

    private int economyCharge;		// 일반석운임

    private int prestigeCharge;		// 비즈니스석운임

    private String depAirportNm;	// 출발공항

    private String arrAirportNm;	// 도착공항

    private String startPortName;	// input 출발공항

    private String endPortName;		// input 도착공

    private String startDate;		// 조회 날짜 - 출발

    private String airline;			// 조회 항공사 (선택)

    private String endPN_ko;		// 도착공항 한글이름

    private Integer pageNo;			// 페이지 번호

    private int totalCount;			// item count

    @ManyToOne
    @JoinColumn(name = "MEMBER_SEQ", nullable = false, updatable = false)
    private Member member;
    
    public void Flight() { }
	
	public Flight(String vihicleId, String airlineNm, long depPlandTime, long arrPlandTime,
			int economyCharge, int prestigeCharge, String depAirportNm, String arrAirportNm) {
		
		this.vihicleId = vihicleId;
		this.airlineNm = airlineNm;
		this.depPlandTime = depPlandTime;
		this.arrPlandTime = arrPlandTime;
		this.economyCharge = economyCharge;
		this.prestigeCharge = prestigeCharge;
		this.depAirportNm = depAirportNm;
		this.arrAirportNm = arrAirportNm;
		
	}
	public Flight(String vihicleId, String airlineNm, String depPlandTime, String arrPlandTime,
			String economyCharge, String prestigeCharge, String depAirportNm, String arrAirportNm) {
		
		this.vihicleId = vihicleId;
		this.airlineNm = airlineNm;
		this.depPlandTime = Long.valueOf(depPlandTime);
		this.arrPlandTime = Long.valueOf(arrPlandTime);
		this.economyCharge = Integer.valueOf(economyCharge);
		this.prestigeCharge =Integer.valueOf(prestigeCharge);
		this.depAirportNm = depAirportNm;
		this.arrAirportNm = arrAirportNm;
		
	}
	
	public Flight(String startPortName, String endPortName, String startDate, String airline, 
			Integer pageNo, int totalCount, String endPN_ko) {
		this.startPortName = startPortName;
		this.endPortName = endPortName;
		this.startDate = startDate;
		this.airline = airline;
		this.pageNo = pageNo;
		this.totalCount = totalCount;
		this.endPN_ko = endPN_ko;
		
	}
}
