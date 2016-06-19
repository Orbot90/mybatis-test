package ru.orbot90.mybatistest.mapper;

import org.apache.ibatis.jdbc.SQL;

/**
 * Created by orbot on 19.06.16.
 */

public class UserSqlBuilder {

    public String buildGetUserById(String id) {
        return new SQL() {{
            SELECT("*");
            FROM("users");
            WHERE("id = #{id}");
        }}.toString();
    }
}
