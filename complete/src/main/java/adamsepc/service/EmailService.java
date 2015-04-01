package adamsepc.service;

import adamsepc.ContactRequest;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import javax.mail.internet.MimeMessage;
import java.util.Locale;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;

    public void sendContactMail(final ContactRequest contactRequest) throws Exception {
        // Prepare the evaluation context
        final Context ctx = new Context(Locale.getDefault());
        ctx.setVariable("from", contactRequest.getName());
        ctx.setVariable("contact", contactRequest.getContact());
        ctx.setVariable("email", contactRequest.getEmail());
        ctx.setVariable("enquiryType", contactRequest.getEnquiryType());
        ctx.setVariable("enquiry", contactRequest.getEnquiry());
        ctx.setVariable("imageResourceName", "image"); // so that we can reference it from HTML

        // Prepare message using a Spring helper
        final MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
        final MimeMessageHelper message =
                new MimeMessageHelper(mimeMessage, true, "UTF-8"); // true = multipart
        message.setSubject("[adamsepc] Website Contact Request");
        message.setFrom("lowcostepc@gmail.com");
        message.setTo("matt.adams2@gmail.com");

        // Create the HTML body using Thymeleaf
        final String htmlContent = this.templateEngine.process("email-inlineimage", ctx);
        message.setText(htmlContent, true); // true = isHtml

        ClassPathResource resource = new ClassPathResource("adamsepclogo.jpg");
        byte[] imageBytes = FileUtils.readFileToByteArray(resource.getFile());

        // Add the inline image, referenced from the HTML code as "cid:${imageResourceName}"
        final InputStreamSource imageSource = new ByteArrayResource(imageBytes);
        message.addInline("image", imageSource, "image/jpeg");

        // Send mail
        this.javaMailSender.send(mimeMessage);
    }
}
