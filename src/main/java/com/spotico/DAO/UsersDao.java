package com.spotico.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spotico.pojos.User;

public interface UsersDao extends JpaRepository<User, Long> {

}
