package com.navisharma.SecurityProject2.service;

import com.navisharma.SecurityProject2.entity.Users;
import com.navisharma.SecurityProject2.repo.IUserRepo;
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
