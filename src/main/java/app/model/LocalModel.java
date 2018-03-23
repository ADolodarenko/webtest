package app.model;

import app.entities.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalModel implements Model
{
	private static LocalModel instance = new LocalModel();
	
	private Map<Integer, User> model;
	private int maxId = 0;
	
	public static LocalModel getInstance()
	{
		return instance;
	}
	
	private LocalModel()
	{
		model = new HashMap<>();
	}
	
	@Override
	public void add(User user)
	{
		maxId++;
		user.setId(maxId);
		
		model.put(user.getId(), user);
	}
	
	@Override
	public void edit(User user)
	{
		model.put(user.getId(), user);
	}
	
	@Override
	public void delete(User user)
	{
		model.remove(user.getId());
	}
	
	@Override
	public List<String> listNames()
	{
		List<String> result = new ArrayList<>();
		
		for (User user : model.values())
			result.add(user.getName());
		
		return result;
	}
	
	@Override
	public User get(int id)
	{
		return model.get(id);
	}
	
	@Override
	public Map<Integer, String> list()
	{
		Map<Integer, String> result = new HashMap<>();
		
		for (User user : model.values())
			result.put(user.getId(), user.getName());
		
		return result;
	}
}
