package com.example.CRUD.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.CRUD.demo.entity.Game;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class GamingDAOImple implements GamingDAO{

    private EntityManager entityManager;

    @Autowired
    public GamingDAOImple(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Game game) {
        entityManager.persist(game);
    }

    @Override
    public Game get(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public List<Game> findAll() {
        TypedQuery<Game> query = entityManager.createQuery("FROM Game", Game.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Game theGame) {
        entityManager.merge(theGame);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Game gameToDelete = entityManager.find(Game.class, id);
        entityManager.remove(gameToDelete);
    }
    
}