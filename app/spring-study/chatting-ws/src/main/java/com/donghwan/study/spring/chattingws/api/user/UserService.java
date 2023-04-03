package com.donghwan.study.spring.chattingws.api.user;

import com.donghwan.study.spring.chattingws.api.user.dto.UserCreationRequest;
import com.donghwan.study.spring.chattingws.domain.user.entity.User;
import com.donghwan.study.spring.chattingws.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;

    @Transactional(readOnly = true)
    public boolean validateNickname(String nickname) {
        String failFormat = "user nickname validation no pass, cause by ";

        if (nickname.contains(" ")) {
            log.info(failFormat + "nickname is contains blank - value : {}", nickname);
            return false;
        }

        if (repository.existsByNickname(nickname)) {
            log.info(failFormat + "nickname already exist - value : {}", nickname);
            return false;
        }

        log.info("user nickname validation passed - value : {}", nickname);
        return true;
    }

    @Transactional
    public Long createUser(UserCreationRequest request) {
        User user = User.from(request);
        return repository.save(user).getId();
    }
}
