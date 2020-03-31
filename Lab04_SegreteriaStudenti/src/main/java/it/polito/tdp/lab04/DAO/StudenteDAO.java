package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {

	// Punto 2- Completamento automatico
	public Studente completaDatiStudente(int matricola) {

		final String sql = "SELECT * FROM studente WHERE matricola = ?";
		Studente datistudente = null;
		try {

			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String cds = rs.getString("CDS");
				datistudente = new Studente(matricola, nome, cognome, cds);

			}

			conn.close();

			return datistudente;

		} catch (SQLException e) {
			throw new RuntimeException("Errore Db", e);
		}
	}

	// Punto 3- Studenti iscritti ad un corso
	// ritorna errore se nessun corso è stato selezionato
	public List<Studente> DatiStudenteCorso(String nomeCorso) {
		final String sql = "SELECT studente.matricola, studente.nome, studente.cognome, studente.CDS FROM corso, iscrizione, studente \r\n"
				+ "WHERE corso.codins = iscrizione.codins AND iscrizione.matricola=studente.matricola \r\n"
				+ "AND corso.nome = ?";

		List<Studente> DatiStudenteCorso = new LinkedList<Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, nomeCorso);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int matricola = rs.getInt("studente.matricola");
				String nomeStudente = rs.getString("studente.nome");
				String cognomeStudente = rs.getString("studente.cognome");
				String CDSstudente = rs.getString("studente.CDS");

				Studente n = new Studente(matricola, cognomeStudente, nomeStudente, CDSstudente);
				DatiStudenteCorso.add(n);

			}

			conn.close();

			return DatiStudenteCorso;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}

	// Punto 4 - Data una matricola, trova i suoi corsi
	public List<Corso> CorsiSeguitiDaStudente(Studente studente) {
		final String sql = "SELECT corso.codins, corso.crediti, corso.nome, corso.pd FROM corso, iscrizione \r\n"
				+ "WHERE corso.codins=iscrizione.codins AND iscrizione.matricola=?";

		List<Corso> CorsiSeguiti = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			int matricola = studente.getMatricola();
			st.setInt(1, matricola);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String codins = rs.getString("corso.codins");
				int crediti = rs.getInt("corso.crediti");
				String NomeCorso = rs.getString("corso.nome");
				int pd = rs.getInt("corso.pd");

				Corso n = new Corso(codins, crediti, NomeCorso, pd);
				CorsiSeguiti.add(n);

			}

			conn.close();

			return CorsiSeguiti;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}

	/*
	 * Punto 5 - Controllo iscrizione al corso
	 *
	 */
	public boolean isStudenteinCorso(Studente studente, Corso corso) {
		final String sql = "SELECT * FROM iscrizione WHERE matricola= ? AND codins= ? ";
		boolean iscritto = false;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, studente.getMatricola());
			st.setString(2, corso.getCodins());
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				iscritto = true;
			} else {
				iscritto = false;
			}
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return iscritto;
	}

}
