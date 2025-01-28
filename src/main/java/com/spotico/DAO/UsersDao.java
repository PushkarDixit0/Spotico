package com.spotico.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spotico.pojos.Users;

public interface UsersDao extends JpaRepository<Users, Long> {

}
