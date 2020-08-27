package Provadelpoo;

public class ContaPoupanca extends Conta {
	
	private double juros;
	
	public double getJuros() {
		return juros;
	}
	public void setJuros(double juros) {
		this.juros = juros;
	}
	
	public ContaPoupanca(String numero,Banco banco,double saldo,Cliente titular, double juros) {
		super(numero, banco, saldo, titular);
		this.juros = juros;
	}
	
	public void realizasaque(double saque) {
		if((this.saldo - saque)>=0) {
			this.saldo = this.saldo - saque;
		}
	}
	public  void realizadeposito(double deposito) {
		this.saldo = this.saldo + deposito;
	}
	public void renderjuros(double juros) {
		this.saldo = saldo+(juros*saldo/100); 
	}

}