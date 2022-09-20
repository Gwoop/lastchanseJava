package com.example.lastchanse.pacege;


import com.example.lastchanse.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

    User findByUsername(String login);

}
