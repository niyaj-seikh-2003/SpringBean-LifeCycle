package com.nt.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sneans.CheckingVotingEligibilty;

public class SpringBeanLifeCycleTest {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext(AppConfig.class);
		CheckingVotingEligibilty c=ctx.getBean("Voter",CheckingVotingEligibilty.class);
		try {
			String result=c.checkEligibility();
			System.out.println(result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		ctx.close();
	}

}
