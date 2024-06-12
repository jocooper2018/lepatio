package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lepatio.Genre;
import modele.*;



public class Main extends Application {
	private FenListeSpec fListe;
	static private FenCreerGenre fCreer;
	static private ListView<Genre> ctrlListe;

	FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/lepatio/FenAffichageListeGenre.fxml"));

	@Override
	public void start(Stage primaryStage) throws Exception {

		this.fListe = new FenListeSpec();
		Main.fCreer = new FenCreerGenre();

		Main.fCreer.initModality(Modality.APPLICATION_MODAL);
		this.fListe.show();
	}

	static public void fermerAppli() {
        System.exit(0);
	}
	static public void fermerPopup() {
        Main.fCreer.close();
	}

	static public void ouvrirCreerGenre() {
		Main.fCreer.show();
	}


	public static void main(String[] args){
		Application.launch(args);
	}

	
}
