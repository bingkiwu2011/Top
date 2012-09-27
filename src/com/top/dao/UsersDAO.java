package com.top.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.top.model.jpa.Users;

public interface UsersDAO extends PagingAndSortingRepository<Users, Long>{   
    public Users findByUsername(String username);
    
    @Query("select u from Users u order by id desc limit 10 ") 
    public List<Users> findTop10Sellers();
    
    public Users findByUserId(Long userId);
}  

