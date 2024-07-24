package com.example.demo;

import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void generateSecretKey() {
		SecretKey key = Jwts.SIG.HS512.key().build();

		System.out.println("Key :"+ DatatypeConverter.printHexBinary(key.getEncoded()));
	}

}
