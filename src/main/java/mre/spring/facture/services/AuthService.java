package mre.spring.facture.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mre.spring.facture.dto.request.AuthenticationResponse;
import mre.spring.facture.dto.request.LoginRequest;
import mre.spring.facture.dto.request.RegisterRequest;
import mre.spring.facture.exception.ObjectNotFoundException;
import mre.spring.facture.models.ApiUser;
import mre.spring.facture.models.NotificationEmail;
import mre.spring.facture.models.VerificationToken;
import mre.spring.facture.repositories.ApiUserRepository;
import mre.spring.facture.repositories.VerificationTokenRepository;
import mre.spring.facture.security.jwt.JwtProvider;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import static java.time.Instant.now;

@AllArgsConstructor
@Slf4j
@Service
public class AuthService {

    private final ApiUserRepository apiUserRepository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final VerificationTokenRepository verificationTokenRepository;
    private final MailService mailService;


    @Transactional
    public void signup(RegisterRequest registerRequest) {
        ApiUser user = new ApiUser();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(encodePassword(registerRequest.getPassword()));
        user.setCreated(now());
        user.setEnabled(false);

        apiUserRepository.save(user);
        String token = generateVerificationToken(user);
        mailService.sendMail(new NotificationEmail("Please Activate your Account",
                user.getEmail(), "Thank you for signing up to Spring Reddit, " +
                "please click on the below url to activate your account : " +
                "http://localhost:8080/api/auth/accountVerification/" + token));

    }

    public AuthenticationResponse login(LoginRequest loginRequest) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsername(),
                    loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String authenticationToken = jwtProvider.generateToken(authenticate);
        return new AuthenticationResponse(authenticationToken, loginRequest.getUsername());
    }

    private String generateVerificationToken(ApiUser user) {
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);
        verificationTokenRepository.save(verificationToken);
        return token;
    }

    public void verifyAccount(String token) {
        Optional<VerificationToken> verificationTokenOptional = verificationTokenRepository.findByToken(token);
        VerificationToken tokenVerified = verificationTokenOptional
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Token"));
        fetchUserAndEnable(tokenVerified);
    }

    private void fetchUserAndEnable(VerificationToken verificationToken) {
        String username = verificationToken.getUser().getUsername();
        ApiUser user = apiUserRepository.findByUsername(username).orElseThrow(() -> new ObjectNotFoundException("User not found with name - " + username));
        user.setEnabled(true);
        apiUserRepository.save(user);
    }

    private String encodePassword(String password) {
        return encoder.encode(password);
    }


}
