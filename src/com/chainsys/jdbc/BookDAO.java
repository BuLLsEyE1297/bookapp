package com.chainsys.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO {
	
	public static void addBook(int id , String name , int price) throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionUtil.getconnection();
		String sql = "insert into book(id,name,price) values(?,?,?)";
		PreparedStatement preparedStatement = connection .prepareStatement(sql);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setInt(3, price);
		int rows = preparedStatement.executeUpdate();
		System.out.println("rows inserted:" + rows);
		ConnectionUtil.close(connection, preparedStatement, null);
	}
	public static void updateBook(int id) throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionUtil.getconnection();
		String sql = "update book set price =2000 where id =?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		int rows = preparedStatement.executeUpdate();
		System.out.println("rows updated:" + rows);
		ConnectionUtil.close(connection, preparedStatement, null);
	}

	public  static void  deleteBook(int id) throws SQLException, ClassNotFoundException {
		 Connection connection = ConnectionUtil.getconnection();
		String sql = "delete from book where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		int rows = preparedStatement.executeUpdate();
		System.out.println("rows deleted:" + rows);
		ConnectionUtil.close(connection, preparedStatement, null);
	}

	public  static void selectBook(int id) throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionUtil.getconnection();
		String sql = "select id, name,price from book where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1,id);
		ResultSet rset = preparedStatement.executeQuery();
		if(rset.next()){
			System.out.println("id\tname\tprice");
			System.out.println(rset.getInt("id")+"\t"
					+ rset.getString("name")+"\t"
					+rset.getInt("price"));
		}
			else{
				System.out.println("no records found");
			}
		ConnectionUtil.close(connection, preparedStatement,rset);
		
	}
	}

