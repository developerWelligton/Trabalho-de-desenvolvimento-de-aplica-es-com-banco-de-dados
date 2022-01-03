package model;

public class Model_gerente {
	private Long cod_ger;
	private String nome_gerente; 
	private String projeto;
	
	public Long getCod_ger() {
		return cod_ger;
	}
	public void setCod_ger(Long cod_ger) {
		this.cod_ger = cod_ger;
	}
	public String getNome_gerente() {
		return nome_gerente;
	}
	public void setNome_gerente(String nome_gerente) {
		this.nome_gerente = nome_gerente;
	}
	public String getProjeto() {
		return projeto;
	}
	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}
	
	@Override
	public String toString() {
		return "Model_gerente [cod_ger=" + cod_ger + ", nome_gerente=" + nome_gerente + ", projeto=" + projeto + "]";
	}
	
 
	
	
}
