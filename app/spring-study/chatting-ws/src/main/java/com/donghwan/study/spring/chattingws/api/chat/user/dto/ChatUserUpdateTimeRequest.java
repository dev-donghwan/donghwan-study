package com.donghwan.study.spring.chattingws.api.chat.user.dto;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class ChatUserUpdateTimeRequest {

    private ChatUserTimeType type;

    private LocalDateTime updateTime;
}
