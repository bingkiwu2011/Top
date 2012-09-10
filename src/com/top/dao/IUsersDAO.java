package com.top.dao;

import org.springframework.data.repository.Repository;

import com.top.model.jpa.Users;

public interface IUsersDAO extends Repository<Users, Long>{   
    public Users findByUsername(String username);
}  
