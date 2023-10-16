package com.quiz.weather_history.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.weather_history.domain.WeatherHistory;
import com.quiz.weather_history.mapper.WeatherHistoryMapper;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class WeatherHistoryBO {
	@Autowired
	private WeatherHistoryMapper weatherHistoryMapper;
	//input:x
	//output:과거 날씨 List
	public List<WeatherHistory> getWeatherHistoryList (){
		return weatherHistoryMapper.selectWeatherHistoryList();
	}
	public void addWeatherHistory(String date, String weather, String microDust,
			double temperature, double precipitation, double windSpeed) {
		weatherHistoryMapper.insertWeatherHistory(date, weather, microDust, temperature, precipitation, windSpeed);
	}
	
}