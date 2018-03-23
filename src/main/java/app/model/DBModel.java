package app.model;

import app.entities.User;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBModel implements Model
{
	private static DBModel instance;
	private static DataSource dataSource;
	private static Connection connection;
	
	private final static String INSERT_CMD = "insert bunny(name, password, description, image_file) " +
			"values (?, ?, ?, ?)";
	private final static String UPDATE_CMD = "update bunny set name=?, password=?, description=?, image_file=? " +
			"where id=?";
	private final static String DELETE_ONE_CMD = "delete bunny where id=?";
	private final static String SELECT_ALL_CMD = "select id, name, password, description, image_file from bunny";
	private final static String SELECT_ALL_NAMES_CMD = "select name from bunny";
	private final static String SELECT_ALL_ID_NAMES_CMD = "select id, name from bunny";
	private final static String SELECT_ONE_CMD = "select id, name, password, description, image_file from bunny " +
			"where id=?";
	
	public static synchronized DBModel getInstance()
	{
		if (instance == null)
			try
			{
				instance = new DBModel();
				Context ctx = new InitialContext();
				instance.dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/WebtestDS");
				connection = dataSource.getConnection();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			catch (NamingException e)
			{
				e.printStackTrace();
			}
		
		return instance;
	}
	
	private DBModel(){}
	
	@Override
	public void add(User user)
	{
		try (PreparedStatement statement = connection.prepareStatement(INSERT_CMD))
		{
			statement.setString(1, user.getName());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getDescription());
			statement.setString(4, user.getImageFile());
			
			statement.execute();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void edit(User user)
	{
		try (PreparedStatement statement = connection.prepareStatement(UPDATE_CMD))
		{
			statement.setString(1, user.getName());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getDescription());
			statement.setString(4, user.getImageFile());
			statement.setInt(5, user.getId());
			
			statement.execute();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(User user)
	{
		try (PreparedStatement statement = connection.prepareStatement(DELETE_ONE_CMD))
		{
			statement.setInt(1, user.getId());
			
			statement.execute();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public List<String> listNames()
	{
		List<String> names = new ArrayList<>();
		
		try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_NAMES_CMD))
		{
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next())
				names.add(resultSet.getString("name"));
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return names;
	}
	
	@Override
	public Map<Integer, String> list()
	{
		Map<Integer, String> map = new HashMap<>();
		
		try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_ID_NAMES_CMD))
		{
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next())
				map.put(resultSet.getInt("id"), resultSet.getString("name"));
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return map;
	}
	
	@Override
	public User get(int id)
	{
		User user = null;
		
		try (PreparedStatement statement = connection.prepareStatement(SELECT_ONE_CMD))
		{
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next())
				user = new User(resultSet);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return user;
	}
}
