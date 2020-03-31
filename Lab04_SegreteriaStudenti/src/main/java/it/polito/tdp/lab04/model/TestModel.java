package it.polito.tdp.lab04.model;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();

		// Punto 1 - Popolazione ComboBOX
		StringBuilder sb = new StringBuilder();
		for (Corso corso : model.getTuttiICorsi()) {
			sb.append(String.format("%-8s ", corso.getCodins()));
			sb.append(String.format("%-2s ", corso.getCrediti()));
			sb.append(String.format("%-50s ", corso.getNome()));
			sb.append(String.format("%-4s ", corso.getPd()));
			sb.append("\n");
		} 
		System.out.println(sb.toString());
		System.out.println("\n");

		// Punto 2 - Autocompletamento
		Studente studente = model.completaDatiStudente(146101);
		System.out.println(studente + "\n");
		System.out.println("\n");

		// Punto 3 - Studenti iscritti ad un corso
		sb = new StringBuilder();
		for (Studente studente1 : model.DatiStudenteCorso("Diritto Commerciale")) {
			sb.append(String.format("%-11s", studente1.getMatricola()));
			sb.append(String.format("%-50s", studente1.getNome()));
			sb.append(String.format("%-50s", studente1.getCognome()));
			sb.append(String.format("%-50s", studente1.getCDS()));
			sb.append("\n");
		}
        System.out.println(sb.toString());
        System.out.println("\n");
        
        //Punto 4 - Corsi Frequentati da uno studente
        sb = new StringBuilder();
		for (Corso corso : model.CorsiSeguitiDaStudente(new Studente(146101, null, null, null))) {
			sb.append(String.format("%-50s", corso.getCodins()));
			sb.append(String.format("%-11s", corso.getCrediti()));
			sb.append(String.format("%-50s", corso.getNome()));
			sb.append(String.format("%-11s", corso.getPd()));
			sb.append("\n");
		}
        System.out.println(sb.toString());
        System.out.println("\n");
        
        //Punto 5 - Verificare se studente iscritto ad un corso
        boolean rs = model.isStudenteinCorso(new Studente(146101, null, null, null), new Corso("02CIXPG", null, null, null));
        if (rs == true) {
			System.out.println("Studente Frequenta il corso");
		} else {
			System.out.println("Studente non Frequenta il corso");
		}
        System.out.println("\n");

		// Punto 6 - iscrizione studente al corso
		 rs = model.inscriviStudenteACorso(new Studente(146101, null, null, null),
				new Corso("02AQJPG", null, null, null));
		if (rs == true) {
			System.out.println("ok");
		} else {
			System.out.println("non ok");
		}

	}

}
