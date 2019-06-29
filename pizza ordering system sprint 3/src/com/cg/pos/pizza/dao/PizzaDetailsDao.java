package com.cg.pos.pizza.dao;

public interface PizzaDetailsDao {

	boolean ValidEnteredInputs(int storeId, int id);

	boolean isEmptyDatabase();

	void deletePizzaDetails(int id);
	

}
