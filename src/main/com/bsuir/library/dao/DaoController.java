package main.com.bsuir.library.dao;

import java.util.List;

import main.com.bsuir.library.dao.exception.DaoException;

public interface DaoController<Entity, PrimaryKey> {
    Entity getByPrimaryKey(PrimaryKey key) throws DaoException;
    Entity update(Entity entity) throws DaoException;
    boolean delete(PrimaryKey key) throws DaoException;
    boolean insert(Entity entity) throws DaoException;
}