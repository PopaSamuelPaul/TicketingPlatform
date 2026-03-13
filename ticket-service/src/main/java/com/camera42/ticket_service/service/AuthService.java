package com.camera42.ticket_service.service;


import com.camera42.ticket_service.dto.LoginRequest;
import com.camera42.ticket_service.dto.RegisterRequest;
import com.camera42.ticket_service.model.User;
import com.camera42.ticket_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;

    public String register(RegisterRequest request){
        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new RuntimeException("Acest email este deja folosit!");
        }
        User user = new User();
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
        return "Utilizatorul a fost înregistrat cu succes!";
    }

    public String login(@RequestBody LoginRequest request){
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Utilizatorul nu exista"));
        if(!(passwordEncoder.matches(request.getPassword(),user.getPassword()))){
            throw new RuntimeException("parola gresita!");
        }
        return jwtService.generateToken(user);
    }
}
