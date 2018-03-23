package app.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User
{
	private int id;
	private String name;
	private String password;
	private String description;
	private String imageFile;
	
	public User(){}
	
	public User(String name, String password)
	{
		this.name = name;
		this.password = password;
	}
	
	public User(ResultSet resultSet) throws SQLException
	{
		this.id = resultSet.getInt("id");
		this.name = resultSet.getString("name");
		this.password = resultSet.getString("password");
		this.description = resultSet.getString("description");
		this.imageFile = resultSet.getString("image_file");
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public String getImageFile()
	{
		return imageFile;
	}
	
	public void setImageFile(String imageFile)
	{
		this.imageFile = imageFile;
	}
	
	@Override
	public String toString()
	{
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				'}';
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		User user = (User) o;
		
		if (id != user.id) return false;
		if (name != null ? !name.equals(user.name) : user.name != null) return false;
		if (password != null ? !password.equals(user.password) : user.password != null) return false;
		if (description != null ? !description.equals(user.description) : user.description != null) return false;
		return imageFile != null ? imageFile.equals(user.imageFile) : user.imageFile == null;
	}
	
	@Override
	public int hashCode()
	{
		int result = id;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (password != null ? password.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (imageFile != null ? imageFile.hashCode() : 0);
		return result;
	}
}
