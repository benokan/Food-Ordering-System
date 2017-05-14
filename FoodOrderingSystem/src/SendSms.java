import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SendSms {
	private  final String ACCOUNT_SID = "ACf10c3f353b91ffcf4333a32b7d3829c9";
	private  final String AUTH_TOKEN = "6173aea1255bc4eead0a1e10a4080f8a";
	
    public  void send(String phone,String password) {
		
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

	    Message message = Message.creator(new PhoneNumber(phone),
	        new PhoneNumber("+17273996035"), 
	        "Your new password is "+password+"This message has been send from Food Ordering System!").create();

	    //System.out.println(message.getSid());
		

	}
	
	
}
