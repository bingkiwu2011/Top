package com.top.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.top.model.jpa.Users;

public interface UsersDAO extends PagingAndSortingRepository<Users, Long>{   
    public Users findByUsername(String username);
    
    @Query("select password from Users  where username=?1") 
    public Users fUsername(String username);
}  

