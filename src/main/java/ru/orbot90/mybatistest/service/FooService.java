package ru.orbot90.mybatistest.service;

import org.springframework.transaction.annotation.Transactional;
import ru.orbot90.mybatistest.model.UserEntity;

/**
 * Created by orbot on 19.06.16.
 */
public interface FooService {
    UserEntity doSomeBusinessStuff(String userId);

    @Transactional
    UserEntity doSomeJpaBusinessStuff(String userId);

    @Transactional
    UserEntity doSomeJDBCBusinessStuff(String userId);

    @Transactional
    void someMybatisUpdate();

    @Transactional
    void someJpaUpdate();

    @Transactional
    void someJdbcUpdate();
}
