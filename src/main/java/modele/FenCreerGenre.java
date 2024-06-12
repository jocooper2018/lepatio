package modele;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


public class FenCreerGenre extends Stage {
	
	public FenCreerGenre() throws IOException {
		this.setTitle("Création d'un genre");
		this.setResizable(false);
		Scene laScene = new Scene(creerSceneGraph());
		this.setScene(laScene);
	}

	private Pane creerSceneGraph() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/lepatio/FenPopupCreerGenre.fxml"));
        Pane root = loader.load();
        loader.getController();
        return root;
	}
}

