package DjaaRaphael.TchimouAlvinetp2;
import java.util.List;
public class MotsCroisesBis {
    private Grille<CaseMC> grille;

    public MotsCroisesBis(int hauteur, int largeur) {
        grille = new Grille<>(hauteur, largeur);
        for(int i = 1; i <= hauteur; i++) {
            for(int j = 1; j <= largeur; j++) {
                CaseMC caseMC = new CaseMC(false);
                grille.setCellule(i, j, caseMC);
                grille.getCellule(i, j).setSolution('*');
                
                //
            }
        }
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
        if(!coordCorrectes(lig,col)) {
            throw new IllegalArgumentException("la valeur n'existe pas ") ;
        }
        return grille.getCellule(lig, col).estNoire();
    }

    public void setCaseNoire(int lig, int col, boolean noire) {
        if(coordCorrectes(lig,col)) {
            grille.getCellule(lig, col).setNoire(noire);
        } else {
            throw new IllegalArgumentException("la valeur n'existe pas ");
        }
    }

    public char getSolution(int lig, int col) {
        if(!coordCorrectes(lig,col) || estCaseNoire(lig, col)) {
            throw new IllegalArgumentException("la valeur n'existe pas ") ;
        }
        return grille.getCellule(lig, col).getSolution();
    }

    public void setSolution(int lig, int col, char sol) {
        if(!coordCorrectes(lig,col) || estCaseNoire(lig, col)) {
            throw new IllegalArgumentException("la valeur n'existe pas ") ;
        }

        grille.getCellule(lig, col).setSolution(sol);
    }

    public char getProposition(int lig, int col) {
        if(!coordCorrectes(lig,col) || estCaseNoire(lig, col)) {
            throw new IllegalArgumentException("la valeur n'existe pas ") ;
        }
        return grille.getCellule(lig, col).getProposition();
    }

    public void setProposition(int lig, int col, char prop) {
        if(!coordCorrectes(lig,col) || estCaseNoire(lig, col)) {
            throw new IllegalArgumentException("la valeur n'existe pas ") ;
        }

        grille.getCellule(lig, col).setProposition(prop);
    }

    public String getDefinition(int lig, int col, boolean horiz) {
        if(!coordCorrectes(lig,col) || estCaseNoire(lig, col)) {
            throw new IllegalArgumentException("la valeur n'existe pas ") ;
        }
        return (horiz) ? grille.getCellule(lig, col).getDefHorizontale() : grille.getCellule(lig, col).getDefVerticale();
    }

    public void setDefinition(int lig, int col, boolean horiz, String def) {
        if(!coordCorrectes(lig,col) || estCaseNoire(lig, col)) {
            throw new IllegalArgumentException("la valeur n'existe pas ") ;
        }

        if(horiz) {
            grille.getCellule(lig, col).setDefHorizontale(def);
        } else {
            grille.getCellule(lig, col).setDefVerticale(def);
        } }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= grille.getHauteur(); i++) {
            for(int j = 1; j <= grille.getLargeur(); j++) {
                   sb.append(getSolution(i, j)).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    
}
