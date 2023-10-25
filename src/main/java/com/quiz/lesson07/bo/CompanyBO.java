package com.quiz.lesson07.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.entity.CompanyEntity;
import com.quiz.lesson07.repository.CompanyRepository;
@Service
public class CompanyBO {
	//jpa문법
	//INPUT: 파라미터들4개  OUTPUT: 방금insert된 CompanyEntity
	@Autowired
	private CompanyRepository companyRepository;//jpa
	 	public CompanyEntity addCompany(String name, String business, 
	 			String scale, int headcount) {
	 		
	 		// 다 세팅하고 완성된 상태로 쓰인다 완성적으로 객체를 만들어준다
//	 		CompanyEntity Company = CompanyEntity.builder()
//	 				.name(name)
//	 				.business(business)
//	 				.scale(scale)
//	 				.createdAt(ZonedDateTime.now()) // ZonedDateTime -> 세계 시간utc형태로 나온다 타임존까지 고려된거 하지만 생략가능 왜냐하면 @UpdateTimestamp 떄문에
//	 				.build();
	 		return companyRepository.save(
	 					CompanyEntity.builder()
	 					.name(name)
	 					.business(business)
	 					.scale(scale)
	 					.headcount(headcount)
	 					.build()
	 				);
	 		
	 		
}
	 	//input: 3개의 파라미터  output:companyEntity
	 	public CompanyEntity updateCompanyByScale(int id ,String scale, int headcount) {// select을하고있다
	 		CompanyEntity company = companyRepository.findById(id).orElse(null); //company에 있는것을 변수로 선언을 한후 select한걸 변수에 저장
	 		if(company != null) {
	 			company = company.toBuilder()
	 					.scale(scale)
	 					.headcount(headcount)
	 					.build();
	 					companyRepository.save(company);
	 		}
	 		return company;
	 	}
	 	//input: id  // output: void 
	 	public void deleteCompanyById(int id) {
	 		Optional<CompanyEntity> companyOptional = companyRepository.findById(id);
	 		companyOptional.ifPresent(c -> companyRepository.delete(c));
	 	}
}
