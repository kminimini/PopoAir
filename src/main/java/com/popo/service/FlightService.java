package com.popo.service;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;

import com.popo.domain.Flight;


public interface FlightService {
	
	// 항공코드 한공한글명 변경
	public String nameset(String name);
	
	// 항공 스케쥴 조회 api 요청
	public ArrayList<Flight> airApi(String daID, String aaID, String dpTime, String airline, Integer pageNum) throws IOException, JSONException;
	
}