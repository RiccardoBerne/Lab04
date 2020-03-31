package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	private CorsoDAO corsodao;
	private StudenteDAO studentedao;

	/**
	 * @param corsodao
	 * @param studentedao
	 */
	public Model() {
		corsodao = new CorsoDAO();
		studentedao = new StudenteDAO();
	}

	// Metodi di CORSODAO
	// Punto 1 - Popolazione ComboBOX
	public List<Corso> getTuttiICorsi() {

		return corsodao.getTuttiICorsi();
	}

	// Punto 6
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		return corsodao.inscriviStudenteACorso(studente, corso);
	}

	// Metodi di StudentiDao
	// Punto 2 - Autocompletamento
	public Studente completaDatiStudente(int matricola) {
		return studentedao.completaDatiStudente(matricola);
	}

	// Punto 3 - Studenti iscritti ad un corso
	public List<Studente> DatiStudenteCorso(String nomeCorso) {
		return studentedao.DatiStudenteCorso(nomeCorso);
	}
	
	//Punto 5 - Verificare se studente iscritto ad un corso
	public boolean isStudenteinCorso(Studente studente, Corso corso) {
		return studentedao.isStudenteinCorso(studente, corso);
	}
	
	//Punto 4 - Corsi Frequentati da uno studente
	public List<Corso> CorsiSeguitiDaStudente(Studente studente){
		return studentedao.CorsiSeguitiDaStudente(studente);
	}

}
