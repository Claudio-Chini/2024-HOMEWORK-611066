package it.uniroma3.diadia;
import java.util.Scanner;

public class IOConsole implements IO{
	private static int numeroIstanziamenti = 0;
	Scanner scannerDiLinee;
	
	public IOConsole(Scanner scanner) {
		this.scannerDiLinee = scanner;
		numeroIstanziamenti++;
		this.mostraMessaggio("[Classe " + getClass().getName() + " - Numero istanziamenti:" + numeroIstanziamenti + "]");
	}
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	public String leggiRiga() {
		String riga = scannerDiLinee.nextLine();
		return riga;
	}

}
