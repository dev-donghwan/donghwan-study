package com.donghwan.study.spring.chattingws.env;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@TestConfiguration
@EnableJpaAuditing
public class DataJpaTestConfig {

    @Autowired
    private EntityManager entityManager;

}