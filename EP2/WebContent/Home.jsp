<%@ page import ="java.util.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tarefas Insper</title>
</head>
<body>
<%@ page import ="br.insper.edu.dao.*" %>
<%@ page import ="br.insper.edu.controller.*" %>


    
	<form method='post'>
		Nova Tarefa: <input type='text' name='descricao'>
		<input type='submit' value='Submit'>
	</form>
	<table>	
		<% DAO dao = new DAO();
		List<Tarefas> tarefas = dao.getLista();
		for (Tarefas tarefa : tarefas) { %>
		<%System.out.print(tarefa); %>
		<tr>
			<td><%=tarefa.getId()%></td>
			<td><%=tarefa.getDescricao()%></td>
			<td><input type='submit' value='Atualiza'></td>
			<td><input type='submit' value='Remove'></td>
		</tr>
	<% } %>
	</table>
</body>
</html>