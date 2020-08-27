package Provadelpoo;

public class ContaCorrente extends Conta {
	
	public ContaCorrente(String numero,Banco banco,double saldo,Cliente titular) {
		super(numero, banco, saldo, titular);
	}
	public void realizasaque(double saque) {
		if((this.saldo - saque)>=0) {
			this.saldo = this.saldo - saque;
		}
	}
	public  void realizadeposito(double deposito) {
		this.saldo = this.saldo + deposito;
	}
}
