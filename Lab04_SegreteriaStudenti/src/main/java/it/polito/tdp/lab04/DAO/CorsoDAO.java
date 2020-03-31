package it.polito.tdp.lab04.DAO;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {

	/*Punto 1 - Popolazione della combobox
	 * Metodo con output generale Ritorna una stringa con tutti i dati Ottengo tutti
	 * i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				Corso n = new Corso(codins,numeroCrediti,nome, periodoDidattico);
				corsi.add(n);

			}

			conn.close();

			
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
		return corsi;
	}

	/*
	 * Input Dato un codice insegnamento, ottengo il corso Quindi setto nell'oggetto
	 * corso i restanti campi sconosciuti
	 */
	public void getCorso(Corso corso) {
		final String sql = "SELECT * FROM corso WHERE Codins= ?";

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, corso.getCodins());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				corso.setCrediti(rs.getInt("crediti"));
				corso.setNome(rs.getString("nome"));
				corso.setPd(rs.getInt("pd"));

			}

			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/*Punto 6 - Iscrizione al corso
	 * Operazione di insert Data una matricola ed il codice insegnamento, iscrivi lo
	 * studente al corso. ritorna true se l'iscrizione e' avvenuta con successo
	 */
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		final String sql = "INSERT IGNORE INTO iscrizione (`matricola`, `codins`) VALUES(?,?)";
		boolean queryStatus = false;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, studente.getMatricola());
			st.setString(2, corso.getCodins());
			int rs = st.executeUpdate();

			if (rs == 1) {
				queryStatus = true;
			} else {
				queryStatus = false;
			}
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return queryStatus;
	}
}
