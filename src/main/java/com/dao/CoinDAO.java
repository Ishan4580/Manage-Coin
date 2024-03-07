package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import com.model.Coin;
import com.utils.ConnectionUtils;

public class CoinDAO {
	
	
	
	public List<Coin> getAllCoins()
	{
		List<Coin>coins=new ArrayList<Coin>();
		
		
		try (Connection connection=ConnectionUtils.getConnection()){
			String selectQuery="select * from coin_collection";
			PreparedStatement statement=connection.prepareStatement(selectQuery);
			ResultSet resultSet=statement.executeQuery(selectQuery);
		
			while(resultSet.next())
			{
				Coin coin=new Coin(resultSet.getInt("id"), resultSet.getString("country"), resultSet.getString("denomination"), resultSet.getInt("year_of_minting"), resultSet.getBigDecimal("current_value"), resultSet.getDate("acquired_date"));
				
				coins.add(coin);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return coins;
	}
	
	
	public Coin getById(int coinId)
	{
	
		Coin coin=new Coin();
		try (Connection connection=ConnectionUtils.getConnection()){
			String selectQuery="select * from coin_collection where id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(selectQuery);
			preparedStatement.setInt(1, coinId);
			ResultSet resultSet=preparedStatement.executeQuery();
		
			while(resultSet.next())
			{
				coin.setId(resultSet.getInt("id"));
				coin.setCountry(resultSet.getString("country")); 
				coin.setDenomination(resultSet.getString("denomination"));
				coin.setYearOfMinting(resultSet.getInt("year_of_minting"));
				coin.setCurrentValue(resultSet.getBigDecimal("current_value"));
				coin.setAcquiredDate(resultSet.getDate("acquired_date"));
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			coin=null;
		}
		return coin;
	}
	
	public int addCoin(Coin coin)
	{
	
		try (Connection connection=ConnectionUtils.getConnection()){
			String insertQuery="insert into coin_collection(country,denomination,year_of_minting,current_value,acquired_date)values(?,?,?,?,?)";
			PreparedStatement ps=connection.prepareStatement(insertQuery);
				
			ps.setString(1, coin.getCountry());
				ps.setString(2, coin.getDenomination());
				ps.setInt(3, coin.getYearOfMinting());
				ps.setBigDecimal(4, coin.getCurrentValue());
				ps.setDate(5,  new Date(coin.getAcquiredDate().getTime()));
				
				return ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0; 
		}
	}
	
	//update
	public int updateCoin(Coin coin)
	{
		int updateRow=0;
		
		try (Connection connection=ConnectionUtils.getConnection()){
			PreparedStatement ps=connection.prepareStatement("update coin_collection set country=?,denomination=?,year_of_minting=?,current_value=?,acquired_date=? where id=?");
				
			ps.setString(1, coin.getCountry());
				ps.setString(2, coin.getDenomination());
				ps.setInt(3, coin.getYearOfMinting());
				ps.setBigDecimal(4, coin.getCurrentValue());
				ps.setDate(5,  new Date(coin.getAcquiredDate().getTime()));
				ps.setInt(6, coin.getId());
				updateRow=ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0; 
		}
		
		return updateRow;
	
	}
	
	//delete
	public int deleteCoin(int coinId)
	{
		int updateRow=0;
		
		try (Connection connection=ConnectionUtils.getConnection()){
			PreparedStatement ps=connection.prepareStatement("delete from coin_collection where id=?");
				
				ps.setInt(1, coinId);
				updateRow=ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0; 
		}
		
		return updateRow;
	}
	
}
