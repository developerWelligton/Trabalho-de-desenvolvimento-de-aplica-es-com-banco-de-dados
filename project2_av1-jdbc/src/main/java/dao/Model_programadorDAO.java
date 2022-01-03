package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
 
import model.Model_programador;

public class Model_programadorDAO {
private Connection connection;

	
	public Model_programadorDAO() {
		connection = SingleConnection.getConnection();
	}
	//----------------------------------TABELA GERENTE DE PROJETO/ OPERAÇÕES CRUD--------------------------------------------------------------
	//CADASTRO DO PROGRAMADOR
	public void salvar(Model_programador model_programador) {

		try {
			String sql = "INSERT INTO public.programador( cod_prog, cod_ger, nome, linguagem, nivel) VALUES (?, ?, ?, ?, ?);";
			PreparedStatement insert = connection.prepareStatement(sql);

			insert.setLong(1, model_programador.getCod_prog());
			insert.setLong(2, model_programador.getCod_ger());
			insert.setString(3, model_programador.getNome());
			insert.setString(4, model_programador.getLinguagem());
			insert.setString(5, model_programador.getNivel());

			insert.execute();
			connection.commit();// salva no banco

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	// LISTAR TODOS OS DADOS DE PROGRAMADORES E ID DO GERENTE  
	public List<Model_programador> listarProgramador() throws SQLException {
		ArrayList<Model_programador> list = new ArrayList<Model_programador>();

		String sql = "select * from programador";

		PreparedStatement statementent = connection.prepareStatement(sql);
		ResultSet resultSet = statementent.executeQuery();

		while (resultSet.next()) {

			Model_programador model_programador = new Model_programador();
			model_programador.setCod_prog(resultSet.getLong("cod_prog"));
			model_programador.setCod_ger(resultSet.getLong("cod_ger"));
			model_programador.setNome(resultSet.getString("nome"));
			model_programador.setLinguagem(resultSet.getString("linguagem"));
			model_programador.setNivel(resultSet.getString("nivel"));

			list.add(model_programador);

		}

		return list;
	}
	
	// PESQUISAR PROGRAMADOR
	public Model_programador buscarprogramador(long cod_programador) throws SQLException {

		Model_programador model_programador = new Model_programador();

		String sql = "select * from programador where cod_prog = " + cod_programador;

		PreparedStatement statementent = connection.prepareStatement(sql);
		ResultSet resultSet = statementent.executeQuery();

		while (resultSet.next()) {
			model_programador.setCod_prog(resultSet.getLong("cod_prog"));
			model_programador.setCod_ger(resultSet.getLong("cod_ger"));
			model_programador.setNome(resultSet.getString("nome"));
			model_programador.setLinguagem(resultSet.getString("linguagem"));
			model_programador.setNivel(resultSet.getString("nivel"));

		}
		return model_programador;

	}
	
	// EDITAR CADASTRO DO PROGRAMADOR
	public void atualizar(Model_programador model_programador) throws SQLException {
		try {

			String sql = "UPDATE programador SET  nome=?, linguagem=?, nivel=? WHERE cod_prog="
					+ model_programador.getCod_prog();

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, model_programador.getNome());
			statement.setString(2, model_programador.getLinguagem());
			statement.setString(3, model_programador.getNivel());
			statement.execute();
			connection.commit();

		} catch (Exception e) {
			connection.rollback();
			e.printStackTrace();
		}
	}
	
	// EXCLUIR CADASTRO DO GERENTE
	public void deletarprogramador(Long cod_prog) {

		try {
			String sql = "delete from programador where cod_prog = " + cod_prog;
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
