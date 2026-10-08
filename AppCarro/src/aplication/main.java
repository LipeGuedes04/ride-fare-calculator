package aplication;

import java.util.Scanner;

public class main {
	public static void main(String[] args) {
	
	double distancia;
	int horario;
	int opcaoVeiculo;
		
		
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Qual classe voce quer escolher para sua corrida? \n1- Classe Econômica \n2- Classe Confort \n3- Classe black");
	opcaoVeiculo = sc.nextInt();
	sc.nextLine();
	System.out.println("Qual será o seu destino em KM?");
	distancia = sc.nextDouble();
	System.out.println("Que horas será o embarque? ");
	horario = sc.nextInt();
	sc.nextLine();
	
	
	double addNoturno = 0;
	int addDistancia = 15;
	
	switch (opcaoVeiculo) {
		case 1:
			System.out.printf("Você escolheu a classe Econômica as %d horas", horario);
			double ValorEconomico = 5 + (distancia * 2);	
			if (horario >= 22 || horario <= 5) {
				addNoturno = ValorEconomico * 0.25;	
				ValorEconomico += addNoturno;		
				if(distancia > 30) {
					ValorEconomico += addDistancia;
				}
				System.out.printf("\nTeve um adicional noturno de %.2f reais" , addNoturno);
				System.out.printf("\nValor total da corrida: %.2f reais" , ValorEconomico);
			}else {
				if(distancia > 30) {
					ValorEconomico += addDistancia;
				}
				System.out.printf("\nValor Total: %.2f reais", ValorEconomico);
			}
			break;	
		case 2:
			System.out.printf("Você escolheu a classe Confort as %d horas", horario);
			double ValorConfort = 7.50 + (distancia * 3);	
			if (horario >= 22 || horario <= 5) {
				addNoturno = ValorConfort * 0.25;	
				ValorConfort += addNoturno;		
				if(distancia > 30) {
					ValorConfort += addDistancia;
				}
				System.out.printf("\nTeve um adicional noturno de %.2f reais" , addNoturno);
				System.out.printf("\nValor total da corrida: %.2f reais" , ValorConfort);
			}else {
				if(distancia > 30) {
					ValorConfort += addDistancia;
				}
				System.out.printf("\nValor Total: %.2f reais", ValorConfort);
			}
			break;
		case 3:
			System.out.printf("Você escolheu a classe Black as %d horas", horario);
			double ValorBlack = 10 + (distancia * 4.50);	
			if (horario >= 22 || horario <= 5) {
				addNoturno = ValorBlack * 0.25;	
				ValorBlack += addNoturno;		
				if(distancia > 30) {
					ValorBlack += addDistancia;
				}
				System.out.printf("\nTeve um adicional noturno de %.2f reais" , addNoturno);
				System.out.printf("\nValor total da corrida: %.2f reais" , ValorBlack);
			}else {
				if(distancia > 30) {
					ValorBlack += addDistancia;
				}
				System.out.printf("\nValor Total: %.2f reais", ValorBlack);
			}
			break;
		default:
			System.out.println("Escolha alguma classe de carros");
			break;
	}
	
	sc.close();
	
	
	}
}
