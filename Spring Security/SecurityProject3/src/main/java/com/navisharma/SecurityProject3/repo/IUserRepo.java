package com.navisharma.SecurityProject3.repo;

import com.navisharma.SecurityProject3.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<Users,String>
{
    Users findByName(String userName);   //It will give us the entire user details

}