package com.care.root.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired MemberService ms;
	public MemberController() {
		System.out.println("controller 생성자 실행");
	}
	@RequestMapping("test")
	public void test() {
		System.out.println("ms: " + ms);
		ms.test();
	}
	@GetMapping("/index") //url
	public String memberIndex() {
		return "/member/index"; //views쪽 경로
	}
	@GetMapping("/register_view")
	public String registerView() {
		return "/member/register_view";
	}
	@GetMapping("/member_list")
	public String memberList(Model model) {
		ms.memberList(model);
		
		return "/member/member_list";
	}
	@PostMapping("register")
	public String register(@RequestParam("id") String id,
							@RequestParam String pwd, 
							@RequestParam String name) {
		System.out.println(id);
		System.out.println(pwd);
		System.out.println(name);
		
		ms.register(id,pwd,name);
		
		
		return "redirect:index";
	}
	/*
	@PostMapping("register1")
	public String register1(HttpServletRequest req) {
		System.out.println(req.getParameter("id"));
		System.out.println(req.getParameter("pwd"));
		System.out.println(req.getParameter("name"));
		
		ms.register(req.getParameter("id"),
				req.getParameter("pwd"),
				req.getParameter("name")
				);
		
		return "redirect:index";
	}
	@PostMapping("register2")
	public String register2(MemberDTO dto) {
		System.out.println("dto.id : "+dto.getId());
		System.out.println("dto.pwd : "+dto.getPwd());
		System.out.println("dto.name : "+dto.getName());
		
		return "redirect:index";
	}
	*/
}