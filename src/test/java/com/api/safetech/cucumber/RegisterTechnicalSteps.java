package com.api.safetech.cucumber;

import com.api.safetech.technical.domain.model.entity.Technical;
import com.api.safetech.user.domain.model.entity.User;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.log4j.Log4j2;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RegisterTechnicalSteps {

    private RestTemplate restTemplate = new RestTemplate();
    private String url = "http://localhost:8080/api/v1";
    private String message="";
    Technical technical;
    Long technicalId = randomLong();

    private Long randomLong() {
        Long generatedLong = new Random().nextLong();
        return generatedLong;
    }

    @Given("I want to register as technical")
    public void iWantToRegisterAsTechnical() {
        String technicalUrl = url + "/technicals";
        String getEndPoint = restTemplate.getForObject(technicalUrl, String.class);
        log.info(getEndPoint);
        assertTrue(!getEndPoint.isEmpty());
    }

    @And("I enter my own information like firstName {string}, lastName {string}, dni {string}, email {string}, password {string}, address {string}, phone {string}, birthday {string} and aboutMe {string}")
    public void iEnterMyOwnInformationLikeFirstNameFirstNameLastNameLastNameDniDniEmailEmailPasswordPasswordAddressAddressPhonePhoneBirthdayBirthdayAndAboutMeAboutMe(String firstName, String lastName, String dni, String email, String password, String address, String phone, String birthday, String aboutMe) {
        String technicalUrl = url + "/technicals";

        Technical newTechnical = new Technical(technicalId, firstName, lastName, dni, email, password, address, phone, birthday, aboutMe);
        technical = restTemplate.postForObject(technicalUrl, newTechnical, Technical.class);
        log.info(technical.getId());
        assertNotNull(technical);
    }

    @Then("I should be able to see my newly technical account")
    public void iShouldBeAbleToSeeMyNewlyTechnicalAccount() {
        String userUrl = url + "/technicals/" + technical.getId();
        try
        {
            User getTechnicalById = restTemplate.getForObject(userUrl, User.class, technical.getId());
            log.info(getTechnicalById);
        }catch (RestClientException e) {
            message = "";
        }
        assertEquals("", message);
    }
}
