package com.sportico.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportico.pojos.User;

public interface UsersDao extends JpaRepository<User, Long> {

}
