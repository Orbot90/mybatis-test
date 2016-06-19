package ru.orbot90.mybatistest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.orbot90.mybatistest.mapper.UserMapper;
import ru.orbot90.mybatistest.model.UserEntity;
import ru.orbot90.mybatistest.model.UserRequest;
import ru.orbot90.mybatistest.repository.UserRepository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by orbot on 19.06.16.
 */
@Service
public class FooServiceImpl implements FooService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public FooServiceImpl(DataSource dataSource, UserMapper userMapper, UserRepository userRepository) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserEntity doSomeBusinessStuff(String userId) {
        return userMapper.getUserById(new UserRequest(userId));
    }

    @Override
    @Transactional
    public UserEntity doSomeJpaBusinessStuff(String userId) {
        return userRepository.findOne(userId);
    }

    @Override
    @Transactional
    public UserEntity doSomeJDBCBusinessStuff(String userId) {
        return jdbcTemplate.query("SELECT * FROM userentity WHERE id = '" + userId + "'", (resultSet, i) -> {
            UserEntity user = new UserEntity();
            user.setId(resultSet.getString(1));
            user.setName(resultSet.getString(2));
            return user;
        }).get(0);
    }

    @Override
    @Transactional
    public void someMybatisUpdate() {
        userMapper.someUpdate();
    }

    @Override
    @Transactional
    public void someJpaUpdate() {
        userRepository.setNameFor("lol");
    }

    @Override
    @Transactional
    public void someJdbcUpdate() {
        jdbcTemplate.update("UPDATE userentity SET name = 'lol' WHERE id = '1234'");
    }
}
