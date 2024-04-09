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
> Nous avons utilisé le design pattern MVC et Strategy pour notre projet.

> Nous avons aussi utilisé les design pattern Observer pour la gestion des collisions, mais nous avons aussi utilisé le design pattern Singleton sur la classe [Personnage.java](./src/main/java/model/Personnage.java) et [Fenetre.java](./src/main/java/view/Fenetre.java) car il y a besoin que d'un seul personnage dans le jeu.

> Nous avons aussi utilisé le design pattern Factory pour le terrain : [TerrainFactory.java](./src/main/java/model/Terrain/TerrainFactory.java), mais aussi pour les véhicules : [VehiculeFactory.java](./src/main/java/model/Vehicule/VehiculeFactory.java) car nous avons jugé qu'il était préférable que la création d'un véhicule peu importe le type soit 100% aléatoire.

---

## *Projet réalisé par Nahil Rahmani, Félix Vandamme, Lucas Laiguillon et Erwan Corbin <sub>Étudiants de G1S4</sub>*