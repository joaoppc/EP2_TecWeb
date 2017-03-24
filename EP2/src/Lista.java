import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class Lista extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response){
		
		DAO dao = new DAO();
		List<Tarefas> tarefas = dao.getLista();
		
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println("<html><body>");
			out.println("<form method='post'>");
			out.println("Nova Tarefa: <input type='text'>");
			out.println("<input type='submit' value='Submit'>");
			out.println("</form>");
			for (Tarefas tarefa:tarefas) {
				out.println("<tr><td>"+tarefa.getId()+"</td>");
				out.println("<td>"+tarefa.getDescricao()+"</td></tr>");
				
			}
			out.println("</html></body>");
			
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
}
