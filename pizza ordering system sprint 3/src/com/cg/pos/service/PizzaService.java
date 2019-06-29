package com.cg.pos.service;

import java.util.ArrayList;

import com.cg.pos.entity.PizzaDetailsDTO;
import com.cg.pos.exceptions.EmptyCollectionException;
import com.cg.pos.exceptions.InvalidAddOnsException;
import com.cg.pos.exceptions.InvalidItemCostException;
import com.cg.pos.exceptions.InvalidItemIdException;
import com.cg.pos.exceptions.InvalidItemNameException;
import com.cg.pos.exceptions.InvalidItemQuantityException;
import com.cg.pos.exceptions.InvalidStoreIdException;
import com.cg.pos.exceptions.InvalidStoreNameException;

public interface PizzaService {
	ArrayList<PizzaDetailsDTO> getDetails();

	ArrayList<PizzaDetailsDTO> modifyName(int pizzaId, String name) throws InvalidItemNameException;

	ArrayList<PizzaDetailsDTO> modifyQuantity(int pizzaId, int quantity) throws InvalidItemQuantityException;

	ArrayList<PizzaDetailsDTO> modifyCost(int pizzaId, double cost) throws InvalidItemCostException;

	ArrayList<PizzaDetailsDTO> modifyAddOns(int pizzaId, String addOns) throws InvalidAddOnsException;

	ArrayList<PizzaDetailsDTO> deletePizzaDetails(int id) throws EmptyCollectionException;

	boolean isValidEnteredInputs(int storeId, int id) throws InvalidStoreNameException, InvalidItemIdException, InvalidStoreIdException;

	boolean isEmptyDatabase() throws EmptyCollectionException;
}
