package com.quiz.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.UrlBo;

@RequestMapping("/lesson06")
@Controller
//url: http://localhost:8080/lesson06/quiz01/add-url-view
public class Lesson06Controller {
	@Autowired
	private UrlBo urlBO;
	@GetMapping("/quiz01/add-url-view")
	public String urlView(Model model) {
		return"lesson06/addUrl";
	}
	//회원 추가 기능 
	@PostMapping("/quiz01/url-list-view")
	@ResponseBody
	public String urlListView(
			@RequestParam("id") int id,
			@RequestParam("name") String name,
			@RequestParam("address") String address) {
		//db insert
		urlBO.addUrl(id, name, address);
		return"lesson06/urlList";
	}
}
