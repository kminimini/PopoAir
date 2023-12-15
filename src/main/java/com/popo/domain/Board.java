package com.popo.domain;

import java.util.Date;

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

@Getter
@Setter
@ToString(exclude = "member")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Board")
public class Board {
   @Id
   @GeneratedValue
   private Long bseq;
   private String btitle;
   @Column(updatable=false)
   private String writer;
   private String bcontent;
   // default 값으로 설정됨
   @Column(insertable=false, updatable=false, columnDefinition="date default sysdate")
   private Date createDate;
   @Column(insertable=false, columnDefinition="number default 0")
   private Long cnt;

   @ManyToOne
   @JoinColumn(name = "MEMBER_SEQ", nullable = false, updatable = false)
   private Member member;
}