package Provadelpoo;

import java.util.ArrayList;
import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {
	
Scanner teclado = new Scanner(System.in);
		
		int n = 1;
		int controle;
		int opcao;
		String numero;
		String agencia;
		String nomeagencia;
		String nome;
		double saldo;
		String cpf;
		ContaCorrente c;
		ContaPoupanca p;
		Cliente titular;
		Banco banco;
		double juros;
		boolean encontrado=false;
		ArrayList<ContaCorrente> contascorrente= new ArrayList<ContaCorrente>();
		ArrayList<ContaPoupanca> contaspoupanca= new ArrayList<ContaPoupanca>();
		
		double deposito;
		
		while(n != 0) {
			System.out.println("Digite a op��o desejada: ");
			System.out.println("1 - Cadastrar Conta");
			System.out.println("2 - Realizar deposito (procurar pelo CPF do cliente)");
			System.out.println("3 - Render Juros (Poupanca)");
			System.out.println("4 - Consultar dados de cliente (Digite o nome e n�mero da Ag�ncia do cliente) ");
			System.out.println("5 - Alterar o n�mero e nome da ag�ncia (buscar pelo nome do cliente) ");
			System.out.println("0 - Sair");
			
			controle = teclado.nextInt();
			switch(controle) {
			case 1:
				System.out.println(contascorrente.size()+contaspoupanca.size());
				if(contascorrente.size()+contaspoupanca.size()<10) {
					System.out.println("Digite a op��o que quer escolher:");
					System.out.println("1 - ContaCorrente");
					System.out.println("2 - Poupan�a");
					teclado.nextLine();
					opcao = teclado.nextInt();
					if (opcao==1) {
						System.out.println("Digite o nome: ");
						teclado.nextLine();
						nome = teclado.nextLine();
						System.out.println("Digite o n�mero da agencia: ");
						agencia = teclado.nextLine();
						System.out.println("Digite o nome da agencia: ");
						nomeagencia = teclado.nextLine();
						System.out.println("Digite o numero da conta: ");
						numero = teclado.nextLine();
						System.out.println("Digite o saldo: ");
						saldo = teclado.nextDouble();
						System.out.println("Digite o cpf: ");
						teclado.nextLine();
						cpf = teclado.nextLine();
						titular = new Cliente(cpf,nome);
						banco = new Banco(agencia,nomeagencia);
						c = new ContaCorrente(numero,banco,saldo,titular);
						contascorrente.add(c);
					}
					if(opcao==2) {
						System.out.println("Digite o nome: ");
						teclado.nextLine();
						nome = teclado.nextLine();
						System.out.println("Digite o n�mero da agencia: ");
						agencia = teclado.nextLine();
						System.out.println("Digite o nome da agencia: ");
						nomeagencia = teclado.nextLine();
						System.out.println("Digite o numero: : ");
						numero = teclado.nextLine();
						System.out.println("Digite o saldo: ");
						saldo = teclado.nextDouble();
						System.out.println("Digite o CPF: ");
						teclado.nextLine();
						cpf = teclado.nextLine();
						System.out.println("Digite o juros em porcentagem");
						juros = teclado.nextDouble();
						titular = new Cliente(cpf,nome);
						banco = new Banco(agencia,nomeagencia);
						p = new ContaPoupanca(numero,banco,saldo,titular,juros);
						contaspoupanca.add(p);
					}
				}else {
					System.out.println("Limite m�ximo de clientes atingidos!");
				}
				
				break;
			case 2:
				
				
				System.out.println("Digite o CPF do cliente: ");
				teclado.nextLine();
				cpf = teclado.nextLine();
				for(ContaPoupanca p1: contaspoupanca) {
					
					if(p1.getTitular().getCpf().equals(cpf)) {
						System.out.println("Digite o valor a ser depositado: ");
						deposito = teclado.nextDouble();
						p1.realizadeposito(deposito);
						encontrado = true;
						break;
						}
					}
				for(ContaCorrente c1: contascorrente) {
					
					if(c1.getTitular().getCpf().equals(cpf)) {
						System.out.println("Digite o valor a ser depositado: ");
						deposito = teclado.nextDouble();
						c1.realizadeposito(deposito);
						encontrado = true;
						break;
						}
					}
				if(encontrado==false) {
				System.out.println("CPF n�o encontrado em nosso sistema, favor digitar novamente");
				}
				encontrado = false;
				break;
			case 3:
				System.out.println("Digite o CPF do cliente: ");
				teclado.nextLine();
				nome = teclado.nextLine();
				for(ContaPoupanca p1: contaspoupanca) {
					if(p1.getTitular().getCpf().equals(nome)) {
							juros=p1.getJuros();
							p1.renderjuros(juros);
							System.out.println("saldo aumentado em "+juros+"% de juros o saldo agora passa a ser de "+p1.getSaldo());
							encontrado = true;
							break;
						}
				}
				for(ContaCorrente c1: contascorrente) {
					if(c1.getTitular().getCpf().equals(nome)) {
						System.out.println("O Cliente "+c1.getTitular().getNome()+" dono do CPF "+c1.getTitular().getCpf()+" possui uma conta corrente");
						System.out.println("e portanto n�o pode render juros");
						encontrado = true;
						break;
					}
				}
				if(encontrado==false) {
				System.out.println("CPF n�o encontrado em nosso sistema");
				}
				encontrado = false;
				break;
			case 4:
				System.out.println("Digite o n�mero da ag�ncia do cliente: ");
				teclado.nextLine();
				agencia = teclado.nextLine();
				System.out.println("Digite nome da ag�ncia da conta do cliente: ");
				nomeagencia = teclado.nextLine();
				for(ContaCorrente c1: contascorrente) {
					if(c1.getBanco().getAgencia().equals(agencia)&& c1.getBanco().getNomeagencia().equals(nomeagencia)) {
						System.out.println("Seguem os dados do cliente (Nome e CPF):");
						System.out.println(c1.getTitular().getNome());
						System.out.println(c1.getTitular().getCpf());
						encontrado = true;
						break;
					}
				}
				for(ContaPoupanca p1: contaspoupanca) {
					if(p1.getBanco().getAgencia().equals(agencia)&& p1.getBanco().getNomeagencia().equals(nomeagencia)) {
						System.out.println("Seguem os dados do cliente (Nome e CPF):");
						System.out.println(p1.getTitular().getNome());
						System.out.println(p1.getTitular().getCpf());
						encontrado = true;
						break;
					}
				}
				if(encontrado==false) {
				System.out.println("N�o foram encontrados os dados do cliente, favor verifique se os dados foram digitados corretamente e tente novamente");
				}
				encontrado = false;
				break;
			case 5:
				System.out.println("Digite o nome do cliente: ");
				teclado.nextLine();
				nome = teclado.nextLine();
				for(ContaCorrente c1: contascorrente) {
					if(c1.getTitular().getNome().equals(nome)) {
						System.out.println("Digite o novo n�mero da ag�ncia:");
						agencia = teclado.nextLine();
						System.out.println("Digite a nova agencia do cliente (digite o nome da nova ag�ncia):");
						nomeagencia = teclado.nextLine();
						c1.getBanco().setAgencia(agencia);
						c1.getBanco().setNomeagencia(nomeagencia);
						encontrado = true;
						break;
					}
				}
				for(ContaPoupanca p1: contaspoupanca) {
					if(p1.getTitular().getNome().equals(nome)) {
						System.out.println("Digite o novo n�mero da ag�ncia:");
						agencia = teclado.nextLine();
						System.out.println("Digite a nova agencia do cliente (digite o nome da nova ag�ncia):");
						nomeagencia = teclado.nextLine();
						p1.getBanco().setAgencia(agencia);
						p1.getBanco().setNomeagencia(nomeagencia);
						encontrado = true;
						break;
						
					}
				}
				if(encontrado==false) {
				System.out.println("Cliente n�o encontrado, favor verifique se foi digitado corretamente e tente novamente");
				}
				encontrado = false;
				break;
			case 0:
				n = 0;
				break;
			
			}
			
		}
		
		teclado.close();
	}


	}
