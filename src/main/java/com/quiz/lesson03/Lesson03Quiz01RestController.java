package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.domain.RealEstate;
@RequestMapping("/lesson03/qui01")
@Controller

public class Lesson03Quiz01RestController {
	@Autowired
	private RealEstateBO realestateBO;
	@RequestMapping("/1")
	public RealEstate quiz01_1(
			@RequestParam("id") int id) {
		return realestateBO.getRealEstateById(0);
	}
		
//	@Autowired
//	private RealEstateBO realestateBO;
//	// 요청 url: http://localhost:8080/lesson03/quiz01/1?id=20
//	@RequestMapping("/1")
//	public RealEstate quiz01_1(
//			@RequestParam("id") int id) {//response body => jason
//		return realestateBO.getRealEstateById(id);
//	}
//	// 요청 URL: http://localhost:8080/lesson03/quiz01/2?rent_price=90
//	@RequestMapping("/2")
//	public List<RealEstate> quiz01_2(
//			@RequestParam("rent_price") int rentPrice){
//		return realestateBO.getRealEstateListByRentPrice(rentPrice);
//	}
//	//요청url:http://localhost/lesson03/quiz01/3?area=90&price=130000
//	@RequestMapping("/3")
//	public List<RealEstate>quiz01_3(
//			@RequestParam(value="area")int area,
//			@RequestParam("price")int price){
//		return realestateBO.getRealEstateListByAreaPrice(area, price);
//	}
}
	
