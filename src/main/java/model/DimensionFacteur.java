package model;

/**
 * Classe DimensionFacteur.
 * Definit statiquement tout les valeurs de dimension.
 */
public final class DimensionFacteur {
    
    private static float facteur = (float) 2.45; 
    private static int width = Math.round(200 * DimensionFacteur.getFacteur()); 
    private static int height = Math.round(20 * 16 * DimensionFacteur.getFacteur()); 
    private static int vitesseMap = Math.round((float) 0.5 * DimensionFacteur.getFacteur()); 
    
    private DimensionFacteur() {
        
    }
    
    public static float getFacteur() {
        return DimensionFacteur.facteur;
    }
  
    public static int getHauteurFenetre() {
        return DimensionFacteur.height;
    }
    
    public static int getLongueurFenetre() {
        return DimensionFacteur.width;
    }
    
    public static int getVitesseMap() {
        return DimensionFacteur.vitesseMap; 
    }
    
    /**
    * Convertir directement un int selon le facteur.
     * @param nb
     * @return 
    */
    public static int transformNbByFactor(final int nb) {
        return Math.round(DimensionFacteur.facteur * nb); 
    }
}
