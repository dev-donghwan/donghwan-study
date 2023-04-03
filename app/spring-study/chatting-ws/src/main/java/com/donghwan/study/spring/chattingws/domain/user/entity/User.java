package com.donghwan.study.spring.chattingws.domain.user.entity;

import com.donghwan.study.spring.chattingws.api.user.dto.UserCreationRequest;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "users")
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String nickname;

    public static User of(String nickname) {
        return new User(null, nickname);
    }

    public static User from(UserCreationRequest request) {
        return new User(null, request.getNickname());
    }
}
