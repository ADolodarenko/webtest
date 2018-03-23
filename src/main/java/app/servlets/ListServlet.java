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

public class ListServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		req.setCharacterEncoding("cp1251");
		
		int action = checkAction(req);
		
		if (action == 0)
			doGet(req, resp);
		else if (action == 1)
		{
			String idParam = req.getParameter("id");
			
			if (idParam != null)
			{
				Model model = ModelFactory.getModel(ModelType.DB);
				User user = model.get(Integer.parseInt(idParam));
				
				req.setAttribute("user", user);
				getServletContext().getRequestDispatcher("/views/edit.jsp").forward(req, resp);
			}
		}
	}
	
	private int checkAction(HttpServletRequest req)
	{
		if (req.getParameter("Edit") != null)
			return 1;
		
		if (req.getParameter("Delete") != null)
		{
			String idParam = req.getParameter("id");
			
			if (idParam != null)
			{
				User user = new User();
				user.setId(Integer.parseInt(idParam));
				
				Model model = ModelFactory.getModel(ModelType.DB);
				model.delete(user);
			}
			
			return 0;
		}
		
		return 0;
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		Model model = ModelFactory.getModel(ModelType.DB);
		Map<Integer, String> users = model.list();
		req.setAttribute("users", users);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/list.jsp");
		dispatcher.forward(req, resp);
	}
}
