package com.popo.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * 게시판 En
 */

@Getter
@Setter
@ToString (exclude = "member")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Board")
public class Board {

	@Id
    @GeneratedValue
    private int bnum;

    private String btitle;
    private String bcontent;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createDate;

    @Column(nullable = false)
    private Long cnt;

    @ManyToOne
    @JoinColumn(name = "MEMBER_SEQ", nullable = false, updatable = false)
    private Member member;
}
