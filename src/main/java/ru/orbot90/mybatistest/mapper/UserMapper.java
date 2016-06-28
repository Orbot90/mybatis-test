package ru.orbot90.mybatistest.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;
import ru.orbot90.mybatistest.model.UserEntity;
import ru.orbot90.mybatistest.model.UserRequest;

import java.util.List;

/**
 * Created by orbot on 19.06.16.
 */
public interface UserMapper {
    @Select("SELECT * FROM userentity WHERE id = #{userId}")
    UserEntity getUser(@Param("userId") String userId);

    @SelectProvider(type = UserSqlBuilder.class, method = "buildGetUserById")
    UserEntity getUserById(UserRequest request);

    @Update("UPDATE userentity SET name = 'lol' WHERE id = '1234'")
    int someUpdate();

    @Select("SELECT * FROM userentity")
    List<UserEntity> getUsers(RowBounds rowBounds);
}
