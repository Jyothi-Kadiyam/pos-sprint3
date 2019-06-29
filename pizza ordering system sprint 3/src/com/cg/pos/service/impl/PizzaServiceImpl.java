package com.cg.pos.service.impl;

import com.cg.pos.staticdb.*;

import java.util.ArrayList;
import java.util.Iterator;

import com.cg.pos.entity.PizzaDetailsDTO;
import com.cg.pos.exceptions.EmptyCollectionException;
import com.cg.pos.exceptions.InvalidAddOnsException;
import com.cg.pos.exceptions.InvalidItemCostException;
import com.cg.pos.exceptions.InvalidItemIdException;
import com.cg.pos.exceptions.InvalidItemNameException;
import com.cg.pos.exceptions.InvalidItemQuantityException;
import com.cg.pos.exceptions.InvalidStoreIdException;
import com.cg.pos.exceptions.InvalidStoreNameException;
import com.cg.pos.pizza.dao.PizzaDetailsDao;
import com.cg.pos.pizza.dao.PizzaDetailsDaoImpl;
import com.cg.pos.service.PizzaService;
import com.cg.pos.utility.*;

public class PizzaServiceImpl implements PizzaService {

	ArrayList<PizzaDetailsDTO> list = PizzaDetailsStaticDb.getPizzaDetailList();

	ValidatePizzaDetails validatePizzaDetails = new ValidatePizzaDetails();
	PizzaDetailsDTO pizzaDetails;

	/**
	 * modifying name
	 */
	@Override
	public ArrayList<PizzaDetailsDTO> modifyName(int pizzaId, String name) throws InvalidItemNameException {
		

		if (validatePizzaDetails.isValidName(name)) {

			Iterator<PizzaDetailsDTO> i = list.iterator();
			while (i.hasNext()) {

				PizzaDetailsDTO pizza = (PizzaDetailsDTO) i.next();
				if (pizzaId == pizza.getItemId()) {
					pizza.setItemName(name);
				}
			}

		}
		return PizzaDetailsStaticDb.getPizzaDetailList();

	}

	/**
	 * modifying Quantity
	 */

	@Override
	public ArrayList<PizzaDetailsDTO> modifyQuantity(int pizzaId, int quantity) throws InvalidItemQuantityException {

		if (validatePizzaDetails.isValidQuantity(quantity)) {

			Iterator<PizzaDetailsDTO> index = list.iterator();
			while (index.hasNext()) {

				PizzaDetailsDTO pizza = (PizzaDetailsDTO) index.next();
				if (pizzaId == pizza.getItemId()) {
					pizza.setQuantity(quantity);

				}
			}
		}
		return PizzaDetailsStaticDb.getPizzaDetailList();

	}

	/**
	 * modifying cost
	 */
	@Override
	public ArrayList<PizzaDetailsDTO> modifyCost(int pizzaId, double cost) throws InvalidItemCostException {

		if (validatePizzaDetails.isValidCost(cost)) {

			Iterator<PizzaDetailsDTO> index = list.iterator();
			while (index.hasNext()) {
				PizzaDetailsDTO pizza = (PizzaDetailsDTO) index.next();
				if (pizzaId == pizza.getItemId()) {
					pizza.setCost(cost);
				}
			}

		}
		return PizzaDetailsStaticDb.getPizzaDetailList();
	}

	/**
	 * modifying addOns
	 */
	@Override
	public ArrayList<PizzaDetailsDTO> modifyAddOns(int pizzaId, String addOns) throws InvalidAddOnsException {

		if (validatePizzaDetails.isValidAddOn(addOns)) {

			Iterator<PizzaDetailsDTO> index = list.iterator();
			while (index.hasNext()) {
				PizzaDetailsDTO pizza = (PizzaDetailsDTO) index.next();
				if (pizzaId == pizza.getItemId()) {
					pizza.setAddOns(addOns);
				}
			}
		}
		return PizzaDetailsStaticDb.getPizzaDetailList();
	}

	/**
	 * deleting pizzaDetails
	 */
	@Override
	public ArrayList<PizzaDetailsDTO> deletePizzaDetails(int id) throws EmptyCollectionException {
		PizzaDetailsDao pizzaDao=new PizzaDetailsDaoImpl();

//		Iterator<PizzaDetailsDTO> index = list.iterator();
		if (pizzaDao.isEmptyDatabase()) {
			throw new EmptyCollectionException("no more items to delete... Sorry!!");
		}
		pizzaDao.deletePizzaDetails(id);
		while (index.hasNext()) {
			PizzaDetailsDTO pizza = (PizzaDetailsDTO) index.next();
			if (id == pizza.getItemId()) {
				index.remove();

			}
		}

		return PizzaDetailsStaticDb.getPizzaDetailList();
	}

	@Override
	public ArrayList<PizzaDetailsDTO> getDetails() {
		PizzaDetailsStaticDb pizza = new PizzaDetailsStaticDb();
		return pizza.staticDb();
	}

	/**
	 * validating and verifying entered inputs
	 * @throws InvalidStoreIdException 
	 */

	public boolean isValidEnteredInputs(int storeId, int id)
			throws InvalidItemIdException, InvalidStoreIdException {

		list = PizzaDetailsStaticDb.getPizzaDetailList();
		if (validatePizzaDetails.isValidStoreId(storeId) && validatePizzaDetails.isValidId(id)) {
			
			PizzaDetailsDao pizzaDao=new PizzaDetailsDaoImpl();
            if(pizzaDao.ValidEnteredInputs(storeId,id))
            {
            	return true;
            }
		}
		return false;
	}

	/**
	 * checking whether the database is empty or not
	 */
	public boolean isEmptyDatabase() throws EmptyCollectionException {
		PizzaDetailsDao pizzaDao=new PizzaDetailsDaoImpl();
		if (pizzaDao.isEmptyDatabase()) {
			throw new EmptyCollectionException("no more items... Sorry!!");
		}
		return false;
	}
	public void dbConnection()
	{
			
	}

}
