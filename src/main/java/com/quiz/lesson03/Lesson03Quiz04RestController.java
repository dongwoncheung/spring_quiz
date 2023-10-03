package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;
@RestController
public class Lesson03Quiz04RestController {
	@Autowired
	private RealEstateBO realestateBO;
	@RequestMapping("/lesson03/quiz04")
	public String quiz01(
			@RequestParam("id")int id) {
		int rowCount = realestateBO.deleteRealEstateById(id);
		return"삭제성공" + rowCount;
	}

}
