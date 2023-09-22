package com.quiz.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

@RequestMapping("/lesson01/quiz01")
@RestController
public class Lesson01Quiz01RestController {
	@RequestMapping("/3")
	public List<Map<String, String>> quiz01_3(){
		List<Map<String, String>> list = new ArrayList<>();
		
		Map<String, String>map = new HashMap<>();
		map.put("rate", "15");
		map.put("direction", "봉준호");
		map.put("time", "131");
		map.put("title", "기생충");
		list.add(map);
		
		map = new HashMap<>();
		
		map.put("rate", "0");
		map.put("direction", "로베르토 베니니");
		map.put("time", "116");
		map.put("title", "인생은 아름다워");
		list.add(map);
		
		map = new HashMap<>();
		map.put("rate", "19");
		map.put("direction", "윤종빈");
		map.put("time", "133");
		map.put("title", "범죄와의 전쟁:나쁜놈들 전성시대");
		list.add(map);
		
		map = new HashMap<>();
		map.put("rate", "15");
		map.put("direction", "프란시스 로렌스");
		map.put("time", "137");
		map.put("title", "헝거게임");
		list.add(map);
		
		return list; 
		
	}
	@RequestMapping("/5")
	public List<Data> quiz01_5() {
		//@ResonseBody + return String => HttpMessageConverter => String 이 html로 해석이 되서 responsebody로 글자만 내려간다
		//@ResonseBody + return 객체(list, map, 클래스) => HttpMessageConverter => jackson 라이브러리로 동작 
		//					=> jason이 response body에 내려감 => API
		List<Data> result = new ArrayList<>();
		
		Data data = new Data();
		data.setTitle("안녕하세요.가입인사 드려요");
		data.setUser("hangulu");
		data.setContent("안녕하세요.가입했어요.앞으로도 잘 부탁드립니다.활동 열심히 하겠습니다.");
		result.add(data);
		
		data = new Data();
		data.setTitle("헐 대박");
		data.setUser("bada");
		data.setContent("오늘 목요일이었어...금요일인줄");
		result.add(data);
		
		data = new Data();
		data.setTitle("헐 대박");
		data.setUser("bada");
		data.setContent("오늘 목요일이었어...금요일인줄");
		result.add(data);
		
		
		
		return result;
	}
	@RequestMapping("/6")
	public ResponseEntity<Data>quiz02_3(){
		Data data = new Data();
		data.setTitle("안녕하세요.가입인사 드려요");
		data.setUser("hangulu");
		data.setContent("안녕하세요.가입했어요.앞으로도 잘 부탁드립니다.활동 열심히 하겠습니다.");
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
