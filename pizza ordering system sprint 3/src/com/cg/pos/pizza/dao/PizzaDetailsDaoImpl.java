package com.cg.pos.pizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.pos.entity.PizzaDetailsDTO;
import com.cg.pos.utility.ConnectionFactory;
import com.cg.pos.utility.Queries;

public class PizzaDetailsDaoImpl implements PizzaDetailsDao {

	PizzaDetailsDTO detailsDTO = new PizzaDetailsDTO();

	public boolean ValidEnteredInputs(int storeId, int id) {
		boolean result = false;
		try {
			Connection connection = ConnectionFactory.getConnection();
			String sql = Queries.retriveStoreNameQuery;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
		
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				if (resultSet.getInt(1) == storeId && resultSet.getInt(2) == id) {
					System.out.println("ers");
					detailsDTO.setStoreId(resultSet.getInt(1));
					result = true;
					break;
				}
				result = false;
			}
		} catch (SQLException e) {
			System.out.println("e");

		}
		return result;

	}

	@Override
	public boolean isEmptyDatabase() {
		
		boolean result = false;
		try {
			Connection connection = ConnectionFactory.getConnection();
			String sql = Queries.retriveCount;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(!resultSet.next()) {
				System.out.println("t");
					result = true;
				}
				
			}
		 catch (SQLException e) {
			System.out.println("e");

		}
		
		return result;
	}

	@Override
	public void deletePizzaDetails(int id) {
		
		try {
			Connection connection = ConnectionFactory.getConnection();
			String sql = Queries.retriveStoreNameQuery;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				if (resultSet.getInt(1) == storeId && resultSet.getInt(2) == id) {
					System.out.println("ers");
					detailsDTO.setStoreId(resultSet.getInt(1));
					result = true;
					break;
				}
				result = false;
			}
		} catch (SQLException e) {
			System.out.println("e");
		
		
	}

}
