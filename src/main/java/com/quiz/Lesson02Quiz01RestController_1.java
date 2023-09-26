package com.quiz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson02.bo.StoreBo;
import com.quiz.lesson02.domain.Store;

@RestController
public class Lesson02Quiz01RestController_1 {

	@Autowired
	private StoreBo storeBo;
//	private StoreBo storeBo;
	@RequestMapping("/lesson02/1")
	public List<Store>quiz01(){
		return storeBo.getStoreList();
	}
}
