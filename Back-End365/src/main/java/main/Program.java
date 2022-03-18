package main;

import java.util.Scanner;

import services.ClienteServices;
import services.DestinoServices;
import services.JoinTablesServices;
import services.PromocaoServices;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int opcao;
		boolean repetir = true;
		ClienteServices clienteServices = new ClienteServices();
		DestinoServices destinoServices = new DestinoServices();
		PromocaoServices promocaoServices = new PromocaoServices();
		JoinTablesServices joinTablesServices = new JoinTablesServices();
		
		
		do {
			System.out.println("");
			System.out.println("   ------------------------- Seja muito Bem-vindo --------------------------- ");
			System.out.println("");
			System.out.println("	 Olá somos a melhor empresa de passagem área 365 contigo hoje e sempre");
			System.out.println("");
			System.out.println("");
			System.out.println("           1º Escolha um número de sua preferência uma das opções abaixo. ");
			System.out.println("");
			System.out.println("---------> (0) SAIR");
			System.out.println("---------> (1) CRUD CLIENTES");
			System.out.println("---------> (2) CRUD DESTINOS");
			System.out.println("---------> (3) CRUD PROMOÇÕES");
			System.out.println("---------> (4) MOSTRAR DESTINOS E PROMOÇÕES");
			System.out.println("---------> (5) MOSTRAR AOS CLIENTES SEUS DESTINOS");
			System.out.println("");
			opcao = sc.nextInt();
			
			switch (opcao) {
			case 0:
				System.out.println("Volte sempre e obrigado por utlizar nossos serviços");
				repetir = false;
				break;
			case 1:
				clienteServices.menu();
				break;
			case 2:
				destinoServices.menu();
				break;
			case 3:
				promocaoServices.menu();
				break;
			case 4:
				joinTablesServices.imprimirDestinoOuPromocao();
				break;
			case 5:
				joinTablesServices.imprimeViajantes();
				break;
			default:
				System.out.println("Opção inválida, digite uma opção de 0 a 5.");
				break;
			}
		} while (repetir);
		
		
		
		
		sc.close();
	}

}
