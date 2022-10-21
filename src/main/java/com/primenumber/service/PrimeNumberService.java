package com.primenumber.service;

import com.primenumber.bean.RequestBean;
import com.primenumber.bean.RequestBeanUntillNumber;
import com.primenumber.bean.ResponseBean;

public interface PrimeNumberService {

	ResponseBean<?> getPrimeNumber(RequestBean requestBean);
	
	ResponseBean<?> getPrimeNumbersTillN(RequestBeanUntillNumber requestBean);

}
