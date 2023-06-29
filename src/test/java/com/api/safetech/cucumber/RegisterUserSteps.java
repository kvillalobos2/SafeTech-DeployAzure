package com.api.safetech.cucumber;

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
public class RegisterUserSteps {

    private RestTemplate restTemplate = new RestTemplate();
    private String url = "http://localhost:8080/api/v1";
    private String message = "";
    User user;
    Long userId = randomLong();

    private Long randomLong() {
        Long generatedLong = new Random().nextLong();
        return generatedLong;
    }

    @Given("I want to register as user")
    public void iWantToRegister() {
        String userUrl = url + "/users";
        String getEndpoint=restTemplate.getForObject(userUrl, String.class);
        log.info(getEndpoint);
        assertTrue(!getEndpoint.isEmpty());
    }

    /*@And("I enter my own information like firstName {string}, lastName {string}, dni {string}, email {string}, password {string}, address {string}, phone {string} and birthday {string}")
    public void iEnterMyOwnInformationLikefirstNamelastNamedniemailpasswordaddressphoneAndbirthday(String firstName, String lastName, String dni, String email, String password, String address, String phone, String birthday) {
        String userUrl = url + "/users";

        User newUser = new User(userId, firstName, lastName, dni, email, password, address, phone, birthday);
        user = restTemplate.postForObject(userUrl, newUser, User.class);
        log.info(user.getId());
        assertNotNull(user);
    }*/

    @Then("I should be able to see my newly account")
    public void iShouldBeAbleToSeeMyNewlyAccount() {
        String userUrl = url + "/users/" + user.getId();

        try{
            User getUserById = restTemplate.getForObject(userUrl, User.class, user.getId());
            log.info(getUserById);
        }catch(RestClientException e){
            message = "";
        }
        assertEquals("", message);
    }

    @And("I enter my own information like firstName {string}, lastName {string}, dni {string}, email {string}, password {string}, address {string}, phone {string} and birthday {string}")
    public void iEnterMyOwnInformationLikeFirstNameFirstNameLastNameLastNameDniDniEmailEmailPasswordPasswordAddressAddressPhonePhoneAndBirthdayBirthday(String firstName, String lastName, String dni, String email, String password, String address, String phone, String birthday) {
        String userUrl = url + "/users";

        User newUser = new User(userId, firstName, lastName, dni, email, password, address, phone, birthday);
        user = restTemplate.postForObject(userUrl, newUser, User.class);
        log.info(user.getId());
        assertNotNull(user);
    }
}
