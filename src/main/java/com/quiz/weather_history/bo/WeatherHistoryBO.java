
package com.quiz.weather_history.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_history.domain.WeatherHistory;
import com.quiz.weather_history.mapper.WeatherHistoryMapper;

@Service
public class WeatherHistoryBO {
	
	@Autowired
	private WeatherHistoryMapper weatherHistoryMapper;

	// input:X,  output:List<WeatherHistory>
	public List<WeatherHistory> getWeatherHistoryList() {
		return weatherHistoryMapper.selectWeatherHistoryList();
	}
	//input: 과거 날씨형식에 맞는 파라미터 값 output: 결과값
	public void addWeatherHistory(String date, String weather, String microDust,
			double temperatures, double precipitation,
			double windSpeed) {
		
		weatherHistoryMapper.insertWeatherHistory(date, weather, microDust, 
				temperatures, precipitation, windSpeed);
	}
}