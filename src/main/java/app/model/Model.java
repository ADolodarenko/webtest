package app.model;

import app.entities.User;

import java.util.List;
import java.util.Map;

public interface Model
{
	void add(User user);
	void edit(User user);
	void delete(User user);
	List<String> listNames();
	Map<Integer, String> list();
	User get(int id);
}
