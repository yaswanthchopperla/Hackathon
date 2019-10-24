package com.batch2;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;

import org.apache.commons.math.random.RandomGenerator;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HackathonApplicationTests {

	@LocalServerPort
	int randomServerPort;

	private static final Logger logger = Logger.getLogger(HackathonApplicationTests.class);

	@Test
	public void testApproveLoginSuccess() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + randomServerPort + "/user/approveLogin/9/9";
		URI uri = new URI(baseUrl);
		ResponseEntity<Integer[]> result = restTemplate.getForEntity(uri, Integer[].class);
		logger.info(result.getStatusCodeValue());
		Assert.assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	public void testApproveLoginFailure() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + randomServerPort + "/user/approveLogin/0/9";
		URI uri = new URI(baseUrl);

		try {
			ResponseEntity<Integer[]> result = restTemplate.getForEntity(uri, Integer[].class);
		} catch (HttpClientErrorException ex) {
			// Verify bad request and missing header
			Assert.assertEquals(400, ex.getRawStatusCode());

		}

	}

	@Test
	public void testValidateRegistrationFormSuccess() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		String un = "11111";
		Random rand = new Random();
		un += String.format(" %d ", rand.nextInt());

		final String baseUrl = "http://localhost:" + randomServerPort + "/user/validateRegistrationForm/" + un
				+ "/11111";
		logger.info(baseUrl);
		URI uri = new URI(baseUrl);

		ResponseEntity<Integer> result = restTemplate.getForEntity(uri, Integer.class);
		logger.info(result.getStatusCodeValue());
		Assert.assertEquals(200, result.getStatusCodeValue());

	}

	/*
	 * @Test public void testValidateRegistrationFormFailure() throws
	 * URISyntaxException { RestTemplate restTemplate = new RestTemplate();
	 * 
	 * final String baseUrl = "http://localhost:" + randomServerPort +
	 * "/user/validateRegistrationForm/5/5"; URI uri = new URI(baseUrl);
	 * 
	 * try { ResponseEntity<Integer[]> result = restTemplate.getForEntity(uri,
	 * Integer[].class); } catch (HttpClientErrorException ex) { // Verify bad
	 * request and missing header Assert.assertEquals(400, ex.getRawStatusCode());
	 * 
	 * }
	 * 
	 * }
	 * 
	 * @Test public void testSaveCustomer() throws URISyntaxException { RestTemplate
	 * restTemplate = new RestTemplate();
	 * 
	 * final String baseUrl = "http://localhost:" + randomServerPort +
	 * "/address/saveCustomer/satya/2/2"; URI uri = new URI(baseUrl);
	 * 
	 * ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	 * // Verify request succeed System.out.println(result.getStatusCodeValue());
	 * Assert.assertEquals(200, result.getStatusCodeValue()); }
	 */
}
