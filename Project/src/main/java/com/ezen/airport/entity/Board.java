package com.ezen.airport.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Board {
   @Id
   @GeneratedValue
   private Long seq;
   private String title;
   @Column(updatable=false)
   private String writer;
   private String content;
   // default 값으로 설정됨
   @Column(insertable=false, updatable=false, columnDefinition="date default sysdate")
   private Date createDate;
   @Column(insertable=false, columnDefinition="number default 0")
   private Long cnt;
}