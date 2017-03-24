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
		connection = DriverManager.getConnection("jdbc:mysql://localhost/ep2", "root", "jp123456");
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
		try {
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
			
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tarefas;
	}
	
	
}
