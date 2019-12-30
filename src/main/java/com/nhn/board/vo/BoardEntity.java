package com.nhn.board.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BoardEntity {
	private int bno;
	private String email;
	private String password;
	private String content;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH:mm:ss");

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
		return createdDate.format(dateTimeFormatter);
	}
	public BoardEntity setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
		return this;
	}
	public String getModifiedDate() {
		return modifiedDate.format(dateTimeFormatter);
	}
	public BoardEntity setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
		return this;
	}	
}
