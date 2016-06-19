package ru.orbot90.mybatistest.mapper;

import org.apache.ibatis.jdbc.SQL;
import ru.orbot90.mybatistest.model.UserRequest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by orbot on 19.06.16.
 */

public class UserSqlBuilder {

    public String buildGetUserById(UserRequest request) {
        final String id = request.getId();
        List<Optional<UserRequest>> wheres = Arrays.asList(Optional.ofNullable(request));
        return new SQL() {{
            SELECT("*");
            FROM("userentity");
            wheres.forEach(where ->
                    where.ifPresent(request1 ->
                            WHERE("id = '" + request1.getId() + "'")));
        }}.toString();
    }
}
