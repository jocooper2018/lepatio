package modele;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


public class FenAffichageStatistique extends Stage {
	
	public FenAffichageStatistique() throws IOException {
		this.setTitle("Affichage des statistiques");
		this.setResizable(false);
		Scene laScene = new Scene(creerSceneGraph());
		this.setScene(laScene);
	}

	private Pane creerSceneGraph() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/lepatio/FenAffichageStatistiques.fxml"));
        Pane root = loader.load();
        return root;
	}

}

