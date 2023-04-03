package com.donghwan.study.spring.chattingws.domain.user.repository;

import com.donghwan.study.spring.chattingws.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByNickname(String nickname);
}
