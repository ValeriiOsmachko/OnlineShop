package com.epam.osmachko.query;

/**
 * SQL Query container.
 * @author Valerii_Osmachko
 *
 */
public class Query {

	public static final String INSERT_USER = "INSERT INTO USERS (first_name,last_name,email,password,login) VALUES"
			+ "(?,?,?,?,?)";
	public static final String UPDATE_USER = "UPDATE USERS Set first_name = ?, last_name = ?, email = ?, password = ?, login = ? WHERE id = ?";	
	
	public static final String DELETE_USER = "DELETE * FROM USERS WHERE id = ?";
	
	public static final String GET_ALL_USERS = "SELECT * FROM USERS";
	
	public static final String GET_USER_BY_LOGIN = "SELECT * FROM USERS WHERE login = ?";
	
	public static final String SELECT_ALL_CATEGORIES = "SELECT * FROM CATEGORY";
	
	public static final String SELECT_ALL_MANUFACTURERS = "SELECT * FROM MANUFACTURER";
	
	public static final String SELECT_ALL_PRODUCTS = "SELECT * FROM PRODUCTS";
	
	public static final String SELECT_PRODUCT_BY_ID = "SELECT * FROM PRODUCTS WHERE idProduct = ?";
	
	public static final String INSERT_ORDER = "INSERT INTO ORDERS (idOrder,Status,Date,User_idUser,Details,uuid,address,cardNumber) VALUES (?,?,?,?,?,?,?,?)";
	
	public static final String INSERT_CART_INFO = "INSERT INTO CART_INFO (idOrderCart,Product_idProduct,amount,priceForOne) VALUES (?,?,?,?)";
	
	public static final String INSERT_INCORRECT_LOGIN_INPUT ="UPDATE USERS SET amountOfWrongLoginAttemps=? WHERE login=?";
	
	public static final String BAN_USER = "UPDATE USERS SET banTime=? WHERE login=?";
	
	public static final String UN_BAN_USER = "UPDATE USERS SET banTime=? WHERE login=?";
	
	public static final String SET_BLOCK_AMOUNT = "UPDATE USERS SET amountOfWrongLoginAttemps = ? WHERE login=?";
}
