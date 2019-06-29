package com.cg.pos.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.pos.entity.PizzaDetailsDTO;
import com.cg.pos.exceptions.EmptyCollectionException;
import com.cg.pos.exceptions.InvalidInputsException;
import com.cg.pos.exceptions.InvalidItemCostException;
import com.cg.pos.exceptions.InvalidItemIdException;
import com.cg.pos.exceptions.InvalidItemQuantityException;
import com.cg.pos.service.*;
import com.cg.pos.service.impl.PizzaServiceImpl;

/**
 * 
 * @author trainee
 *
 */
public class PizzaOrderingSystem {

	public static void main(String[] args) {

		PizzaService operation = new PizzaServiceImpl();
		ArrayList<PizzaDetailsDTO> list;

		System.out.println("Existing data.......");
		System.out.println(operation.getDetails());
		System.out.println('\n');
		do {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			String choice;

			System.out.println("**********************************************************");
			System.out.println();
			System.out.println("Enter 1 to modify pizza details");
			System.out.println("Enter 2 to delete pizza details");
			System.out.println("Enter 3 to exit");
			System.out.println();
			System.out.println("**********************************************************");

			choice = scanner.next();
			try {
				switch (choice) {
				case "1":
					if (!(operation.isEmptyDatabase()))
						System.out.println("enter storeName to modify pizza details");
					int storeId = scanner.nextInt();
					//String storeName = tempStoreName.toUpperCase();
					System.out.println("enter pizza id to which you want to modify");
					int pizzaId;
					try {
						pizzaId = scanner.nextInt();
					} catch (InputMismatchException e) {
						throw new InvalidItemIdException("please give proper inputs");
					}
					if (!operation.isValidEnteredInputs(storeId, pizzaId)) {
						throw new InvalidInputsException("please enter valid store name and id... try again");
					}

					else {
						System.out.println("**********************************************************");
						System.out.println("enter 1 to modify itemName of" + pizzaId);
						System.out.println("enter 2 to modify quantity of" + pizzaId);
						System.out.println("enter 3 to modify cost of" + pizzaId);
						System.out.println("enter 4 to modify addOns of" + pizzaId);
						System.out.println("enter 5 to exit");
						System.out.println("**********************************************************");
					}

					String modifyChoice = scanner.next();

					switch (modifyChoice) {

					case "1":
						System.out.println("enter new name");
						String newName = scanner.next();
						list = operation.modifyName(pizzaId, newName);
						System.out.println("name modified");
						System.out.println(list);

						break;
					case "2":
						System.out.println("enter new quantity");
						try {
							int newQuantity = scanner.nextInt();
							list = operation.modifyQuantity(pizzaId, newQuantity);
							System.out.println("quantity modified");
							System.out.println(list);
							break;
						} catch (InputMismatchException e) {
							throw new InvalidItemQuantityException("please quantity must be the number.....try again");
						}
					case "3":
						System.out.println("enter new cost");
						try {
							double newCost = scanner.nextDouble();
							list = operation.modifyCost(pizzaId, newCost);
							System.out.println("cost modified");
							System.out.println(list);
						} catch (InputMismatchException e) {
							throw new InvalidItemCostException("please cost must be the number...  try again");
						}
						break;
					case "4":
						System.out.println("enter new addOns");

						String newAddOns = scanner.next();
						list = operation.modifyAddOns(pizzaId, newAddOns);
						System.out.println(list);

						break;
					case "5":
						System.out.println("Thank you..........");
						System.exit(0);
					default:
						System.out.println("enter valid options");

					}

					System.out.println("do you wants to continue again??? if Yes");
					System.out.println("type yes");
					System.out.println("or else press anything to exit");
					String response;
					response = scanner.next();
					String responseCaptured = response.toLowerCase();

					if (response.equals("yes"))
						break;

					else {
						System.out.println("Thank you... changes has been saved");
						System.exit(0);
					}
					break;
				case "2":

					if (!operation.isEmptyDatabase())
						System.out.println("enter storeName  to delete details");
					int storeId1 = scanner.nextInt();
//					String storeName1 = tempstoreName1.toUpperCase();
					System.out.println("Enter pizza id to delete");
					int pizzaId1 = scanner.nextInt();
					if (!operation.isValidEnteredInputs(storeId1, pizzaId1)) {
						throw new InvalidInputsException("please enter valid store name and id... try again");
					}

					else {
						list = operation.deletePizzaDetails(pizzaId1);
						System.out.println("deleted");
						System.out.println(list);
						System.out.println("you have deleted the pizza details......... ");
						System.out.println("do you wants to continue again?? if yes... ");
						System.out.println("type yes");
						System.out.println("or else press anything to exit");
						response = scanner.next();
						String responseCaptured1 = response.toLowerCase();
						if (response.equals("yes"))
							break;

						else {
							System.out.println("Thank you!! changes has been saved");
							System.exit(0);
						}
					}
					break;

				case "3":
					System.out.println("Thank you!! ");
					System.exit(0);
				default:
					System.err.println("please enter valid options...");
					break;

				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		} while (true);

	}
}
