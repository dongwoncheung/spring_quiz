package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.RealEstate;
import com.quiz.lesson03.mapper.RealEstateMapper;

@Service
public class RealEstateBO {
	@Autowired
	private RealEstateMapper realestateMapper;
	//input: 아이디(int 타입)
	//output: realestate
	public RealEstate getRealEstateById(int id) {
		return realestateMapper.selectRealEstateById(id);
	}
	
	// input: rentPrice
	// output: List<RealEstate>
		public List<RealEstate> getRealEstateListByRentPrice(int rentPrice) {
			//return null;
			return realestateMapper.selectRealEstateListByRentPrice(rentPrice);
		}
	//input:area, price
	//output:List<RealEstate>
		public List<RealEstate> getRealEstateListByAreaPrice(int area, int price){
			return realestateMapper.selectRealEstateListByAreaPrice(area, price);
		}
		// input: RealEstate
		// output: 성공된 행의 개수
		public int addRealEstate(RealEstate realEstate) {
			return realestateMapper.insertRealEstate(realEstate);
		}
		//input: int id
		//output: id에대한 정보
		public int addrealEstateAsFiled(int realtorId, String address, int area, 
				String type, int price, int rentPrice) {// integer: null 도되고 not null도 가능할때
			return realestateMapper.insertRealEstateAsField(realtorId, address, area, type, rentPrice, null);
		}
		//input: id + price
		//output: id(int) + 성공된 행의 갯수
		
		public int updateRealEstateById(int id, int price, String type) {
			return realestateMapper.updateRealEstateById(id, price, type);
		}
		public int deleteRealEstateById(int id) {
			return realestateMapper.deleteRealEstateById(id);
		}

}
