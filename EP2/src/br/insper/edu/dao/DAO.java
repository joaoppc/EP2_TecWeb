package br.insper.edu.dao;
import br.insper.edu.controller.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class DAO {
	private Connection connection = null;
	public DAO() {
	 try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/Tarefa2", "root", "jp123456");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	}
	
	public void adiciona(Tarefas tarefa){
		String sql = "INSERT into Tarefas"+"(descricao) values(?)";
		PreparedStatement stmt;
		System.out.println("fase 1");
		try {
			System.out.println("fase 2");
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, tarefa.getDescricao());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Tarefas> getLista(){
		List<Tarefas> tarefas = new ArrayList<Tarefas>();
		
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement("SELECT * FROM Tarefas");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Tarefas tarefa = new Tarefas();
				tarefa.setId(rs.getInt("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefas.add(tarefa);
			}
			System.out.println(tarefas);
			
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tarefas;
	}
	public void update(Tarefas tarefa){
		String sql = "UPDATE Tarefas SET" + "descricao=? WHERE id=?";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, tarefa.getDescricao());
			stmt.setInt(2, tarefa.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void remove(int Id){
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement("DELETE FROM Tarefas WHERE Id=?");
			stmt.setLong(1, Id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
