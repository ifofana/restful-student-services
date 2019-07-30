package com.ia.restfulstudentservices;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoderTest {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		//for(int i=1; i<=10; i++) {
			//String encodedString = encoder.encode("admin");
			//String encodedString = encoder.encode("user");
			String encodedString = encoder.encode("fofana");
			System.out.println(encodedString);
			//$2a$10$OqQGqcVxiSDuw4qyn0sIUeBi5T69r1Ux.o.0HbIRIIV2tEV8bh9tW
			//$2a$10$ONKYdbchPld/sLcIOfg18elUOdgHGt5.zvlnXto/zJrlSA6KjKyWS
			//$2a$10$H1dGU.URxRAdhu4OTBgvHOphxH8X.1lxvVXvKtjZSkLVVGKkASTBm
		//}
	}

}
