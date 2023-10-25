package com.quiz.booking.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;

@Service
public class BookingBO {
	
	@Autowired
	private BookingMapper bookingMapper;

	// input:X     output:List<Booking>
	public List<Booking> getBookingList() {
		return bookingMapper.selectBookingList();
	}
	
	// input:id    output:X
	public void deleteBookingById(int id) {
		bookingMapper.deleteBookingById(id);
	}

	public void addBooking(String name,String date,
			int day,int headcount,String phoneNumber) {
		bookingMapper.insertBooking(name, date, day, headcount, phoneNumber);
		
	}
	//input->name phonenumber output: booking -> null(0)이거나 booking(1) / 한개
	public Booking getBookingByNamePhoneNumber(String name, String phoneNumber) {
		List<Booking> bookingList = bookingMapper.selectBookingByNamePhoneNumber(name, phoneNumber);
		//0, 1(최신데이터) / 최신데이터를 return한다
		//리스트가 비어있으면 null(heap영역에 아무것도 없다)이 아닌 []로 나온다
		if(bookingList.isEmpty()) {
			return null;		//null로 리턴하는것
		}
		//리스트가 비어있지 않으면 마지막 객체 return한다
		return bookingList.get(bookingList.size() - 1); // booking 을 리턴하는것
	}
}
