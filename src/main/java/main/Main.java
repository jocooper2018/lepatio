package main;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modele.FenCreerGenre;
import modele.FenListeSpec;


public class Main extends Application {
	private FenListeSpec fListe;
	static private FenCreerGenre fCreer;


	@Override
	public void start(Stage primaryStage) throws Exception {

		this.fListe = new FenListeSpec();
		this.fCreer = new FenCreerGenre();
		this.fListe.show();
	}

	static public void fermerAppli() {
        System.exit(0);
	}
	static public void fermerPopup() {
        fCreer.close();
	}

	static public void ouvrirCreerGenre() {
		fCreer.show();
	}

	public static void main(String[] args){
		Application.launch(args);
	}
	
}
