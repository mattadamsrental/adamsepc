package adamsepc.controller;

import adamsepc.ContactRequest;
import adamsepc.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {

    @Autowired
    private EmailService emailService;

    @RequestMapping("/contact")
    public String sendContactRequest(final ContactRequest contactRequest) throws Exception {
        emailService.sendContactMail(contactRequest);
        return "redirect:/?fromContact=true";
    }
}
