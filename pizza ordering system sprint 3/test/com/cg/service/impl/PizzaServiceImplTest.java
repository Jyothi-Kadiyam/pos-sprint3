package com.cg.service.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.cg.pos.exceptions.InvalidInputsException;

import com.cg.pos.exceptions.InvalidAddOnsException;
import com.cg.pos.exceptions.InvalidItemCostException;
import com.cg.pos.exceptions.InvalidItemIdException;
import com.cg.pos.exceptions.InvalidItemNameException;
import com.cg.pos.exceptions.InvalidItemQuantityException;
import com.cg.pos.exceptions.InvalidStoreNameException;
import com.cg.pos.service.PizzaService;
import com.cg.pos.service.impl.PizzaServiceImpl;

public class PizzaServiceImplTest {

	private PizzaService operation;

	@Before
	public void setUp() {
		operation = new PizzaServiceImpl();
	}

	@Test(expected = InvalidStoreNameException.class)
	public void testValidEntertedInputsFailed()
			throws InvalidInputsException, InvalidStoreNameException, InvalidItemIdException {
		operation.isValidEnteredInputs("1sdggghhg6456", 125123);
	}

	@Test
	public void testValidEnteredIdBySuccess()
			throws InvalidInputsException, InvalidStoreNameException, InvalidItemIdException {
		boolean actual = operation.isValidEnteredInputs("DOMINO", 1001);
		
	}

	@Test(expected = InvalidItemNameException.class)
	public void testInValidPizzaName() throws InvalidItemNameException {
		operation.modifyName(1223, "123R89*");
	}

	@Test(expected = InvalidItemNameException.class)
	public void testValidPizzaNameByEmpty() throws InvalidItemNameException {
		operation.modifyName(1234, "");
	}

	@Test(expected = InvalidItemQuantityException.class)
	public void testValidQuantity() throws InvalidItemQuantityException {
		operation.modifyQuantity(1234, 124564);
	}

	@Test(expected = InvalidItemQuantityException.class)
	public void testValidQuantityByZero() throws InvalidItemQuantityException {
		operation.modifyQuantity(1234, 0);
	}

	@Test(expected = InvalidItemCostException.class)
	public void testValidCostByZero() throws InvalidItemCostException {
		operation.modifyCost(1234, 0);
	}

	@Test(expected = InvalidAddOnsException.class)
	public void testValidAddOnBySpace() throws InvalidAddOnsException {
		operation.modifyAddOns(1234, "");
	}

	@Test(expected = InvalidAddOnsException.class)
	public void testValidAddOnByAlphaNumeric() throws InvalidAddOnsException {
		operation.modifyAddOns(1234, "dgdf34654");
	}
	// @Test(expected = EmptyCollectionException.class)
	// public void testEmptyCollection() throws EmptyCollectionException {
	// boolean actual = validateDetails.isEmptyCollection();
	// }
	//

}
