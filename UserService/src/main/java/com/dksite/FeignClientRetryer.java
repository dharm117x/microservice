package com.dksite;

import feign.RetryableException;
import feign.Retryer;

public class FeignClientRetryer implements Retryer {

	@Override
	public void continueOrPropagate(RetryableException e) {

	}

	@Override
	public Retryer clone() {
		return null;
	}

}
