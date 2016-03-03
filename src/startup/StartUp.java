package StartUp;


import ui.ConsoleApplicatie;
import domein.DomeinController;

public class StartUp {
	public static void main(String[] args){
		DomeinController dc = new DomeinController();
		ConsoleApplicatie ca = new ConsoleApplicatie(dc);
		ca.start();	
	}
}

