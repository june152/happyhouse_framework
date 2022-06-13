package com.ssafy.happyhouse.schedul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ssafy.happyhouse.model.service.CommentService;
import com.ssafy.happyhouse.model.service.CountService;

@Component
public class ScheduleTask {

	
//	@Autowired
//	private CountService countService;
//	
//	@Scheduled(fixedDelay = 10000)
//	public void task() throws Exception {
//		countService.rankUpdate();
//	}
}
