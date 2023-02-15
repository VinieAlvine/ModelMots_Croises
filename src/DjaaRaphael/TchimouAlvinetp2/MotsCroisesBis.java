package DjaaRaphael.TchimouAlvinetp2;
import java.util.List;

public class MotsCroisesBis {
	private Grille<CaseMC> grille;


	public MotsCroisesBis(int hauteur, int largeur) {
		grille = new Grille<>(hauteur, largeur, new CaseMC());
	}

	public int getHauteur() {
		return grille.getHauteur();
	}

	public int getLargeur() {
		return grille.getLargeur();
	}

	public boolean coordCorrectes(int lig, int col) {
		return grille.coordCorrectes(lig, col);
	}

	public boolean estCaseNoire(int lig, int col) {
		return grille.getCellule(lig, col).estCaseNoire();
	}

	public void setCaseNoire(int lig, int col, boolean noire) {
		grille.getCellule(lig, col).setCaseNoire(noire);
	}

	public char getSolution(int lig, int col) {
		return grille.getCellule(lig, col).getSolution();
	}

	public void setSolution(int lig, int col, char sol) {
		grille.getCellule(lig, col).setSolution(sol);
	}

	public char getProposition(int lig, int col) {
		return grille.getCellule(lig, col).getProposition();
	}

	public void setProposition(int lig, int col, char prop) {
		grille.getCellule(lig, col).setProposition(prop);
	}

	public String getDefinition(int lig, int col, boolean horiz) {
		return horiz ? grille.getCellule(lig, col).getDefinitionHorizontale() : grille.getCellule(lig, col).getDefinitionVerticale();
	}

	public void setDefinition(int lig, int col, boolean horiz, String def) {
		if (horiz) {
			grille.getCellule(lig, col).setDefinitionHorizontale(def);
		} else {
			grille.getCellule(lig, col).setDefinitionVerticale(def);
		}
	}


}
