# Projet de qualité de développement

---

## Projet Crazy Road

> Ce projet est un jeu similaire à Crossy Road développer par nous-même avec pour but de respecter les normes de qualité de développement.


### Pour vérifier la qualité du code :
il vous suffit simplement de faire un : `mvn test`<br>

### Comment Générer la documentation ?
`mvn site`<br>
`php -S localhost:1212 -t /target/site/`

### Comment lancer le jeu ?
`mvn exec:java`

### Quel design pattern ?
> Nous avons utilisé le design pattern MVC et Strategy pour notre projet. Le design pattern stratégy a été utilisé pour les classes controllers et les classes vues. Les classes controllers sont reliées à une classe abstraite pour définir chacune leur stratégy. De même pour les vues qui partagent un ensemble d'informtaion identique en étant les classes filles d'une classe abstraite, mais l'écran Menu et Jeu affiche du contenu différent, donc une stratégy. 

> Nous avons aussi utilisé les design pattern Observer pour rafraîchir constament l'écran, mais nous avons aussi utilisé le design pattern Singleton sur la classe [Personnage.java](./src/main/java/model/Personnage.java) et [Fenetre.java](./src/main/java/view/Fenetre.java) car il n'y a besoin que d'un seul personnage et d'une seule fenetre dans le jeu.

> Nous avons aussi utilisé le design pattern Factory pour le terrain : [TerrainFactory.java](./src/main/java/model/Terrain/TerrainFactory.java), mais aussi pour les véhicules : [VehiculeFactory.java](./src/main/java/model/Vehicule/VehiculeFactory.java) car nous avons jugé qu'il était préférable que la création de ces éléments peu importe le type soit 100% aléatoire, ce qui nous permet de faire de la génération procédurale. Cela nous permet aussi de créer des véhicules différents comme des voitures, des motos et des camions, ainsi que des terrains différents comme les routes et les champs.

### Quelles sont les fonctionnalités ? 
> Le jeu démarre sur l'écran du Menu. Appuyez sur le bouton pour commencer une partie, cette action ouvrira la page du jeu.

> Sur la page du jeu, vous pouvez déplacer le personnage en appuyant sur les flèches directionnelles du clavier pour aller à droite, à gauche, en bas et en haut. Les déplacements sont limités en raison des collisions avec les arbres. Lorsque le personnage rencontre un arbre, il ne peut pas avancer.

> A chaque déplacement vers le haut sur un terrain différent, le score est incrémenté de 1.

> Le terrain est généré de manière procédurale et totalement aléatoire. Il peut générer des routes qui contiendront des véhicules, ou des champs de différentes tailles avec un emplacement d'arbres aussi différent. Le terrain défile constamment vers le bas, c'est pourquoi le joueur doit avancer pour éviter de perdre. Plus le personnage est haut, plus le terrain défile rapidement.

> Concernant les véhicules, il existe les voitures qui ont une vitesse moyenne, les motos qui sont très rapides et les camions qui sont assez lents. Leur masque de collision représente la taille de leur image, sauf celle du camion qui a été réajusté. En cas de collision avec un véhicule, la partie est perdue et le joueur est téléporté vers l'écran du Menu dès lors que le personnage atteint le bas de l'écran.

> Le joueur a la possibilité de mettre le jeu en pause, soit en pressant la touche échap du clavier, ou en cliquant sur l'îcone pause en haut à droite de l'écran.

> Une musique est jouée lors du jeu, et des sons sont émis lors du déplacement du personnage et lors de sa mort.

---

## *Projet réalisé par Nahil Rahmani, Félix Vandamme, Lucas Laiguillon et Erwan Corbin <sub>Étudiants de G1S4</sub>*