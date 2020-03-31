/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.lab04;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	private Model model;
	List<Corso> corsi;

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="ChoiceBox"
	private ComboBox<Corso> ChoiceBox; // Value injected by FXMLLoader

	@FXML // fx:id="btnCercaIscritti"
	private Button btnCercaIscritti; // Value injected by FXMLLoader

	@FXML // fx:id="txtMatricola"
	private TextField txtMatricola; // Value injected by FXMLLoader

	@FXML // fx:id="txtNomeStudente"
	private TextField txtNomeStudente; // Value injected by FXMLLoader

	@FXML // fx:id="txtCognomeStudente"
	private TextField txtCognomeStudente; // Value injected by FXMLLoader

	@FXML // fx:id="btnCercaCorsi"
	private Button btnCercaCorsi; // Value injected by FXMLLoader

	@FXML // fx:id="btnIscrivi"
	private Button btnIscrivi; // Value injected by FXMLLoader

	@FXML // fx:id="txtOutput"
	private TextArea txtOutput; // Value injected by FXMLLoader

	@FXML // fx:id="btnReset"
	private Button btnReset; // Value injected by FXMLLoader

	@FXML
	private Button btnCompleta;

	public void setModel(Model model) {

		this.model = model;
		setComboItems();
	}

	private void setComboItems() {

		corsi = model.getTuttiICorsi();

		Collections.sort(corsi);
		ChoiceBox.getItems().addAll(corsi);
	}
    
	//Punto 2 - Autocompletamento
	@FXML 
    void doCompletamento(ActionEvent event) {
		int matricola = Integer.parseInt(txtMatricola.getText());
		Studente studente = model.completaDatiStudente(matricola);
		//Check errore
		System.out.println(studente + "\n");
		System.out.println("\n");
		
	
    }
	
	@FXML
	void doCercaCorsi(ActionEvent event) {

	}

	@FXML
	void doCercaIscritti(ActionEvent event) {

	}

	@FXML
	void doIScrivi(ActionEvent event) {

	}

	@FXML
	void doMatricolaStudente(ActionEvent event) {

	}

	@FXML
	void doReset(ActionEvent event) {

	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert ChoiceBox != null : "fx:id=\"ChoiceBox\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnCercaIscritti != null : "fx:id=\"btnCercaIscritti\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnCompleta != null : "fx:id=\"btnCompleta\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtNomeStudente != null : "fx:id=\"txtNomeStudente\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtCognomeStudente != null : "fx:id=\"txtCognomeStudente\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

	}

}