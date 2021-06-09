package com.app.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import com.app.interfaces.UserService;
import com.app.models.Conta;
import com.app.models.Regra;
import com.app.models.dto.CadastroDTO;
import com.app.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder Bcrypt;

    private ContaRepository CR;

    public UserServiceImpl(ContaRepository cR) {
        CR = cR;
    }

    @Override
    public Conta save(CadastroDTO CDTO) {
        Conta C = new Conta(CDTO.getUsername(), CDTO.getEmail(), Bcrypt.encode(CDTO.getPassword()),
                Arrays.asList(new Regra("REGRA_USUARIO")));
        return CR.save(C);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Conta conta = CR.findByusuario(username);
        if (conta == null) {
            throw new UsernameNotFoundException("Usuário ou Senha invalidos!");
        }
        return new User(conta.getUsuario(), conta.getSenha(), mAuthorities(conta.getRegras()));
    }

    private Collection<? extends GrantedAuthority> mAuthorities(Collection<Regra> regras) {
        return regras.stream().map(regra -> new SimpleGrantedAuthority(regra.getName())).collect(Collectors.toList());
    }

}