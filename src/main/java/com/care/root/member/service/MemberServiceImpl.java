package com.care.root.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.member.dao.MemberDAO;
import com.care.root.member.dto.MemberDTO;
import com.care.root.member.dto.UserCheckDTO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired MemberDAO dao;
	public MemberServiceImpl() {
		System.out.println("service 생성자 실행");
	}
	public void test() {
		System.out.println("dao: " + dao);
	}
	@Override
	public void register(String id, String pwd, String name) {
		// TODO Auto-generated method stub
		MemberDTO dto = new MemberDTO();
		dto.setId(id); dto.setPwd(pwd); dto.setName(name);
		dao.register(dto);


	}	@Override
	public void memberList(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("list", dao.memberList() );

	}
	public void check(String id, String pwd, Model model) {
		UserCheckDTO dto = dao.check(id, pwd); //dto 값이 userCheckDTO에 저장하고
		model.addAttribute("usercheck",dto); //결과값을 model에 저장. 서비스가 종료되면 controller로 이동
	}
	public void memberInfo(String id,Model model) {
		model.addAttribute("member",dao.memberInfo(id) ); //model에 dao로부터 가져온 데이터를 저장. id를 넘겨주고, 해당하는 아이디와 같은 정보를 return으로 돌려줌.
	}
}
