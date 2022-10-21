package com.primenumber.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primenumber.bean.RequestBean;
import com.primenumber.bean.RequestBeanUntillNumber;
import com.primenumber.bean.ResponseBean;
import com.primenumber.entity.PrimeNumber;
import com.primenumber.repository.PrimeNumberRepository;

@Service
public class PrimeNumberServiceImpl implements PrimeNumberService {

	@Autowired
	PrimeNumberRepository primeNumberRepository;

	@Override
	public ResponseBean<?> getPrimeNumber(RequestBean requestBean) {

		ResponseBean<List<Long>> responseBean = new ResponseBean<>();
		long startValue = requestBean.getStartValue();

		long endValue = requestBean.getEndValue();

		if (startValue < 0 || endValue < 0) {
			responseBean.setMessage("Please enter natural numbers ");
			return responseBean;
		} else {
			
			if (startValue > endValue) {
				responseBean.setMessage("Starting number should be less than ending value");
				return responseBean;
			}else if(startValue == endValue){
				responseBean.setMessage("Please enter different values for start and end point");
				return responseBean;
			}
			else if(startValue > 1000000000 || endValue > 1000000000) {
				responseBean.setMessage("Please enter values less than 10^9 ");
				return responseBean;
			}
		}

		String algorithmValue = requestBean.getAlgorithmName();

		

		if (algorithmValue != null && !algorithmValue.isEmpty()) {
			
			if (algorithmValue.equals("bruteForce")) {
				Date startedAt = new Date();
				PrimeNumber primeNumber = new PrimeNumber();
				primeNumber.setAlgorithmChoosen(algorithmValue);
				primeNumber.setStartedAt(startedAt);
				primeNumber.setStartingValue(startValue);
				primeNumber.setEndingValue(endValue);
				List<Long> list = primeNumberBruteForce(startValue, endValue);
				primeNumber.setNumberGenerated(Integer.toUnsignedLong(list.size()));
				Date endedAt = new Date();
				long timeDifference = endedAt.getTime() - startedAt.getTime();
				primeNumber.setEndedAt(endedAt);
				primeNumber.setTimeElapsed(timeDifference);
				primeNumberRepository.save(primeNumber);
				responseBean.setMessage("Successfull ");
				responseBean.setData(list);
				return responseBean;
			}
			
			else if(algorithmValue.equals("segmentedSieve")) {
				Date startedAt = new Date();
				PrimeNumber primeNumber = new PrimeNumber();
				primeNumber.setAlgorithmChoosen(algorithmValue);
				primeNumber.setStartedAt(startedAt);
				primeNumber.setStartingValue(startValue);
				primeNumber.setEndingValue(endValue);
				List<Long> list = SegmentedSieveOfEratosthenes.calculate(startValue, endValue);
				primeNumber.setNumberGenerated(Integer.toUnsignedLong(list.size()));
				Date endedAt = new Date();
				long timeDifference = endedAt.getTime() - startedAt.getTime();
				primeNumber.setEndedAt(endedAt);
				primeNumber.setTimeElapsed(timeDifference);
				primeNumberRepository.save(primeNumber);
				responseBean.setMessage("Successfull ");
				responseBean.setData(list);
				return responseBean;
			}
			else {
				responseBean.setMessage("Algorithm not found");
				return responseBean;
			}

		} else {
			responseBean.setMessage("Please enter a algorithm name");
			return responseBean;
		}
		

//		System.err.println(requestBean);
//		return responseBean;
	}

