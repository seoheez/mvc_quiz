package com.care.root.member.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.care.root.member.dto.MemberDTO;
import com.care.root.member.dto.UserCheckDTO;

@Repository
public class MemberDAO {
	ArrayList<MemberDTO> list;
	public MemberDAO() {
		System.out.println("dao 생성자 실행");
		list = new ArrayList<MemberDTO>();
	}
	public void register(MemberDTO dto) {
		list.add(dto);
	}
	public ArrayList<MemberDTO> memberList(){
		return list;
	}
	public UserCheckDTO check(String id, String pwd) {
		UserCheckDTO dto = new UserCheckDTO();
		if(list.size() != 0) { 	 //list에 저장된 값들을 모두 비교
			for(MemberDTO m : list) {
				if(id.equals(m.getId())) {
					if(pwd.equals(m.getPwd())) {
						dto.setChk(0); //참이면 dto에 0값을 넣어주고	 //로그인 성공
						dto.setName(m.getName());		//이름을 저장
						return dto;
					}
					dto.setChk(1); // 비밀번호 틀림 로그인 실패
				}
			}
		}
		if(dto.getChk() == 0) dto.setChk(-1); // 아이디 없음
		return dto; //메서드를 호출했던 서비스로 이동
	}
	public MemberDTO memberInfo(String id) {
		for(MemberDTO dto : list) {  //list에 저장된 값과 같은 것을 찾으면 dto를 돌려주고, 
			if(dto.getId().equals(id)) {
				return dto;
			}
		}
		return null;  //결과가 없다면 null값을 돌려줌.
	}
}