package com.chainsys.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class TestBook {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		int choice=0;
		Scanner scanner = new Scanner(System.in);
		System.out.println(" 1.Add Book Details \n 2.Update book details\n 3.delete Book details\n 4.select book details");
		System.out.println(" Enter the choice");
		choice=scanner.nextInt();
		switch(choice){
		case 1:{
			System.out.println("enter the book,id,name,price");
			int id =scanner.nextInt();
			String name= scanner.next();
			int price=scanner.nextInt();
			BookDAO.addBook(id, name, price);
			break;
		}
		case 2:{
			System.out.println("enter the book id to update");
			int id=scanner.nextInt();
			BookDAO.updateBook(id);
			break;
					}
		case 3:{
			System.out.println("enter the book id to delete");
			int id=scanner.nextInt();
			BookDAO.deleteBook(id);
			break;
		}
		case 4:{
			System.out.println("enter the book id to select");
			int id=scanner.nextInt();
			BookDAO.selectBook(id);
			break;
		}
		}
		
		
		
		scanner.close();
	}

	

	
}
