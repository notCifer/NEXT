package com.app.service;

import java.util.Date;
import com.app.model.Conta;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

    static String expiration = "1800000";
    static String secret = "0bu>Q-PUK66(C4ZeN7Ha^4j2N1&+hN6:oS^5DK[N*y<-TWOh^X8?[IsG!Z[ImyH}(Cy+Nq|>G<&aS>8OShELqyRR,Jbb8iTql)c0acxhZe8sah7t&#5Xb;pP:*q7Q!O3trT++*SLL[5mad:HH4ejs+0q2HP-)end,8P8pi-2bqG2-E9}9FdS{]!tC{e+W)PJrf)|%42HL89<$k{npT7gOi[QZXDwGS5yzpxfKPnW?OT3zKIFe&msOe!o1$B8:7Xy";

    public static String gerarToken(Authentication auth) {
        Conta logado = (Conta) auth.getPrincipal();
        Date hoje = new Date();
        Date expirado = new Date(hoje.getTime() + Long.parseLong(expiration));
        return Jwts.builder().setIssuer("API da nextpoint").setSubject(logado.getId().toString()).setIssuedAt(hoje)
                .setExpiration(expirado).signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    public static boolean isValid(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public Long getIdConta(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();  
        return Long.parseLong(claims.getSubject());
    }

}