package com.donghwan.study.spring.chattingws.domain.chat.user.entity;

import com.donghwan.study.spring.chattingws.api.chat.user.dto.ChatUserTimeType;
import com.donghwan.study.spring.chattingws.api.chat.user.dto.ChatUserUpdateTimeRequest;
import com.donghwan.study.spring.chattingws.domain.user.entity.User;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Getter;

/*
 * ChatUser
 * 해당 클래스는 Chat에 있어서 User의 확장을 위해 존재하는 클래스입니다.
 * 기존의 User에서 메세지를 보내는 상대마다 tofhdns ChatUser를 생성합니다.
 *
 * OwnerUser : 메세지를 보내는 Sender를 의미합니다.
 * TargetUSer : 메세지를 받는 Receiver를 의미합니다.
 * LastChatExpiredTime : 채팅방 나가기를 실행한 시점을 체크합니다.
 * LastMessageReadTime : 마지막으로 메세지를 읽은 시점을 체크합니다.
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class ChatUser {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @JoinColumn(name = "owner_user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User ownerUser;

    @JoinColumn(name = "target_user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User targetUser;

    private LocalDateTime lastChatExpiredTime;

    private LocalDateTime lastMessageReadTime;

    public LocalDateTime updateTime(ChatUserUpdateTimeRequest request) {
        ChatUserTimeType type = request.getType();
        LocalDateTime time = request.getUpdateTime();

        if (type == ChatUserTimeType.EXPIRED) {
            this.lastChatExpiredTime = time;
            return this.lastChatExpiredTime;
        }

        if (type == ChatUserTimeType.READ) {
            this.lastMessageReadTime = time;
            return this.lastMessageReadTime;
        }

        throw new RuntimeException("no match type");
    }

    public static ChatUser of(User ownerUser, User targetUser) {
        LocalDateTime now = LocalDateTime.now();
        return ChatUser.builder()
            .ownerUser(ownerUser)
            .targetUser(targetUser)
            .lastChatExpiredTime(now)
            .lastMessageReadTime(now)
            .build();
    }
}
