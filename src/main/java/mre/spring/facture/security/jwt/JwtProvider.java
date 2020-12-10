package mre.spring.facture.security.jwt;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import mre.spring.facture.exception.SpringAuthException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.Base64;

import static io.jsonwebtoken.Jwts.parser;


@Service
public class JwtProvider {

    private KeyStore keyStore;

    @Value("${app.security.jwt.keyStore-location}")
    private String keyStorePath;

    @Value("${app.security.jwt.keyStore-password}")
    private String keyStorePassword;

    @Value("${app.security.jwt.keyStore-alias}")
    private String keyStoreAlias;

    @PostConstruct
    public void init() {
        try {
            keyStore = KeyStore.getInstance("JKS");
            InputStream resourceAsStream = getClass().getResourceAsStream(keyStorePath);
            keyStore.load(resourceAsStream, keyStorePassword.toCharArray());
        } catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException  e) {
            throw new RuntimeException("Exception occurred while loading keystore");
        }

    }

    public String generateToken(Authentication authentication) {
        org.springframework.security.core.userdetails.User principal = (User) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(principal.getUsername())
                .signWith(getPrivateKey())
                .compact();
    }

    private PrivateKey getPrivateKey() {
        try {
            PrivateKey key = (PrivateKey) keyStore.getKey(keyStoreAlias, keyStorePassword.toCharArray());
            return key;
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
            throw new SpringAuthException("Exception occured while retrieving public key from keystore", e);
        }
    }

    public boolean validateToken(String jwt) {
        parser().setSigningKey(getPublickey()).parseClaimsJws(jwt);
        return true;
    }

    private PublicKey getPublickey() {
        try {
            return keyStore.getCertificate(keyStoreAlias).getPublicKey();
        } catch (KeyStoreException e) {
            throw new SpringAuthException("Exception occured while " + "retrieving public key from keystore", e);
        }
    }

    public String getUsernameFromJwt(String token) {
        Claims claims = parser()
                .setSigningKey(getPublickey())
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

}
