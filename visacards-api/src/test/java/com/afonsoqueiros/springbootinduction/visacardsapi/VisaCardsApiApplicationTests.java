package com.afonsoqueiros.springbootinduction.visacardsapi;

import com.afonsoqueiros.springbootinduction.visacardsapi.domain.VisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.CreateVisaCard;
import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.GetVisaCard;

import com.afonsoqueiros.springbootinduction.visacardsapi.dtos.UpdateVisaCard;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.RestTemplate;

import java.time.format.DateTimeFormatter;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class VisaCardsApiApplicationTests {

	DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	@LocalServerPort
	private int port;

	private String baseUrl = "http://localhost";

	private static RestTemplate restTemplate;

	@Autowired
	private TestH2Repository testH2Repository;
	@BeforeAll
	public static  void init(){
		restTemplate = new RestTemplate();
	}

	@BeforeEach
	public void setUp(){
		baseUrl = baseUrl.concat(":").concat(port+"").concat("/api/v1/learning/visa/electron/");
	}
	@Test
	public void testCreateVisaCard() {
		CreateVisaCard createVisaCard = new CreateVisaCard();
		createVisaCard.setFirstName("Afonso");
		createVisaCard.setLastName("Queiros");
		createVisaCard.setCardNumber("4444333377779999");
		createVisaCard.setExpireDate("03/2024");
		createVisaCard.setPhoneNumber("+351913277689");
		createVisaCard.setAddress("Rua da xxx, 59");
		createVisaCard.setCvv("123");
		GetVisaCard response = restTemplate.postForObject(baseUrl, createVisaCard, GetVisaCard.class);
		assertEquals("Afonso", response != null ? response.getFirstName() : null);
		assertEquals("4444333377779999", response != null ? response.getCardNumber() : null);
		assertEquals(1, testH2Repository.findAll().size());
	}

	@Test
	@Sql(statements = "INSERT INTO VISA_CARD VALUES (1,'4913659656615151', 'Parque Industrial de Taveiro Lote 49', " +
			"'2018-12-06 12:00:28', '123', '12/2018', 'Carlos', 'Seabra'," +
			" '+35191916004323','2018-12-06 14:00:28') ;", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "DELETE FROM VISA_CARD WHERE FIRST_NAME = 'Carlos';",executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void testGetVisaCard() {
		GetVisaCard response = restTemplate.getForObject(baseUrl + "1", GetVisaCard.class);
		assertAll(
				() -> assertEquals("Carlos", response != null ? response.getFirstName() : null),
				() -> assertEquals(1, testH2Repository.findAll().size()),
				() -> assertEquals(1, response.getId())

		);

	}

	@Test
	@Sql(statements = "INSERT INTO VISA_CARD VALUES (2,'4913659656615152', 'Parque Industrial de Taveiro Lote 49', " +
			"'2018-12-06 12:00:28', '123', '12/2018', 'Carlos', 'Seabra'," +
			" '+35191916004323','2018-12-06 14:00:28') ;", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "DELETE FROM VISA_CARD WHERE Id = 2",executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void testUpdateVisaCard() {
		UpdateVisaCard updateVisaCard = new UpdateVisaCard();
		updateVisaCard.setLastName("Queiros");
		updateVisaCard.setPhoneNumber("+351913277689");
		updateVisaCard.setAddress("Rua da xxx, 59");

		long id = 2;
		VisaCard visaCardfromDb = testH2Repository.findById(id).get();

		restTemplate.put(baseUrl + "2", updateVisaCard);

		assertAll(
				() -> assertNotNull(updateVisaCard),
				() -> assertEquals("Queiros", updateVisaCard.getLastName())
		);
	}

	@Test
	@Sql(statements = "INSERT INTO VISA_CARD VALUES (3,'4913659656615151', 'Parque Industrial de Taveiro Lote 49', " +
			"'2018-12-06 12:00:28', '123', '12/2018', 'Carlos', 'Seabra'," +
			" '+35191916004323','2018-12-06 14:00:28') ;", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	public void testDeleteVisaCard() {
		long id = 2;
		int recordCount = testH2Repository.findAll().size();
		restTemplate.delete(baseUrl + "3");

		assertAll(
				() -> assertEquals(1, recordCount),
				() -> assertEquals(0, testH2Repository.findAll().size())
		);
	}
}
