package com.donghwan.study.spring.chattingws.domain.chat.user.repository;

import com.donghwan.study.spring.chattingws.domain.chat.user.entity.ChatUser;
import com.donghwan.study.spring.chattingws.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatUserRepository extends JpaRepository<ChatUser, Long> {

    boolean existsByOwnerUserAndTargetUser(User ownerUser, User targetUser);
}
