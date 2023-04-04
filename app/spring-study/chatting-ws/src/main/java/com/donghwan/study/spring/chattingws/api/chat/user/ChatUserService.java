package com.donghwan.study.spring.chattingws.api.chat.user;

import com.donghwan.study.spring.chattingws.api.chat.user.dto.ChatUserCreationRequest;
import com.donghwan.study.spring.chattingws.api.chat.user.dto.ChatUserUpdateTimeRequest;
import com.donghwan.study.spring.chattingws.domain.chat.user.entity.ChatUser;
import com.donghwan.study.spring.chattingws.domain.chat.user.repository.ChatUserRepository;
import com.donghwan.study.spring.chattingws.domain.user.entity.User;
import com.donghwan.study.spring.chattingws.domain.user.repository.UserRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ChatUserService {

    private final UserRepository userRepository;

    private final ChatUserRepository chatUserRepository;

    @Transactional(readOnly = true)
    public Long createChatUser(ChatUserCreationRequest request) {
        User findOwnerUser = userRepository.findById(request.getSenderUserId()).orElseThrow(() -> {
            throw new RuntimeException("user not found, value: " + request.getSenderUserId());
        });

        User findTargetUser = userRepository.findById(request.getReceiverUserId()).orElseThrow(() -> {
            throw new RuntimeException("user not found, value: " + request.getReceiverUserId());
        });

        if (chatUserRepository.existsByOwnerUserAndTargetUser(findOwnerUser, findTargetUser)) {
            throw new RuntimeException("already exist chat user");
        }

        return chatUserRepository.save(ChatUser.of(findOwnerUser, findTargetUser)).getId();
    }

    @Transactional
    public LocalDateTime updateChatUserTime(Long chatUserId, ChatUserUpdateTimeRequest request) {
        ChatUser findChatUser = chatUserRepository.findById(chatUserId).orElseThrow(() -> {
            throw new RuntimeException("chat user not found, value: " + chatUserId);
        });

        return findChatUser.updateTime(request);
    }
}
