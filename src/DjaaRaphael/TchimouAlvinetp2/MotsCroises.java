package DjaaRaphael.TchimouAlvinetp2;

//import DjaaRaphael.TchimouAlvine.Grille;

public class MotsCroises<T> {
    private Grille<T> solution;
    private Grille<T> proposition;
    private Grille<String> horizontal;
    private Grille<String> vertical;
    private boolean[][] cases;

    public MotsCroises(int hauteur, int largeur) {
        solution = new Grille<T>(hauteur, largeur);
        proposition = new Grille<T>(hauteur, largeur);
        horizontal = new Grille<String>(hauteur, largeur);
        vertical = new Grille<String>(hauteur, largeur);
        cases = new boolean[hauteur][largeur];
    }

    public int getHauteur() {
        return solution.getHauteur();
    }

    public int getLargeur() {
        return solution.getLargeur();
    }

    public boolean coordCorrectes(int lig, int col) {
        return this.horizontal.coordCorrectes(lig, col);
    }

    public boolean estCaseNoire(int lig, int col) {
        if (!coordCorrectes(lig, col)) {
            throw new IllegalArgumentException("la valeur n'existe pas");
        }
        return this.cases[lig - 1][col - 1];
    }

    public void setCaseNoire(int lig, int col, boolean noire) {
        if (coordCorrectes(lig, col)) {
            this.cases[lig - 1][col - 1] = noire;
        } else {
            throw new IllegalArgumentException("la valeur n'existe pas");
        }
    }

    public T getSolution(int lig, int col) {
        if (!coordCorrectes(lig, col) || estCaseNoire(lig, col)) {
            throw new IllegalArgumentException("la valeur n'existe pas");
        }
        return solution.getCellule(lig, col);
    }

    public void setSolution(int lig, int col, T sol) {
        if (!coordCorrectes(lig, col) || estCaseNoire(lig, col)) {
            throw new IllegalArgumentException("la valeur n'existe pas");
        }
        solution.setCellule(lig, col, sol);
    }

    public T getProposition(int lig, int col) {
        if (!coordCorrectes(lig, col) || estCaseNoire(lig, col)) {
            throw new IllegalArgumentException("la valeur n'existe pas");
        }
        return proposition.getCellule(lig, col);
    }

    public void setProposition(int lig, int col, T prop) {
        if (!coordCorrectes(lig, col) || estCaseNoire(lig, col)) {
            throw new IllegalArgumentException("la valeur n'existe pas");
        }
        proposition.setCellule(lig, col, prop);
    }

    public String getDefinition(int lig, int col, boolean horiz) {
        if (!coordCorrectes(lig, col) || estCaseNoire(lig, col)) {
            throw new IllegalArgumentException("la valeur n'existe pas");
        }
        return (horiz) ? horizontal.getCellule(lig, col) : vertical.getCellule(lig, col);
    }

    public void setDefinition(int lig, int col, boolean horiz, String def) {
        if (!coordCorrectes(lig, col) || estCaseNoire(lig, col)) {
            throw new IllegalArgumentException("la valeur n'existe pas");
        }
        if (horiz) {
            horizontal.setCellule(lig, col, def);
        } else {
            vertical.setCellule(lig, col, def);
        }
    }
}
