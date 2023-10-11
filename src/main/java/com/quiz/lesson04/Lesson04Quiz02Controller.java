package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.domain.Realtor;

@RequestMapping("/lesson04/quiz02")
@Controller
public class Lesson04Quiz02Controller {
	//http://localhost:8080/lesson04/quiz02/add-realtor-view
	@Autowired
	private RealtorBO realtorBO;
	@GetMapping("/add-realtor-view")
	public String addrealtorView() {
		return "lesson04/addRealtor";
	}
	//http://localhost:8080/lesson04/quiz02/add-realtor
	@PostMapping("/add-realtor")
	public String addRealtor(
			@ModelAttribute Realtor realtor, 
			Model model) {
		//db insert
		realtorBO.addRealtor(realtor);
		
		//insert하면서 받아온 id select => model에 집어넣은다
		Realtor newRealtor = realtorBO.getRealtorById(realtor.getId());
		model.addAttribute("realtor", newRealtor);
		//response =>view로 리턴을 해준다
		return"lesson04/afterAddRealtor";
	}
}
