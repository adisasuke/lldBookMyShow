package org.aditya.bookmyshow.repository;

import org.aditya.bookmyshow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{


    User findById(long id);

}
