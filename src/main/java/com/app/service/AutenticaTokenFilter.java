package com.app.service;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.app.model.Conta;
import com.app.repository.ContaRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class AutenticaTokenFilter extends OncePerRequestFilter {

    private TokenService TS;
    private ContaRepository CR;

    public AutenticaTokenFilter(TokenService ts, ContaRepository cr) {
        TS = ts;
        CR = cr;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = recuperaToken(request);
        boolean valido = TokenService.isValid(token);
        if (valido) {
            AutenticaUsuario(token);
        }

        filterChain.doFilter(request, response);
    }

    private void AutenticaUsuario(String token) {
        Long idConta = TS.getIdConta(token);
        Conta conta = CR.findById(idConta).get();
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(conta, null,
                conta.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    private String recuperaToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            return null;
        }
        return token.substring(7, token.length());
    }

}