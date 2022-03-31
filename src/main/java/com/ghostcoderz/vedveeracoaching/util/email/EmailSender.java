package com.ghostcoderz.vedveeracoaching.util.email;

import com.ghostcoderz.vedveeracoaching.dao.ContactUsDAO;
import com.ghostcoderz.vedveeracoaching.entity.ContactUs;
import com.ghostcoderz.vedveeracoaching.util.constant.CONTACT_STATUS;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class EmailSender {

    private final EmailSenderService emailSenderService;
    private final ContactUsDAO contactUsDAO;

    public EmailSender(EmailSenderService emailSenderService, ContactUsDAO contactUsDAO) {
        this.emailSenderService = emailSenderService;
        this.contactUsDAO = contactUsDAO;
    }

    public void sendSimpleContactEmail(String name,
                                 String email,
                                 String message,
                                 String course,
                                 int contactNum) {

        LocalDateTime currentTime = LocalDateTime.now();

        ContactUs contactUs = new ContactUs(name, email, message, course, LocalDateTime.now(), CONTACT_STATUS.PENDING, contactNum);

        long contactUsId = contactUsDAO.saveContactMessage(contactUs);

        if (contactUsId>0){
            //Sending Email to User
            emailSenderService.sendSimpleEmail(email, "Thanks for Feedback",
                    "Thanks for providing us your valuable feedback." +
                            " We will surely try to implement your ideas.");

            //Sending Email to Academy
            emailSenderService.sendSimpleEmail("veenaasole@gmail.com",
                    "VedVeera Academy | New Feedback",
                    name + " has sent a feedback for VedVeera Academy. Please review. \n" +
                            "\n" +
                            "Email : " + email + "\n" +
                            "Course : " + course + "\n" +
                            "Message : " + message);

            contactUsDAO.updateStatus(contactUsId, CONTACT_STATUS.EMAIL_SENT);
        } else {
            System.out.println("Unable to send email for ContactUs : " + contactUsId);
        }

    }

    public void sendTemplateContactEmail(String name,
                                       String email,
                                       String message,
                                       String course,
                                       int contactNum) {

        LocalDateTime currentTime = LocalDateTime.now();

        ContactUs contactUs = new ContactUs(name, email, message, course, LocalDateTime.now(), CONTACT_STATUS.PENDING, contactNum);

        long contactUsId = contactUsDAO.saveContactMessage(contactUs);

        if (contactUsId>0){
            //Sending Email to User
            emailSenderService.sendMimeEmail(email,
                    "Thanks for Feedback",
                    contactUs,
                    "contactUsNotificationTemp_user");

            //Sending Email to Academy
            emailSenderService.sendMimeEmail("veenaasole@gmail.com",
                    "VedVeeraAcademy - New Feedback",
                    contactUs,
                    "contactUsNotificationTemp_academy");

            boolean contactUpdated = contactUsDAO.updateStatus(contactUsId, CONTACT_STATUS.EMAIL_SENT);

            if(!contactUpdated){
                System.out.println("Unable to update the ContactUs : " + contactUsId);
            }

        } else {
            System.out.println("Unable to send email for ContactUs : " + contactUsId);
        }

    }

}
