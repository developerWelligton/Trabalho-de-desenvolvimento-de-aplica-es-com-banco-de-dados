package model;

public class Model_programador {
	private Long cod_prog;
	private Long cod_ger;
	private String nome;
	private String linguagem;
	private String nivel;
	
	public Long getCod_prog() {
		return cod_prog;
	}
	public void setCod_prog(Long cod_prog) {
		this.cod_prog = cod_prog;
	}
	public Long getCod_ger() {
		return cod_ger;
	}
	public void setCod_ger(Long cod_ger) {
		this.cod_ger = cod_ger;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLinguagem() {
		return linguagem;
	}
	public void setLinguagem(String linguagem) {
		this.linguagem = linguagem;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	
	@Override
	public String toString() {
		return "Model_programador [cod_prog=" + cod_prog + ", cod_ger=" + cod_ger + ", nome=" + nome + ", linguagem="
				+ linguagem + ", nivel=" + nivel + "]";
	}
	
	
	
}
