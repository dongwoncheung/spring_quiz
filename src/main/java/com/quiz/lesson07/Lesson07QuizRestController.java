package com.quiz.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.bo.CompanyBO;
import com.quiz.lesson07.entity.CompanyEntity;

@RequestMapping("/lesson07/quiz01")
@RestController
public class Lesson07QuizRestController {
	@Autowired
	private CompanyBO companyBO;
	@GetMapping("/save1")
	public CompanyEntity save1() {

		
		return companyBO.addCompany("카카오", "컨텐츠 게임", "대기업", 3585);
				
	}
	@GetMapping("/save2")
	public CompanyEntity save2() {

		return companyBO.addCompany("버블팡", "여신 금융업", "대기업", 6834);
				
}
	@GetMapping("/update")
	public CompanyEntity update() {
		return companyBO.updateCompanyByScale(8 ,"중소기업", 34);
	}
	@GetMapping("/delete")
	public String delete() {//jason으로도 리턴을 않해주고 글짜로만 결과를 원하니까 돌려 받는건 글짜 형태니 string으로 
		companyBO.deleteCompanyById(8);
		return"수행 완료";
	}
}