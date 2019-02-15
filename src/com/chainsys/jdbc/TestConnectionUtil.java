package com.chainsys.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnectionUtil {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Connection connection= ConnectionUtil.getconnection();
	System.out.println(connection);
}
}
