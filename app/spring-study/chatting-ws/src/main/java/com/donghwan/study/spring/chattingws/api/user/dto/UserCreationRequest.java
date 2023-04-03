package com.donghwan.study.spring.chattingws.api.user.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class UserCreationRequest {

    private String nickname;

    public static UserCreationRequest of(String nickname) {
        return new UserCreationRequest(nickname);
    }

}
