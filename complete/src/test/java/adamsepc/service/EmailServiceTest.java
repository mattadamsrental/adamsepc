package adamsepc.service;

import adamsepc.Application;
import adamsepc.ContactRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    @Test
    public void testEmailService() throws Exception {
        final ContactRequest contactRequest = new ContactRequest();
        contactRequest.setName("Matt Adams");
        contactRequest.setContact("07411570552");
        contactRequest.setEmail("Matt@mail.com");
        contactRequest.setEnquiry("I would like to make a booking.");
        contactRequest.setEnquiryType("Booking");

        emailService.sendContactMail(contactRequest);
    }

}