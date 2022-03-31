package com.ghostcoderz.vedveeracoaching.util.email;

import com.ghostcoderz.vedveeracoaching.entity.ContactUs;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Map;
import java.util.TreeMap;

@Service
public class EmailSenderService {

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    public EmailSenderService(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    public void sendSimpleEmail(String to, String subject, String text){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@vedveera.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }

    public void sendMimeEmail(String to, String subject,
                              Object object, String template) {

        Map<String, Object> variables = generateVariablesTreeMap(object);

        Context context = new Context();
        context.setVariables(variables);

        //Preparing the thymeleaf message
        String processedTemplate = templateEngine.process(template, context);

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message);

        try {
            messageHelper.setFrom("noreply@vedveera.com");
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            message.setText(processedTemplate, "UTF-8", "html");
            javaMailSender.send(message);
        } catch (MessagingException me){
            System.out.println("Error while sending an email");
            me.printStackTrace();
        }
    }

    public Map<String, Object> generateVariablesTreeMap(Object object){
        // Adding variables for template generation
        Map<String, Object> variables = new TreeMap<>();

        if(object!= null){
            if(object instanceof ContactUs contactUs){
                variables.put("userName", contactUs.getFullName());
                variables.put("userEmail", contactUs.getEmail());
                variables.put("userContactNum", contactUs.getContactNum());
                variables.put("userMessage", contactUs.getMessage());
//                if(!contactUs.getCourse().equals("none")){
                variables.put("userCourse", contactUs.getCourse());
//                }
            }
        }
        return variables;
    }

}
