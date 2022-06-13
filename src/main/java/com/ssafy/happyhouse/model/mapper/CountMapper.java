package com.ssafy.happyhouse.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.CountDto;

@Mapper
public interface CountMapper {

	List<CountDto> countList() throws Exception;

	// 랭킹순 정렬 (Count-PreCount)
	List<CountDto> preCountList() throws Exception;

	void rankUpdate(List<CountDto> list) throws Exception;

	void visitApt(String aptCode) throws Exception;
	
	int checkApt(String aptCode) throws Exception;
	void visitInsertApt(Map<String,Object> map) throws Exception;
	
}
