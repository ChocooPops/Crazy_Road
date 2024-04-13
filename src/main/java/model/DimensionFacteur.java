package model;

/**
 * Classe DimensionFacteur.
 * Definit statiquement tout les valeurs de dimension.
 */
public final class DimensionFacteur {
    
    private static float facteur = (float) 2.45; 
    private static int width = Math.round(200 * DimensionFacteur.getFacteur()); 
    private static int height = Math.round(20 * 16 * DimensionFacteur.getFacteur()); 
    private static int vitesseMap = 
            Math.round((float) 0.8 * DimensionFacteur.getFacteur());
    private static int vitesseMax = Math.round((float) 1.5 * DimensionFacteur.getFacteur()); 
    private static int vitesseMin = Math.round((float) 0.8 * DimensionFacteur.getFacteur()); 
    
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
    * Accelere la vitesse de déplacement de la map.
    */
    public static void accelererVitesse() {
        vitesseMap = vitesseMax;
    }
    
    /**
    * Descelere la vitesse de déplacement de la map.
    */
    public static void descelererVitesse() {
        vitesseMap = vitesseMin;
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
