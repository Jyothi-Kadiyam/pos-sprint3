package com.cg.pos.staticdb;

import com.cg.pos.entity.*;
import java.util.ArrayList;

public class PizzaDetailsStaticDb {

	private static ArrayList<PizzaDetailsDTO> pizzaDetailList = new ArrayList<PizzaDetailsDTO>();

	public ArrayList<PizzaDetailsDTO> staticDb() {
		PizzaDetailsDTO pizza = new PizzaDetailsDTO(1001, 1100345, "Pizza1", 10, 100.00, "basePan");
		PizzaDetailsDTO pizza1 = new PizzaDetailsDTO(1023, 10102, "cheese Pizza", 150, 120.00, "extra cheese");
		PizzaDetailsDTO pizza2 = new PizzaDetailsDTO(1024, 10102, "cheese Pizza", 205, 209.00, "corn cheese");
		PizzaDetailsDTO pizza3 = new PizzaDetailsDTO(1002, 10101, "cheese Pizza", 198, 202.00, "cheese");
		getPizzaDetailList().add(pizza);
		getPizzaDetailList().add(pizza1);
		getPizzaDetailList().add(pizza2);
		getPizzaDetailList().add(pizza3);
		return pizzaDetailList;

	}

	public static ArrayList<PizzaDetailsDTO> getPizzaDetailList() {
		return pizzaDetailList;
	}

	public static void setPizzaDetailList(ArrayList<PizzaDetailsDTO> pizzaDetailList) {
		PizzaDetailsStaticDb.pizzaDetailList = pizzaDetailList;
	}}
