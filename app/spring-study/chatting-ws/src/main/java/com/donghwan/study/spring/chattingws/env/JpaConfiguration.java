package com.donghwan.study.spring.chattingws.env;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaConfiguration {

    @PersistenceContext
    private EntityManager entityManager;
}
