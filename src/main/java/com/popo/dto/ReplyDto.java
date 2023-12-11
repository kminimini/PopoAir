package com.popo.dto;

import java.util.Date;

import com.popo.domain.Board;

public class ReplyDto {
    private Long rseq;
    private String content;
    private Date regDate;
    private Long boardId; // 수정된 부분
    private String memberId;  // 추가된 부분

    // 기존 메서드...

    public Long getRseq() {
        return rseq;
    }

    public void setRseq(Long rseq) {
        this.rseq = rseq;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "ReplyDto [rseq=" + rseq + ", content=" + content + ", regDate=" + regDate + ", boardId=" + boardId
				+ ", memberId=" + memberId + "]";
	}
	

}
