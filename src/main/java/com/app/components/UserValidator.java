package com.app.components;

import com.app.interfaces.UserService;
import com.app.models.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService US;

    @Override
    public boolean supports(Class<?> clazz) {
        return Conta.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Conta C = (Conta) target;

        if (US.findByusuario(C.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.contaForm.username");
        }
        
    }
    
}