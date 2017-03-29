import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class Lista extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		DAO dao = new DAO();
		List<Tarefas> tarefas = dao.getLista();
		
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println("<html><body>");
			out.println("<form method='post'>");
			out.println("Nova Tarefa: <input type='text' name='descricao'>");
			out.println("<input type='submit' value='Submit'>");
			out.println("</form>");
			out.println("</html></body>");
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
			
		@Override
		protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					
			DAO dao = new DAO();
			List<Tarefas> tarefas = dao.getLista();
			
			Tarefas nova_tarefa = new Tarefas();
			nova_tarefa.setDescricao(request.getParameter("descricao"));
			
			dao.adiciona(nova_tarefa);
			
		
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			for (Tarefas tarefa:tarefas) {
				out.println("<tr><td>"+tarefa.getId()+"</td>");
				out.println("<td>"+tarefa.getDescricao()+"</td></tr>");
				
			}
			out.println("</html></body>");
	}
}