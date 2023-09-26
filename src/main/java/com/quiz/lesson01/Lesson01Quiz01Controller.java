package com.quiz.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@RequestMapping("lesson01/quiz01")
@Controller
//@Controller //spring bean 으로 등록
//@RequestMapping("lesson01/quiz01")
public class Lesson01Quiz01Controller {
	@ResponseBody
	@RequestMapping("/1")
	public String quiz01() {
		String text = "<h1>태스트 프로젝트 완성</h1>" + "<h3>해당 프로젝트를 통해서 문제 풀이를 진행 합니다</h3>";
		return text;
	}
	public Map<String, Object>quiz01_2(){
		Map<String, Object> map = new HashMap<>();
		map.put("국어", 80);
		map.put("수학", 90);
		map.put("영어", 85);
		return map;
	} 

}