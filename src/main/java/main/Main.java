package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lepatio.Genre;
import modele.*;



public class Main extends Application {
	private FenListeSpec fListe;
	static private FenCreerGenre fCreer;
	static private CtrlFenListeSpec ctrlListe;

	FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/lepatio/FenAffichageListeGenre.fxml"));

	@Override
	public void start(Stage primaryStage) throws Exception {

		this.fListe = new FenListeSpec();
		this.fCreer = new FenCreerGenre();

		ctrlListe = loader.getController();

		fCreer.initModality(Modality.APPLICATION_MODAL);
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

	static public void creerGenre(String nomGenre){
		Genre genre = new Genre(nomGenre);
		ctrlListe.addGenreToListView(genre);
	}

	public static void main(String[] args){
		Application.launch(args);
	}

	
}
