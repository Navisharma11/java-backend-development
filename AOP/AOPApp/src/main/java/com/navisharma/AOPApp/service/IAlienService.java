package com.navisharma.AOPApp.service;

import com.navisharma.AOPApp.model.Alien;

import java.util.List;

public interface IAlienService
{
    public Alien registerAlien(Alien alien);
    public List<Alien> getAllAliensInfo();

}
