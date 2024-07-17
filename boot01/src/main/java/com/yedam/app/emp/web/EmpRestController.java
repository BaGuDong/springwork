package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;


@CrossOrigin("*")
@RestController //@Controller + 모든 메소드에 @ResponseBody 선언
public class EmpRestController {
	//내부 컨트롤러가 전부 AJAX 전용
	
	@Autowired
	EmpService empService;
	// REST : GET , POST ,PUT, DELETE 메소드 사용
	
	//전체조회
	@GetMapping("emps")
	public List<EmpVO> empList(){
		return empService.empList();
	}
	
	//단건조회
	@GetMapping("emps/{empid}")
	public EmpVO empInfo(@PathVariable Integer empid) {
		EmpVO empVO = new EmpVO();
		empVO.setEmpid(empid);
		return empService.empInfo(empVO);
	}
	//등록
	@PostMapping("emps")
	public int empInsert(@RequestBody EmpVO empVO) {
		return empService.empInsert(empVO);
	}
	//수정 -> Patch
	@PutMapping("emps/{empid}")//단건조회
	public Map<String, Object> empUpdate(@PathVariable Integer empid,
			                             @RequestBody EmpVO empVO){
		return empService.empUpdate(empVO);
	}
	//삭제
	@DeleteMapping("emps/{empid}")
	public Map<String,Object> empDelete(@PathVariable Integer empid){
		EmpVO empVO = new EmpVO();
		empVO.setEmpid(empid);
		return empService.empDelete(empVO);
	}
}
