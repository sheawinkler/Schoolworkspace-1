import com.javacodegeeks.kannel.api.SMSManager;

public class SMSTime {
	public static void main(String[] args) {
		 SMSManager smsManager = SMSManager.getInstance();
		// We can change the prefetch size of the background worker thread
		 smsManager.setMessagesPrefetchSize(30);
		// We can change the send SMS rate
		 smsManager.setMessagesSendRate(65);
		try{
			// Send SMS to a single destination

			smsManager.sendSMS("localhost", "8080", "foo", "bar", "2283240972", "2283240972", "the_message");
			
			
			// Send a WAP Push request to a single mobile recipient

			//smsManager.sendWAPPush("localhost", "8080", "receiver_mobile_number",SMSManager.WAP_PUSH_RECEIVER_TYPE_MOBILE, "the_message", "http://localhost", 3);
			
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}
}
