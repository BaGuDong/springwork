package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest
class Boot01ApplicationTests {
	
	@Autowired
	EmpMapper empMapper;
	
//	@Test
//	void contextLoads() {
//		assertNotNull(empMapper);
//	}
//	
//	@Test
//	void selectEmpAll() {
//		//전체조회
//		List<EmpVO> list = empMapper.selectEmpAll();
//		assertTrue(!list.isEmpty());
//	}
//	@Test
//	void selectEmpInfo() {
//		//단건조회
//		EmpVO empVO = new EmpVO();
//		empVO.setEmpid(114);
//		
//		EmpVO findVO = empMapper.selectEmpInfo(empVO);
//		assertEquals(findVO.getEmpname(),"Den");
//	}
	@Test
	void insertEmpInfo() {
		//등록
		EmpVO empVO = new EmpVO();
		empVO.setEmpname("Hong");
		empVO.setSal(1000);
		empVO.setDeptid(40);
		
		int result = empMapper.insertEmpInfo(empVO);
		//assertEquals(result, 1);\
		assertEquals(empVO.getEmpid(),205);
	}
	
//	@Test
//	void updateEmpInfo() {
//		//1.단건조회 => 2.업데이트
//		//1-1) 조건 
//		EmpVO empVO = new EmpVO();
//		empVO.setEmpid(1);
//		
//		//1-2) 조회
//		EmpVO findVO = empMapper.selectEmpInfo(empVO);
//		findVO.setEmpname("Hong");
//		findVO.setMgr(114);
//		
//		int result
//			=empMapper.updateEmpInfo(findVO.getEmpid(),findVO);
//		
//		assertEquals(1,result);
//	}
//	
//	@Test
//	void deleteEmpInfo() {
//		int result = empMapper.deleteEmpInfo(1);
//		assertEquals(1,result);
//	}
}
