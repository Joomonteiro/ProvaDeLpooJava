package Provadelpoo;

public class Banco {
	
	private String agencia;
	private String nomeagencia;
	
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getNomeagencia() {
		return nomeagencia;
	}
	public void setNomeagencia(String nomeagencia) {
		this.nomeagencia = nomeagencia;
	}
	public Banco(String agencia, String nomeagencia) {
		this.agencia = agencia;
		this.nomeagencia = nomeagencia;
	}

}
