package com.primenumber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.primenumber.bean.RequestBean;
import com.primenumber.bean.RequestBeanUntillNumber;
import com.primenumber.bean.ResponseBean;
import com.primenumber.constant.ConstantUrl;
import com.primenumber.service.PrimeNumberService;

@RestController
public class PrimeNumberController {

	
	@Autowired
	PrimeNumberService primeNumberService;
	
//	@GetMapping(ConstantUrl.test)
//	@ApiResponses(value = {@ApiResponse(code = 500 ,message = "Internal Server Error",response = ExceptionBean.class)})
//	public ResponseEntity<?> trial(){
//		return new ResponseEntity<>("Hello",HttpStatus.OK);
//	}
	
	@PostMapping(ConstantUrl.PRIMENUMBER)
	public ResponseEntity<?> getPrimeNumber(@RequestBody RequestBean requestBean){
		ResponseBean<?> responseBean = primeNumberService.getPrimeNumber(requestBean);
		return new ResponseEntity<>(responseBean,HttpStatus.OK);
		
	}
	
	@PostMapping(ConstantUrl.PRIMENUMBERTILLNUMBER)
	public ResponseEntity<?> getPrimeNumberTillNumber(@RequestBody RequestBeanUntillNumber requestBean) {
		ResponseBean<?> responseBean = primeNumberService.getPrimeNumbersTillN(requestBean);
		return new ResponseEntity<>(responseBean,HttpStatus.OK);
	}
	
}
