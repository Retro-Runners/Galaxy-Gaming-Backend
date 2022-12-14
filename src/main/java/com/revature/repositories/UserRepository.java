package com.revature.repositories;

import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    User findById(int id);
    Optional<User> findByEmailAndPassword(String email, String password);

    @Transactional
    @Modifying
    @Query(value = "UPDATE users set address =:ADDRESS WHERE email=:EMAIL", nativeQuery = true)
    void updateAddress(@Param("ADDRESS") String address, @Param("EMAIL") String email);

    @Transactional
    @Query(value = "SELECT address from users WHERE email=:EMAIL", nativeQuery = true)
    String getEmail(@Param("EMAIL") String email);
}
