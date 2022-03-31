package com.ghostcoderz.vedveeracoaching.util.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ContactUsNotFoundException extends RuntimeException {

    public ContactUsNotFoundException(String msg){
        super(msg);
    }

}
