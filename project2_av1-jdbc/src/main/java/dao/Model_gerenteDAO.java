package dao;

 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;

import conexaojdbc.SingleConnection;
import model.Model_gerente;
 
//camada de persistência(operações de inse	
public class Model_gerenteDAO {
	
	private Connection connection;

	
	public Model_gerenteDAO() {
		connection = SingleConnection.getConnection();
	}
	//----------------------------------TABELA GERENTE DE PROJETO/ OPERAÇÕES CRUD--------------------------------------------------------------
	public void salvar(Model_gerente model_gerente) {

		try {
			System.out.println(connection);
			String sql = "INSERT INTO gerente_de_projeto(  nome_ger, projeto) VALUES (  ?, ?);";
			PreparedStatement insert = connection.prepareStatement(sql);

			insert.setString(1, model_gerente.getNome_gerente());
			insert.setString(2, model_gerente.getProjeto());
			insert.execute();
			connection.commit();// salva no banco

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public List<Model_gerente> lista() throws Exception {
		ArrayList<Model_gerente> list = new ArrayList<Model_gerente>();

		String sql = "select * from gerente_de_projeto";

		PreparedStatement statementent = connection.prepareStatement(sql);
		ResultSet resultSet = statementent.executeQuery();

		while (resultSet.next()) {

			Model_gerente model_gerente = new Model_gerente();
			model_gerente.setCod_ger(resultSet.getLong("cod_ger"));
			model_gerente.setNome_gerente(resultSet.getString("nome_ger"));
			model_gerente.setProjeto(resultSet.getString("projeto"));

			list.add(model_gerente);

		}

		return list;
	}
	
	public Model_gerente buscar(Long cod_gerente) throws SQLException { // retorna 1 ou mais ou nao
		Model_gerente model_gerente = new Model_gerente();
		 
		String sql = "select * from gerente_de_projeto where cod_ger = " + cod_gerente;

		PreparedStatement statementent = connection.prepareStatement(sql);
		ResultSet resultSet = statementent.executeQuery();

		while (resultSet.next()) {
			model_gerente.setCod_ger(resultSet.getLong("cod_ger"));
			model_gerente.setNome_gerente(resultSet.getString("nome_ger")); 
			model_gerente.setProjeto(resultSet.getString("projeto"));
		}
		return model_gerente;
	}
	
	public void atualizar(Model_gerente gerente) throws SQLException {
		try {

			String sql = "update gerente_de_projeto SET nome_ger=?  WHERE cod_ger =" + gerente.getCod_ger();

			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, gerente.getNome_gerente()); 
			statement.execute(); 
			connection.commit();
			
		} catch (Exception e) {
			connection.rollback();
			e.printStackTrace();
		}
	}
	
	public void deletar(Long cod_ger) {

		try {
			String sql = "delete from gerente_de_projeto where cod_ger = " + cod_ger;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}
	
	  
	
	 
	
}