	// Brute Force Method 
	List<Long> primeNumberBruteForce(long startValue, long endValue) {
		List<Long> primeNumbers = new ArrayList<>();
		if (startValue < 2 && endValue > 2) {
			primeNumbers.add((long) 2);
		}
		startValue = startValue < 3 ? 3 : startValue;
		startValue = startValue % 2 == 0 ? ++startValue : startValue;

		boolean primeFlag;
		for (long i = startValue; i < endValue; i = i + 2) {
			primeFlag = true;

			for (long j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					primeFlag = false;
					break;
				}
			}
			if (primeFlag == true) {
				primeNumbers.add(i);
			}
		}
		return primeNumbers;

	}
	
	List<Long> sieveOfEratosthenes(long endValue) {
		List<Long> primeNumbers = new ArrayList<>();
		 boolean[] prime = new boolean[(int)(endValue + 1)];
	        for (int i = 0; i <= endValue; i++) prime[i] = true;

	        for (int p = 2; p * p <= endValue; p++) {
	            if (prime[p]) {
	                for (int i = p * p; i <= endValue; i += p)
	                    prime[i] = false;
	            }
	        }

	        for (int i = 2; i <= endValue; i++) {
	            if (prime[i])
	                primeNumbers.add((long) i);
	        }
		return primeNumbers;
	}

	@Override
	public ResponseBean<?> getPrimeNumbersTillN(RequestBeanUntillNumber requestBean) {
		// TODO Auto-generated method stub
		ResponseBean<List<Long>> responseBean = new ResponseBean<>();
		long startValue = 0;
		long endValue = requestBean.getEndValue();
		System.out.print(endValue);
		if (endValue <= 0) {
			responseBean.setMessage("Please enter natural numbers ");
			return responseBean;
		}else if(endValue > 1000000000) {
			responseBean.setMessage("Please enter values less than 10^9");
			return responseBean;
		}
		String algorithmValue = requestBean.getAlgorithmName();
		
		if(algorithmValue != null && !algorithmValue.isEmpty()) {
			if (algorithmValue.equals("bruteForceUntillNumber")) {
				Date startedAt = new Date();
				PrimeNumber primeNumber = new PrimeNumber();
				primeNumber.setAlgorithmChoosen(algorithmValue);
				primeNumber.setStartedAt(startedAt);
				primeNumber.setStartingValue(startValue);
				primeNumber.setEndingValue(endValue);
				List<Long> list = primeNumberBruteForce(startValue, endValue);
				primeNumber.setNumberGenerated(Integer.toUnsignedLong(list.size()));
				Date endedAt = new Date();
				long timeDifference = endedAt.getTime() - startedAt.getTime();
				primeNumber.setEndedAt(endedAt);
				primeNumber.setTimeElapsed(timeDifference);
				primeNumberRepository.save(primeNumber);
				responseBean.setMessage("Successfull ");
				responseBean.setData(list);
				return responseBean;
			}
			else if(algorithmValue.equals("SieveOfEratosthenes")) {
				Date startedAt = new Date();
				PrimeNumber primeNumber = new PrimeNumber();
				primeNumber.setAlgorithmChoosen(algorithmValue);
				primeNumber.setStartedAt(startedAt);
				primeNumber.setStartingValue(startValue);
				primeNumber.setEndingValue(endValue);
				List<Long> list = primeNumberBruteForce(startValue, endValue);
				primeNumber.setNumberGenerated(Integer.toUnsignedLong(list.size()));
				Date endedAt = new Date();
				long timeDifference = endedAt.getTime() - startedAt.getTime();
				primeNumber.setEndedAt(endedAt);
				primeNumber.setTimeElapsed(timeDifference);
				primeNumberRepository.save(primeNumber);
				responseBean.setMessage("Successfull ");
				responseBean.setData(list);
				return responseBean;
			}
			else {
				responseBean.setMessage("Please enter valid algorihtm Name");
				return responseBean;
			}
		}
		else {
			responseBean.setMessage("Please enter algorithm name");
			return responseBean;
		}
	}



}

// Segmented Sieve Program
class SegmentedSieveOfEratosthenes {
	 static long[] array;
	    static long[] primes;
	    public static List<Long> calculate(long n, long m) {
	    	List<Long> primeNumbers = new ArrayList<>();
	        int j = 0;
	        int sqt = (int) Math.sqrt(m);
	        array = new long[sqt + 1];
	        primes = new long[sqt + 1];

	        initialise(sqt + 1);
	        for (int i = 2; i <= sqt; i++) {
	            if (array[i] == 1) {
	                primes[j] = i;
	                j++;
	                for (int k = i + i; k <= sqt; k += i) {
	                    array[k] = 0;
	                }
	            }
	        }
	        int diff = (int) (m - n + 1);
	        array = new long[diff];
	        initialise(diff);
	        for (int k = 0; k < j; k++) {
	            int div = (int) (n / primes[k]);
	            div *= primes[k];
	            while (div <= m) {
	                if(div>=n && primes[k]!=div)
	                    array[(int) (div-n)] = 0;
	                div += primes[k];
	            }
	        }
	        for (int i = 0; i < diff; i++) {
	            if (array[i] == 1 && (i+n) !=1)
	                primeNumbers.add(n + i);
	        }
	        
	        return primeNumbers;
	    }
	    public static void initialise(int sqt) {
	        for (int i = 0; i < sqt; i++) {
	            array[i] = 1;
	        }
	    }
}

