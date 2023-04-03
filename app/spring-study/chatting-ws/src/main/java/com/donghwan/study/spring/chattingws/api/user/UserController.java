package com.donghwan.study.spring.chattingws.api.user;

import com.donghwan.study.spring.chattingws.api.user.dto.UserCreationRequest;
import com.donghwan.study.spring.chattingws.api.user.dto.UserValidationType;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/api/v1/users/validation")
    public ResponseEntity<Boolean> getUserValidation(@RequestParam UserValidationType type, @RequestParam String value) {
        if (type == UserValidationType.NICKNAME) {
            return ResponseEntity.ok(userService.validateNickname(value));
        }

        throw new RuntimeException("no matching type(value: " + type.name() + "), please checking validation type");
    }

    @PostMapping("/api/v1/users")
    public ResponseEntity<Object> createUser(@RequestBody UserCreationRequest request) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(userService.createUser(request))
            .toUri();

        return ResponseEntity.created(uri).build();
    }
}
