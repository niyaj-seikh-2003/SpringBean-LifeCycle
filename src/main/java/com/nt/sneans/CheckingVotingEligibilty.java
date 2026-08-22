package com.nt.sneans;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("Voter")
@PropertySource("com/nt/commons/Info.properties")
public class CheckingVotingEligibilty 
{
	@Value("${voter.id}")
	private Integer id;
	@Value("${voter.name}")
	private String name;
	@Value("${voter.age}")
	private Integer age;
	
	private Date verifiedOn;
	
	
	public CheckingVotingEligibilty() {
		System.out.println("CheckingVotingEligibilty.CheckingVotingEligibilty()");
	}
	
	@PostConstruct
	public void myInit() {
		System.out.println("CheckingVotingEligibilty.myInit()");
		verifiedOn = new Date();
		if(name==null||age<=0) {
			throw new IllegalArgumentException("Invalid name and age");
		}
	}
	
	
	public String checkEligibility() {
		System.out.println("CheckingVotingEligibilty.checkEligibility()");
		if(age >18)
			return "Mr./Miss/Mrs."+name+" u r not eligible for voting--->verified on ::"+verifiedOn;
		else
			return "Mr./Miss/Mrs."+name+" u r  eligible for voting--->verified on ::"+verifiedOn;
		 
	}
	
	@PreDestroy
	public void myDestory() {
		System.out.println("CheckingVotingEligibilty.myDestory()");
		name=null;
		age=null;
		verifiedOn=null;
		id=null;
	}
	
	

}

