package AlvineTchimou_DjaaRaphaeltp4;

import java.sql.SQLException;
import java.util.HashMap;

import DjaaRaphael.TchimouAlvinetp2.Grille;

public class App {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		ChargerGrille c_grille=new ChargerGrille();
		//System.out.println( c_grille.grillesDisponibles());
		System.out.println( c_grille.extraireGrille(1).toString());

	}

}
