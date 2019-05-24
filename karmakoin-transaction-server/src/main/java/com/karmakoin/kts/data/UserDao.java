package com.karmakoin.kts.data;

import com.karmakoin.kts.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<UserEntity, Integer> {
    UserEntity findByName(String name);
}
