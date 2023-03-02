package DjaaRaphael.TchimouAlvinetp2;

public class CaseMC {
    private char solution;
    private char proposition;
    private String defHorizontale;
    private String defVerticale;
    private boolean estNoire;
    
    public CaseMC(boolean noire) {
    	this.estNoire=  noire;
        
  }
    
    public char getSolution() {
        return solution;
    }
    
    public void setSolution(char sol) {
        this.solution = sol;
    }
    
    public char getProposition() {
        return proposition;
    }
    
    public void setProposition(char prop) {
        this.proposition = prop;
    }
    
    public String getDefHorizontale() {
        return defHorizontale;
    }
    
    public void setDefHorizontale(String defH) {
        this.defHorizontale = defH;
    }
    
    public String getDefVerticale() {
        return defVerticale;
    }
    
    public void setDefVerticale(String defV) {
        this.defVerticale = defV;
    }
    
    public boolean estNoire() {
        return estNoire;
    }
    
    public void setNoire(boolean noire) {
        this.estNoire = noire;
    }
}
