package app.servlets;

import app.entities.User;
import app.model.Model;
import app.model.ModelFactory;
import app.model.ModelType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class EditServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/edit.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		req.setCharacterEncoding("cp1251");
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String password = req.getParameter("pass");
		
		Model model = ModelFactory.getModel(ModelType.DB);
		User user = model.get(id);
		user.setName(name);
		user.setPassword(password);
		
		model.edit(user);
		
		Map<Integer, String> users = model.list();
		req.setAttribute("users", users);
		getServletContext().getRequestDispatcher("/views/list.jsp").forward(req, resp);
	}
}
