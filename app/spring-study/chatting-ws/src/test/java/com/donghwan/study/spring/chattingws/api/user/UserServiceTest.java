package com.donghwan.study.spring.chattingws.api.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.donghwan.study.spring.chattingws.api.user.dto.UserCreationRequest;
import com.donghwan.study.spring.chattingws.domain.user.entity.User;
import com.donghwan.study.spring.chattingws.domain.user.repository.UserRepository;
import com.donghwan.study.spring.chattingws.env.DataJpaTestConfig;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;


@Import({DataJpaTestConfig.class})

@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
class UserServiceTest {

    @Autowired
    private EntityManager em;

    @Autowired
    private UserRepository userRepository;

    private UserService userService;

    @BeforeEach
    void beforeEach() {
        this.userRepository.deleteAll();
        this.userService = new UserService(userRepository);
    }

    @AfterEach
    void afterEach() {

    }

    static class SetUp {

        static List<User> createUser(UserRepository repository, List<UserCreationRequest> requests) {
            List<User> users = repository.saveAll(requests.stream()
                .map(User::from)
                .collect(Collectors.toList()));
            return users;
        }
    }

    @DisplayName(value = "User Nickname Validation T/C")
    @Test
    void Validation_User_Nickname() {
        //given
        List<UserCreationRequest> requests = IntStream.range(0, 10).boxed()
            .map(num -> UserCreationRequest.of(String.valueOf(num)))
            .collect(Collectors.toList());
        SetUp.createUser(userRepository, requests);

        //when
        List<Boolean> result = IntStream.range(0, 15).boxed()
            .map(num -> userService.validateNickname(String.valueOf(num)))
            .collect(Collectors.toList());

        //then
        assertEquals(15, result.size());
        assertEquals(5, (int) result.stream().filter(x -> x).count());
        assertEquals(10, (int) result.stream().filter(x -> !x).count());
    }

    @DisplayName(value = "User Creation T/C")
    @Test
    void Creation_User() {
        //given
        List<UserCreationRequest> requests = IntStream.range(0, 10).boxed()
            .map(num -> UserCreationRequest.of(String.valueOf(num)))
            .collect(Collectors.toList());

        //when
        List<Long> result = requests.stream()
            .map(userService::createUser)
            .collect(Collectors.toList());

        //then
        assertEquals(10, result.size());
    }

}