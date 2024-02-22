package com.numetry.springboot_sms_app;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Component
public class Service {
	
	 private final String ACCOUNT_SID ="ACe1bbee08081e63356de2e81119d434aa";

	    private final String AUTH_TOKEN = "d1f04dffffa1fbaa66765943c9e25495";

	    private final String FROM_NUMBER = "+17696666230";

	    public void send(SmsPojo sms) {
	    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

	        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
	                .create();
	        System.out.println("here is my id:"+message.getSid());

	    }

	    public void receive(MultiValueMap<String, String> smscallback) {
	    }

}
