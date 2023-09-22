package com.quiz.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lesson01Quiz03Controller {

//	요청 URL : http://localhost:8080/lesson01/quiz03/1
//	jsp 파일 경로: src/main/webapp/WEB-INF/jsp/lesson01/quiz03.jsp
	@RequestMapping("/lesson01/quiz03/1")
	public String quiz03() {
		//@responsebody 가 없을때 string을 return하면 
		//ViewResolver에 의해서 return된 string경로의 jsp view 화면을 찾고 태그가 responsebody에 담긴다.
		return"lesson01/quiz03";//jsp의 view의 경로
	}
	
	
}
