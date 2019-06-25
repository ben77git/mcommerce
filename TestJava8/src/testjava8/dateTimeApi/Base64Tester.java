package testjava8.dateTimeApi;

import java.nio.charset.Charset;
import java.util.Base64;
import java.util.UUID;

public class Base64Tester {

	public static void main(String[] args) {
		Charset utf8Cs = Charset.forName("UTF-8");
		String base64EncodingString = Base64.getEncoder().encodeToString("TutorialsPoint?java8".getBytes(utf8Cs));
		System.out.println("Base64 Encoded string (basic) :" + base64EncodingString);
		
		// Decode
		byte[] base64DecodedBytes = Base64.getDecoder().decode(base64EncodingString);
		System.out.println("Original string : " + new String(base64DecodedBytes, utf8Cs));
		
		base64EncodingString = Base64.getUrlEncoder().encodeToString("TutorialsPoint?java8".getBytes(utf8Cs));
		System.out.println("Base64 Encoded string (URL) :" + base64EncodingString);
		
		StringBuilder sb = new StringBuilder();
		 for (int i = 0; i < 10; i++) {
			 sb.append(UUID.randomUUID().toString());
			
		}
		 byte[] mimeBytes = sb.toString().getBytes(utf8Cs);
		 String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
		 System.out.println("Base64 encoded String (MIME) : " + mimeEncodedString);

	}

}
