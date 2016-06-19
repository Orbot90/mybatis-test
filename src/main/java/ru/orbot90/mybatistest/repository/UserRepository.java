package ru.orbot90.mybatistest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.orbot90.mybatistest.model.UserEntity;

/**
 * Created by orbot on 19.06.16.
 */
public interface UserRepository extends JpaRepository<UserEntity, String> {

    @Transactional
    @Modifying
    @Query("update UserEntity u set u.name = :name")
    public int setNameFor(@Param("name")String name);
}
