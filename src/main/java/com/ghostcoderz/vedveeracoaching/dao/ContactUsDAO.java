package com.ghostcoderz.vedveeracoaching.dao;

import com.ghostcoderz.vedveeracoaching.entity.ContactUs;
import com.ghostcoderz.vedveeracoaching.respository.ContactUsRepository;
import com.ghostcoderz.vedveeracoaching.util.constant.CONTACT_STATUS;
import com.ghostcoderz.vedveeracoaching.util.exception.ContactUsNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class ContactUsDAO {

    private final ContactUsRepository contactUsRepository;

    public ContactUsDAO(ContactUsRepository contactUsRepository) {
        this.contactUsRepository = contactUsRepository;
    }

    public long saveContactMessage(ContactUs contactUs){
        ContactUs saved = contactUsRepository.save(contactUs);
        return saved.getId();
    }

    public boolean updateStatus(long contactUsId, CONTACT_STATUS status) {
        try {
            ContactUs contactUs = contactUsRepository.
                    findById(contactUsId)
                    .orElseThrow(() -> new ContactUsNotFoundException(
                            "Contact Not Found : " + contactUsId));
            contactUs.setStatus(status);
            contactUsRepository.saveAndFlush(contactUs);
            return true;
        } catch (Exception e){
            System.out.println(
                    "Exception occurred while updating ContactUs Status " + contactUsId);
            System.out.println(e);
            e.fillInStackTrace();
            return false;
        }
    }
}
