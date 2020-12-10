package mre.spring.facture.api;


import lombok.AllArgsConstructor;
import mre.spring.facture.dto.request.AuthenticationResponse;
import mre.spring.facture.dto.request.LoginRequest;
import mre.spring.facture.dto.request.RegisterRequest;
import mre.spring.facture.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthResource {

    private final AuthService authService;

    @PostMapping("/register")
    @Transactional(Transactional.TxType.REQUIRED)
    public ResponseEntity registration(@Valid @RequestBody RegisterRequest registerRequest) {
        authService.signup(registerRequest);
        return new ResponseEntity("User created Successully", OK);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @GetMapping("accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token) {
        authService.verifyAccount(token);
        return new ResponseEntity<>("Account Activated Successully", OK);
    }

}
