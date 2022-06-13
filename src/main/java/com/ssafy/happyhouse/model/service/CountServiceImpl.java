package com.ssafy.happyhouse.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.CountDto;
import com.ssafy.happyhouse.model.mapper.CountMapper;

@Service
public class CountServiceImpl implements CountService {

	@Autowired
	private CountMapper countMapper;

	// 렌더링용
	@Override
	public List<CountDto> countList() throws Exception {
		return countMapper.countList();
	}

	@Override
	public void rankUpdate() throws Exception {
		System.out.println("update 시작중");
		long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        

		List<CountDto> list = countMapper.preCountList();

		for (int i = 0; i < list.size(); i++) {
			// ( preCount를 count로 업데이트 )
			list.get(i).setPreCount(list.get(i).getCount());
			// 현재 index - preRank 를 rankChange에 업데이트
			list.get(i).setRankChange(-(i + 1 - list.get(i).getPreRank()));
			// preRank는 현재 index로 업데이트
			list.get(i).setPreRank(i + 1);
		}
		countMapper.rankUpdate(list);
		
		
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
		System.out.println("시간차이(m) : "+secDiffTime);
		System.out.println("update 작업 종료");
	}

	// 업데이트 용
	@Override
	public List<CountDto> preCountList() throws Exception {
		// TODO Auto-generated method stub

		return countMapper.preCountList();
	}

	@Override
	public void visitApt(String aptCode) throws Exception {
		if(countMapper.checkApt(aptCode) == 1) {
			countMapper.visitApt(aptCode);
		}else {
			List<CountDto> list = countMapper.countList();
			
			Map<String, Object> map = new HashMap<>();
			map.put("size", list.size()+1);
			map.put("aptCode", aptCode);
			countMapper.visitInsertApt(map);
		}
		
		
	}
}
