package project2_av1_jdbc.project2_av1_jdbc;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

 
import dao.Model_gerenteDAO;
import dao.Model_programadorDAO;
import model.Model_gerente;
import model.Model_programador;
 
public class AppTest {
	//----------------------------------TABELA GERENTE DE PROJETO/ OPERAÇÕES CRUD--------------------------------------------------------------
	 
	@Test //CADASTRO DO GERENTE
	 public void initBanco() { 
		  Model_gerenteDAO model_gerenteDAO = new Model_gerenteDAO();
		  Model_gerente model_gerente = new Model_gerente();
		   //Input: Entre com nome e projeto para cadastrar o gerente.
		 
		  model_gerente.setNome_gerente("CARLOS"); 
		  model_gerente.setProjeto("JAVASCRIPT FRONTED");  
		  model_gerenteDAO.salvar(model_gerente);
		 
		 }
	 
	 @Test // LISTAR TODOS OS GERENTE(NOME,CODIGO DO GERENTE , PROJETO)
	 public void initListar() {
		 Model_gerenteDAO gerenteDAO = new Model_gerenteDAO(); 
		 try {
			List<Model_gerente> list = gerenteDAO.lista();
			for(Model_gerente model_gerente : list) {
				System.out.printf("%s: %d \n %s: %s \n %s: %s\n",
						" CODIGO DO GERENTE",model_gerente.getCod_ger(),
						"NOME DO GERENTE",model_gerente.getNome_gerente(),
						"NOME DO PROJETO",model_gerente.getProjeto());
				System.out.println("---------------------------------------------");
				 
				 
			 }
		} catch (Exception e) { 
			e.printStackTrace();
		}
	 }
	 
	 @Test	// PESQUISAR GERENTE 
	 public void initBuscar()   { 
		  Model_gerenteDAO dao = new Model_gerenteDAO();
		  
		  try {
			  //Input: Entre com cod_ger para buscar!
			   Model_gerente model_gerente = dao.buscar(1L);
			  System.out.println(model_gerente);
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	 }
	 //corrigir!
		@Test // EDITAR CADASTRO DO GERENTE
		public void initAtualizar() { 
			try { 
				Model_gerenteDAO dao = new Model_gerenteDAO();
				
				// Input:: Entre com cod_ger para buscar!
				 
				Model_gerente model_gerente  = dao.buscar(1L);
				//Input: Entre com o dado que voce deseja alterar! 
				System.out.println(model_gerente.getNome_gerente());
				model_gerente.setNome_gerente("xxx"); 
				dao.atualizar(model_gerente);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 
		@Test // EXCLUIR CADASTRO DO GERENTE
		public void initDeletar() {
			try {

				Model_gerenteDAO dao = new Model_gerenteDAO();
				// Input: entre cod_ger do gerente para deletar!
				dao.deletar(1L);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//----------------------------------TABELA PROGRAMADOR/ OPERAÇÕES CRUD--------------------------------------------------------------
		@Test //CADASTRO DO PROGRAMADOR
		 public void initBancoprogramador() { 
			  Model_programadorDAO dao = new Model_programadorDAO();
			  Model_programador model_programador =  new Model_programador();
			   //Input: Entre com nome e projeto para cadastrar o gerente.
			  model_programador.setCod_ger(6L);
			  model_programador.setCod_prog(66L); 
			  model_programador.setNome("MATHEUS");
			  model_programador.setLinguagem("JAVA");
			  model_programador.setNivel("Jr");
			  dao.salvar(model_programador); 
			 }
		
		@Test // LISTAR TODOS OS DADOS DE PROGRAMADORES E ID DO GERENTE  
		 public void initListarprogramador() {
			 Model_programadorDAO dao = new Model_programadorDAO();
			 try {
				List<Model_programador> list = dao.listarProgramador();
				for(Model_programador model_programador : list) {
					System.out.printf("%s: %d \n %s: %d \n %s: %s \n %s: %s \n %s: %s \n", 
							"CODIGO DO GERENTE RESPONSAVEL",model_programador.getCod_ger(),
							"CODIGO DO PROGRAMADOR",model_programador.getCod_prog(),
							"NOME DO PROGRAMADOR",model_programador.getNome(),
							"LINGUAGEM",model_programador.getLinguagem(),
							"NIVEL",model_programador.getNivel());
					System.out.println("---------------------------------------------");
					 
				 }
			} catch (Exception e) { 
				e.printStackTrace();
			}
		 }
		
		 @Test	// PESQUISAR PROGRAMADOR
		 public void initBuscarprogramador()   { 
			 Model_programadorDAO dao = new Model_programadorDAO();
			  
			  try {
				  //Input: Entre com cod_prog para buscar!
				   Model_programador model_programador = dao.buscarprogramador(23L);
				  System.out.println(model_programador);
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		 }
		 
		 @Test // EDITAR CADASTRO DO PROGRAMADOR
			public void initAtualizarprogramador() { 
				try { 
					Model_programadorDAO dao = new Model_programadorDAO();
					
					// Input:: Entre com cod_ger para buscar!
					 
					Model_programador  model_programador  = dao.buscarprogramador(23L);
					//Input: Entre com o dado que voce deseja alterar!  
					 
					model_programador.setNivel("JR");
					dao.atualizar(model_programador);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		 //bbug na entrada e parametro do método jUnit
		 
		 //@Test // EXCLUIR CADASTRO DO PROGRAMADOR
//			public void initDeletarprogramador(Long cod_ger) {
//				try {
//
//					Model_programadorDAO dao = new Model_programadorDAO();
//					// Input: entre cod_ger do gerente para deletar!
//					dao.deletarprogramador(cod_ger);
//
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
		 
		 @Test
		 public void main() {
			 try (Scanner input = new Scanner(System.in)) {
				 int num2;
				 int sessao = 0;
				do { 
					 sessao++;
					 System.out.println("*sessao: "+sessao);
					 System.out.println("Digite 1 - Listar programadores");
					 System.out.println("Digite 2 - Listar gerentes");
					 System.out.println("Digite 3 - Excluir programador");
					  
					 int num = input.nextInt();
					 
					 switch(num) {
					 	case 1: initListarprogramador();
					 	break;
					 	
					 	case 2: initListar();
					 	break; 
					 } 
					 System.out.println("Para sair digite 9999 ou digite qualquer coisa para recomeçar!");
					 num2 = input.nextInt();
				 }while(num2 != 9999);
			}
		 }
		 
		 
		 
		  
	 
}
