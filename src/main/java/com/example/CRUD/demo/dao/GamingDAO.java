package com.example.CRUD.demo.dao;

import java.util.List;

import com.example.CRUD.demo.entity.Game;

public interface GamingDAO {
   void save(Game game);
   Game get(Integer id);
   List<Game> findAll();
   void update(Game theGame);
   void delete(Integer id); 
}
