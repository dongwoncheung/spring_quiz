package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.domain.Store;
import com.quiz.lesson02.mapper.StoreMapper;

@Service
public class StoreBo {
	
	@Autowired // spring bean(객체)을 가져오는것(Dependency Injection ->DI)
	private StoreMapper storeMapper; // DI
	
	public List<Store> getStoreList(){//input
		return storeMapper.selectStoreList();//ouput
	}
}
