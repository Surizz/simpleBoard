package com.nhn.board.vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BoardEntity {
	private int bno;
	private String email;
	private String password;
	private String content;
	private Date createdDate;
	private Date modifiedDate;
	
	public int getBno() {
		return bno;
	}
	public BoardEntity setBno(int bno) {
		this.bno = bno;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public BoardEntity setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public BoardEntity setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getContent() {
		return content;
	}
	public BoardEntity setContent(String content) {
		this.content = content;
		return this;
	}
	public String getCreatedDate() {
		return new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss").format(createdDate);
	}
	public BoardEntity setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
		return this;
	}
	public String getModifiedDate() {
		return new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss").format(modifiedDate);
	}
	public BoardEntity setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
		return this;
	}	
}
