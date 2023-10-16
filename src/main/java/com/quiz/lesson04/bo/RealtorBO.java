package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Realtor;
import com.quiz.lesson04.mapper.RealtorMapper;

@Service//spring bean이되게 걸어주는 어노테이션
public class RealtorBO {
	@Autowired
	private RealtorMapper realtorMapper;
	//input:realtor객체정보
	//output:x
	public void addRealtor(Realtor realtor) {
		realtorMapper.insertRealtor(realtor);
	}
	//input: id(insert한id)에 해당한 한개의 realtor의 정보
	//output: id에 해당하는 한행의 객체
	public Realtor getRealtorById(int id) {
		return realtorMapper.selectRealtorById(id);
	}


}
