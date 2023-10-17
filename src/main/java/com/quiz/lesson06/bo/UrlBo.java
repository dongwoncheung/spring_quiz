package com.quiz.lesson06.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.mapper.UrlMapper;

@Service
public class UrlBo {
	@Autowired
	private UrlMapper urlMapper;
	public String addUrl() {
		return urlMapper.addUrl();
	}
	public String addUrl(int id, String name, String address) {
		return urlMapper.addUrl();
	}
}
