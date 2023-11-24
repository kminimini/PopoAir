package com.popo.domain;

import javax.persistence.*;

import lombok.*;

import java.util.*;

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
