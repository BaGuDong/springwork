package com.yedam.app.emp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Service //AOP가 적용될 유일한 Bean
public class EmpServiceImpl implements EmpService{
	
	@Autowired // 필드주입
	private EmpMapper empMapper;
	
	//전체조회
	@Override
	public List<EmpVO> empList() {
		// TODO Auto-generated method stub
		return empMapper.selectEmpAll();
	}
	
	//조회
	@Override
	public EmpVO empInfo(EmpVO empVO) {
		// TODO Auto-generated method stub
		return empMapper.selectEmpInfo(empVO);
	}
	
	//등록
	@Override
	public int empInsert(EmpVO empVO) {
		int result = empMapper.insertEmpInfo(empVO);
		return result ==1 ? empVO.getEmpid() : -1;
	}
	
	//수정
	@Override
	public Map<String, Object> empUpdate(EmpVO empVO) {
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;
		
		int result
			= empMapper.updateEmpInfo(empVO.getEmpid(), empVO);
		if(result ==1 ) {
			isSuccessed = true;
		}
		map.put("result",isSuccessed);
		map.put("target",empVO);
		return map;
	}
	
	//삭제
	@Override
	public Map<String, Object> empDelete(EmpVO empVO) {
		Map<String, Object> map = new HashMap<>();
		
		int result = empMapper.deleteEmpInfo(empVO.getEmpid());
		
		if(result ==1 ) {
			map.put("empid", empVO.getEmpid());
		}
		return map;
	}
	
	
}
