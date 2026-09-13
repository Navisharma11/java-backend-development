package com.navisharma.SecurityProject3.service;

import com.navisharma.SecurityProject3.entity.Users;
import com.navisharma.SecurityProject3.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    private IUserRepo repo;

    public Users register(Users user)
    {
        return repo.save(user);
    }

}
