
import view.Fenetre;


/**
 *Classe principale.
 */
public final class App {
    
    /**
     * Constucteur privé par défaut.
     */
    private App() {
        throw new AssertionError();
    }

    private App() {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) { 
       Fenetre fenetre = Fenetre.getFenetre();
       fenetre.afficherFenetre();
    }
}
