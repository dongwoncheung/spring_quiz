package com.quiz.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson02.bo.StoreBo;
import com.quiz.lesson02.domain.Store;
@RestController
public class Lesson02Quiz01RestController {
	//요청 URL : http://localhost:8080/lesson02/quiz01
	@Autowired
	private StoreBo storeBO;
	@RequestMapping("/lesson02/quiz01")
	private List<Store>quiz01(){
		return storeBO.getStoreList();
	}
}
