package modele;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import main.Main;

public class CtrlFenStatistique {

    @FXML
    private Button bnRetour;

    @FXML
    private ChoiceBox<?> choiceBox;

    @FXML
    private RadioButton rdButtonNomArt;

    @FXML
    private RadioButton rdButtonNomSpec;

    @FXML
    private TableColumn<?, ?> tableColonne1;

    @FXML
    private TableColumn<?, ?> tableColonne2;

    @FXML
    private TableColumn<?, ?> tableColonne3;

    @FXML
    private TableColumn<?, ?> tableColonne4;

    @FXML
    private TableView<?> tableau;

    @FXML
    private TextField txtCASaison;

    @FXML
    private TextField txtNbVendu;

    @FXML
    void fermerFenetre(ActionEvent event) { 
        Main.fermerStat();
    }

}
