package main;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modele.FenListeSpec;


public class Main extends Application {
	private FenListeSpec fListe;


	@Override
	public void start(Stage primaryStage) throws Exception {
		this.fListe = new FenListeSpec();
		this.fListe.show();
	}

	static public void fermerAppli() {
        System.exit(0);
	}

	public static void main(String[] args){
		Application.launch(args);
	}
	
}
