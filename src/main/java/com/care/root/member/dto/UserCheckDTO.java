package com.care.root.member.dto;


public class UserCheckDTO {
	private int chk; //로그인 여부
	private String name; //로그인 성공하면 사용자 이름 저장
	
	public int getChk() {
		return chk;
	}
	public void setChk(int chk) {
		this.chk = chk;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}