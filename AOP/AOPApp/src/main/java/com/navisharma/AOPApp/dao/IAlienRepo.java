package com.navisharma.AOPApp.dao;

import com.navisharma.AOPApp.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlienRepo extends JpaRepository<Alien,Integer>
{

}
