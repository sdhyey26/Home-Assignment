package com.tss.model.inheritance.exceptions;

public class OverDraftLimitReachedException extends RuntimeException {
	int overDraftLimit ;
	
	public OverDraftLimitReachedException(int overDraftLimit ) {
		this.overDraftLimit = overDraftLimit;
	}
	
	public String getMessage()
	{
		return "Your overdraft limit is : " + overDraftLimit;
	}
}
