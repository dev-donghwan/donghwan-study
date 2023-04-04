package com.donghwan.study.spring.chattingws.api.chat.user;

import com.donghwan.study.spring.chattingws.api.chat.user.dto.ChatUserCreationRequest;
import com.donghwan.study.spring.chattingws.api.chat.user.dto.ChatUserUpdateTimeRequest;
import java.net.URI;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RequiredArgsConstructor
@RestController
public class ChatUserController {

    private final ChatUserService chatUserService;

    @PostMapping("/api/v1/chats/users")
    public ResponseEntity<Object> createUser(@RequestBody ChatUserCreationRequest request) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(chatUserService.createChatUser(request))
            .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PatchMapping("/api/v1/chats/users/{chatUserId}/time")
    public ResponseEntity<LocalDateTime> updateChatUserTime(@PathVariable Long chatUserId, @RequestBody ChatUserUpdateTimeRequest request) {
        return ResponseEntity.ok(chatUserService.updateChatUserTime(chatUserId, request));
    }
}
