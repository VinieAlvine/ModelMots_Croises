package DjaaRaphael.TchimouAlvinetp2;
public class MotsCroises {
	private Grille solution;
	private Grille proposition;
	private Grille horizontal;
	private Grille vertical;
	private boolean[][] cases;
	/*Variables d’instance 
	…solution…
	…proposition… 
	…horizontal…
	…vertical…*/
	// Constructeur créant une instance de MotsCroises
	// dotée de 4 instances de Grille, suivant les
	// spécifications données ci-dessous :
	public MotsCroises (int hauteur, int largeur) {
	   
		solution = new Grille(hauteur, largeur);
		proposition = new Grille(hauteur, largeur);
		horizontal = new Grille(hauteur, largeur);
		vertical = new Grille(hauteur, largeur);
		cases = new boolean[hauteur][largeur];
		
	
		
	}
	// Nombre de rangées
	public int getHauteur(){
	    return	solution.getHauteur();
	}
	// Nombre de colonnes
	public int getLargeur(){
		return solution.getLargeur();
	}
	// Validité des coordonnées
	// Resultat : vrai si et seulement si (lig, col)
	// désignent une cellule existante de la grille
	public boolean coordCorrectes(int lig, int col) {
		return this.horizontal.coordCorrectes(lig, col);
	}
	// Accesseurs aux cases noires
	// Précondition : coordCorrectes(lig, col)
	public boolean estCaseNoire(int lig, int col) {
		if(!coordCorrectes(lig,col)) {
			throw new IllegalArgumentException("la valeur n'existe pas ") ;
		}
	  return this.cases[lig-1][col-1];
	}
	public void setCaseNoire(int lig, int col, boolean noire) {
	    if(coordCorrectes(lig,col)) {
	        this.cases[lig-1][col-1] = noire;
	    } else {
	        throw new IllegalArgumentException("la valeur n'existe pas ");
	    }
	}

	// Accesseurs à la grille de solution
	// Préconditions :coordCorrectes(lig, col)!estCaseNoire(lig, col)
	public char getSolution(int lig, int col) {
		if(!coordCorrectes(lig,col) || estCaseNoire(lig, col)) {
			throw new IllegalArgumentException("la valeur n'existe pas ") ;
		}
		return solution.getCellule(lig, col).charAt(0);
	}
	public void setSolution(int lig, int col, char sol) {
		if(!coordCorrectes(lig,col) || estCaseNoire(lig, col)) {
			throw new IllegalArgumentException("la valeur n'existe pas ") ;
		}
		
		solution.setCellule(lig, col,Character.toString(sol));
	}
	// Accesseurs à la grille du joueur
	// Préconditions : idem
	public char getProposition(int lig, int col) {
		if(!coordCorrectes(lig,col) || estCaseNoire(lig, col)) {
			throw new IllegalArgumentException("la valeur n'existe pas ") ;
		}
		return proposition.getCellule(lig, col).charAt(0);
	}
	public void setProposition(int lig, int col, char prop) {
if(!coordCorrectes(lig,col) || estCaseNoire(lig, col)) {
	throw new IllegalArgumentException("la valeur n'existe pas ") ;
}
		
		proposition.setCellule(lig, col,Character.toString(prop));
	}
	// Accesseurs aux définitions.
	// Le paramètre "horiz" est "true" pour les définitions
	// horizontales, "false" pour les définitions verticales.
	// Préconditions : idem
	public String getDefinition(int lig, int col, boolean horiz) {
     if(!coordCorrectes(lig,col) || estCaseNoire(lig, col)) {
    	 throw new IllegalArgumentException("la valeur n'existe pas ") ;
     }
     return (horiz)?horizontal.getCellule(lig, col):vertical.getCellule(lig, col);
		
		
	}
	public void setDefinition(int lig, int col, boolean horiz, String def) {
		  if(!coordCorrectes(lig,col) || estCaseNoire(lig, col)) {
			  throw new IllegalArgumentException("la valeur n'existe pas ") ;
		  }
		  if (horiz) {
		    	 horizontal.setCellule(lig, col,def);
		    	 }
		  else {
			  vertical.setCellule(lig, col,def);
		  }
		  }
	}



