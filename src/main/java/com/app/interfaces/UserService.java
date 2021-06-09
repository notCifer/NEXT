package com.app.interfaces;

import com.app.models.Conta;
import com.app.models.dto.CadastroDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    Conta save(CadastroDTO CDTO);
}