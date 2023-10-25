package com.quiz.booking.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.booking.domain.Booking;

@Repository
public interface BookingMapper {
	public List<Booking> selectBookingList();
	
	public void deleteBookingById(int id);
	public void insertBooking(
			//2개이상의 파라미터 쓸시 @Param을 써야된다
			@Param("name") String name,
			@Param("date") String date,
			@Param("day") int day,
			@Param("headcount") int headcount,
			@Param("phoneNumber") String phoneNumber);
	
	// 예전 정보가 한개가 아닐 가능성이 있다 -> 중복된걸 방지 할려면list
	public List<Booking> selectBookingByNamePhoneNumber(
			@Param("name")String name, 
			@Param("phoneNumber")String phoneNumber);
}
