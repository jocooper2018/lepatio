package modele;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lepatio.Genre;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


public class FenListeSpec extends Stage {
	
	public FenListeSpec() throws IOException {
		this.setTitle("Liste des Spectacle");
		this.setResizable(false);
		Scene laScene = new Scene(creerSceneGraph());
		this.setScene(laScene);
	}

	private Pane creerSceneGraph() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/lepatio/FenAffichageListeGenre.fxml"));
        Pane root = loader.load();
        loader.getController();
        return root;
	}
}

