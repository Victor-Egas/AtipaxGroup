package com.atipax.group.repository;

import com.atipax.group.model.User;
import com.atipax.group.model.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, String> {

    @Query(value = "SELECT * FROM TB_USER WHERE USER = :user", nativeQuery = true)
    UserEntity login(String user);
}
