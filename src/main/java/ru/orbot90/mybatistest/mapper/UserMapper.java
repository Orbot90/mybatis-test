package ru.orbot90.mybatistest.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import ru.orbot90.mybatistest.model.User;

/**
 * Created by orbot on 19.06.16.
 */
public interface UserMapper {
    @Select("SELECT * FROM users WHERE id = #{userId}")
    User getUser(@Param("userId") String userId);

    @SelectProvider(type = UserSqlBuilder.class, method = "buildGetUserById")
    User getUserById(@Param("id")String userId);
}
