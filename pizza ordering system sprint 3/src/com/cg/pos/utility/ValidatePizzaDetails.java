package com.cg.pos.utility;

import com.cg.pos.exceptions.*;

public class ValidatePizzaDetails {

	/**
	 * Validating the pizzaName.
	 * 
	 * @param pizzaName
	 * @return
	 * @throws InvalidItemNameException
	 */
	public boolean isValidName(String pizzaName) throws InvalidItemNameException {
		if (!pizzaName.matches("[a-z A-Z]+{1,25}")) {

			throw new InvalidItemNameException("Must have alphabets within in the range of 30");
		}
		return true;
	}

	/**
	 * Validating StoreName
	 * 
	 * @param storeName
	 * @return
	 * @throws InvalidStoreNameException
	 *             //
	 */
	public boolean isValidStoreId(int storeId) throws InvalidStoreIdException {
		String tempStoreId=Integer.toString(storeId);
		if (tempStoreId.matches("[a-z A-Z]+{1,25}")) {

			throw new InvalidStoreIdException("Must have numbers");
		}
		return true;
	}

	/**
	 * Validating Quantity
	 * 
	 * @param quantity
	 * @return
	 * @throws InvalidItemQuantityException
	 */
	public boolean isValidQuantity(int quantity) throws InvalidItemQuantityException {
		String stringQuantity = Integer.toString(quantity);
		if (!stringQuantity.matches("[0-9]{1,5}") || quantity <= 0) {

			throw new InvalidItemQuantityException("Must contain digits and it should not be zero");
		}

		return true;
	}

	/**
	 * validating Id
	 * 
	 * @param id
	 * @return
	 * @throws InvalidItemIdException
	 */
	public boolean isValidId(int id) throws InvalidItemIdException {
		String stringId = Integer.toString(id);
		if (!stringId.matches("[0-9]+{1,5}")) {

			throw new InvalidItemIdException("Must contain digits and it should not be zero");
		}

		return true;
	}

	/**
	 * Validating Cost
	 * 
	 * @param cost
	 * @return
	 * @throws InvalidItemCostException
	 */

	public boolean isValidCost(double cost) throws InvalidItemCostException {
		String stringCost = Double.toString(cost);
		if (stringCost.isEmpty() || cost <= 0.0 || stringCost.matches("[A-Z a-z]")) {
			throw new InvalidItemCostException("Cost must contain numbers and it should not be zero");
		}
		return true;

	}

	/**
	 * Validating Addons
	 * 
	 * @param addOns
	 * @return
	 * @throws InvalidAddOnsException
	 */

	public boolean isValidAddOn(String addOns) throws InvalidAddOnsException {
		if (!addOns.matches("[A-Z a-z]+{1,30}")) {
			throw new InvalidAddOnsException(" Addons must have alphabets within in the range of 30");
		}
		return true;
	}

}
