package cinema;

import java.util.Scanner;

public class Main {

	private static void menu (Cinema cinema) {
		
		System.out.println("+------------------------------+");
		System.out.printf("| Cinema: %-20s |\n", cinema.getNome());
		System.out.println("+------------------------------+");
		System.out.println("| [1] Vender ingresso          |");
		System.out.println("| [2] Ver saldo                |");
		System.out.println("| [3] Sair                     |");
		System.out.println("+------------------------------+");
		System.out.print("  Opção: ");
	}
	
	public static void saldo (Cinema cinema) {
		
		int qtdeMeia=0, qtdeInteira=0;
		for(Ingresso ingresso : cinema.getIngressosVendidos()) {
			if(ingresso instanceof Meia) {
				qtdeMeia++;
			}
			else {
				if(ingresso instanceof Inteira) {
					qtdeInteira++;
				}
			}
		}
		
		System.out.println("\n+------------------------------+");
		System.out.printf("| Cinema: %-20s |\n", cinema.getNome());
		System.out.println("+------------------------------+");
		System.out.printf("| Qtde de ingressos: [%02d]      |\n", cinema.getQtdIngressos());
		System.out.println("| Vendidos/Total (R$):         |");
		System.out.printf("| Meia:   [%02d] = R$ %-10.1f |\n", qtdeMeia, qtdeMeia*10.0);
		System.out.printf("| Normal: [%02d] = R$ %-10.1f |\n", qtdeInteira, qtdeInteira*20.0);
		System.out.println("+------------------------------+");
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		Cinema c = new Cinema ("Jupiter");
		int opcao=10;
		
		while(opcao!=0) {
			menu(c);
			opcao=sc.nextInt();
			
			switch(opcao) {
			case 1:
				if(c.getQtdIngressos()>0) {
					System.out.println("  Meia [M] ou normal [N]?");
					String tipoIngresso = sc.next();
					c.venderIngresso(tipoIngresso);
					System.out.println();
				}
				else {
					System.out.println("  INGRESSOS ESGOTADOS!");
					System.out.println();
				}
				break;
			case 2:
				saldo(c);
				break;
			case 3:
				opcao=0;
				break;
			}
			System.out.println();
		}
		
	}

}
