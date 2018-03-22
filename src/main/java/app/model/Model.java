package app.model;

import app.entities.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model
{
	private static Model instance = new Model();
	
	private Map<Integer, User> model;
	private int maxId = 0;
	
	public static Model getInstance()
	{
		return instance;
	}
	
	private Model()
	{
		model = new HashMap<>();
	}
	
	public void add(User user)
	{
		maxId++;
		user.setId(maxId);
		
		model.put(user.getId(), user);
	}
	
	public void edit(User user)
	{
		model.put(user.getId(), user);
	}
	
	public void delete(User user)
	{
		model.remove(user.getId());
	}
	
	public List<String> listNames()
	{
		List<String> result = new ArrayList<>();
		
		for (User user : model.values())
			result.add(user.getName());
		
		return result;
	}
	
	public User get(int id)
	{
		return model.get(id);
	}
	
	public Map<Integer, String> list()
	{
		Map<Integer, String> result = new HashMap<>();
		
		for (User user : model.values())
			result.put(user.getId(), user.getName());
		
		return result;
	}
}
