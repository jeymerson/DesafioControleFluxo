package Package;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Contador {
static Scanner terminal = new Scanner(System.in);	
static Scanner terminal2 = new Scanner(System.in);	


		public static void main(String[] args) {
			// iniciando o programa propriamente dito
			iniciacao();
			//Mensagem indicando a finalização do programa
			System.out.println("Fim do programa");

		}
	//Cálculo caso o programa ocorra bem
	static int validacao (int numeroUm, int numeroDois) throws ParametrosInvalidosException{
			if (numeroUm>numeroDois) 
				throw new ParametrosInvalidosException();
			int valor = numeroDois - numeroUm;
			return valor;
		}

		// O programa propriamente dito, abrangido pelas exceções possiveis
	static void iniciacao() {
				
		try {	
			System.out.println("Digite o primeiro parâmetro: ");
			int parametroUm = terminal.nextInt();

			System.out.println("Digite o primeiro parâmetro: ");
			int parametroDois = terminal.nextInt();

			int contador = validacao(parametroUm, parametroDois);
			
			System.out.println("Iniciando a contagem do número 1 até o número " + contador);
			for (int i = 0 ; i < contador;i ++) {
			System.out.println("Imprimindo o número " + (i+1));
			}
			// Caso o usuário deseje continuar testando valores
			continuar();
		
		// Caso o primeiro parâmetro seja maior que o segundo
			} catch (ParametrosInvalidosException e) {
			System.out.println("O segundo parâmetro deve ser maior que o primeiro");
			continuar();
	
		//Em caso de valores não númericos
		} catch (InputMismatchException e) {
			System.out.println("Valores devem ser númericos");
			continuar();		}

	}
	// Verifica o desejo do usuário continuar testando
	static void continuar () {
		int contLoop = 0;

		
		do {
		System.out.println("Gostaria de continuar? S/N");

		String resposta = terminal2.next();
		if (resposta.equals("sim") || resposta.equals("s") || resposta.equals("S") || resposta.equals("Sim") || resposta.equals("SIM")){
			System.out.println("Continuando...");
			iniciacao();
		}
		else if (resposta.equals("não") || resposta.equals("n") || resposta.equals("N") || resposta.equals("Não") || resposta.equals("nao")){
			System.out.println("Terminando o programa...");
		//Caso o usuário tenha problemas com o teclado, o programa não entrarar em loop infinito 	
		} else {
			System.out.println("Parametros inválidos!");
			contLoop ++;
			if (contLoop == 3) {
				System.out.println("Loop infinito detectado, o programa irá terminar agora!");
				break;
			}
		}
	
		} while (true);
	}
}