package com.app.configs.services;

// import java.util.Arrays;
// import java.util.Collection;
// import java.util.stream.Collectors;
// import com.app.models.Usuario;
// import com.app.models.Regra;
// import com.app.models.form.UsuarioFORM;
// import com.app.repositories.UsuarioRepository;
// import com.app.repositories.RegraRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.stereotype.Service;

public class UserServiceImpl  {

    // implements UserService

    // @Autowired
    // private BCryptPasswordEncoder Bcrypt;

    // private UsuarioRepository CR;

    // public UserServiceImpl(UsuarioRepository cR) {
    //     CR = cR;
    // }

    // @Autowired
    // private RegraRepository RR;

    // @Override
    // public Usuario save(UsuarioFORM FORM){
    //     Usuario C = new Usuario(FORM.getEmail(),FORM.getPassword(),
    //             Arrays.asList(InseriRegra()));
    //     return CR.save(C);
    // }

    // @Override
    // public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //     Usuario conta = CR.findByEmail(username);
    //     if (conta == null) {
    //         throw new UsernameNotFoundException("Usuário ou Senha invalidos!");
    //     }
    //     return new User(conta.getUsuario(), conta.getSenha(), mAuthorities(conta.getRegras()));
    // }



    // private Regra InseriRegra(){
    //     String name = "ROLE_USUARIO";
    //     if (RR.findByName(name) == null) {
    //         Regra R = new Regra(name);
    //         RR.save(R);
    //         return R;
    //     }
    //     return RR.findByName(name);
          
    // }

}