package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Seller;
import com.quiz.lesson04.mapper.SellerMapper;

@Service// springbean으로 등록을 하기 위한 절차
public class SellerBO {
	@Autowired
	private SellerMapper sellerMapper;
	//input: 3개의 parameter
	//output: x
	public void addSeller(String nickname, String profileImageUrl, Double temperature) {
		sellerMapper.insertSeller(nickname, profileImageUrl, temperature);
	}

	//input:x
	//output: seller(최신가입자 1명)
	public Seller getLatestSeller() {
		return sellerMapper.selectLastestSeller();
	}

	// input: id
	// output: Seller
	public Seller getSellerById(int id) {
		return sellerMapper.selectSellerById(id);
	}

	
}
