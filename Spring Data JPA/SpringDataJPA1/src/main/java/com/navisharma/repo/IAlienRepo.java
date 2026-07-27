package com.navisharma.repo;

import com.navisharma.entity.Alien;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface IAlienRepo extends CrudRepository<Alien,Integer>
{

}
