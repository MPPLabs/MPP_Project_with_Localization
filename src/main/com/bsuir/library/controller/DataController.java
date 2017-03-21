package main.com.bsuir.library.controller;

import javax.swing.text.html.parser.Entity;

import com.sun.scenario.effect.impl.prism.PrImage;

import main.com.bsuir.library.dao.AbstractDaoController;
import main.com.bsuir.library.dao.exception.DaoException;

public class DataController extends AbstractDaoController {

	@Override
	public Entity getByPrimaryKey(PrImage key) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entity update(Entity entity) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(PrImage key) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(Entity entity) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

}
