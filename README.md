# projet_pvz
projet java 4A Alban Flouvat
Backend - Plants vs Zombies

Attention le code se trouve sur la branche master!!

Description
Ce projet est le backend Java pour une application Plants vs Zombies.
Il fournit une API REST permettant de :

Gérer les plantes, zombies et maps du jeu.

Valider et manipuler les entités via une base de données MySQL.

Ce backend a été développé en Java 16+ avec Spring Framework (sans Spring Boot), déployé localement via SmartTomcat (plugin IntelliJ IDEA).

🔧 Technologies utilisées
Java 16+

Spring MVC

Spring JDBC

MySQL

Maven

Tomcat 9.x via SmartTomcat (extension IntelliJ IDEA)

📚 Architecture du projet
Le projet suit une architecture en couches claire et maintenable :

1. Model
Contient les classes métiers (Zombie, Plante, Map).

Représente directement les entités manipulées en base de données.

2. DTO (Data Transfer Object)
Sert d'interface pour les échanges de données JSON avec le frontend.

Exemple : ZombieDTO, PlanteDTO, MapDTO, ainsi que NewZombieDTO, NewPlanteDTO, NewMapDTO pour les créations.

3. Mapper
Contient la logique de transformation entre les Model et les DTO.

Permet de séparer la logique métier du format de transmission.

4. RowMapper
Traduit les résultats SQL (ResultSet) en objets Model.

Exemple : ZombieRowMapper, PlanteRowMapper, MapRowMapper.

5. DAO (Data Access Object)
Accède directement à la base de données via JdbcTemplate.

Contient toutes les opérations CRUD sur les entités (findAll, findById, create, update, delete).

6. Service
Contient la logique métier de l'application.

Interagit avec les DAO pour effectuer des opérations complexes.

Exemple : lors de la suppression d'une Map, le MapService supprime d'abord les Zombies et Plantes liés via leurs services respectifs, avant de supprimer la map elle-même.

7. Controller
Expose les endpoints REST pour le frontend React.

Utilise les services pour traiter les requêtes.

🌍 API REST - Endpoints exposés
Plantes
GET /plantes : Liste toutes les plantes.

GET /plantes/{id} : Récupère une plante par ID.

POST /plantes : Crée une nouvelle plante.

PUT /plantes/{id} : Modifie une plante existante.

DELETE /plantes/{id} : Supprime une plante existante.

Zombies
GET /zombies : Liste tous les zombies.

GET /zombies/{id} : Récupère un zombie par ID.

POST /zombies : Crée un nouveau zombie.

PUT /zombies/{id} : Modifie un zombie existant.

DELETE /zombies/{id} : Supprime un zombie existant.

Maps
GET /maps : Liste toutes les maps.

GET /maps/{id} : Récupère une map par ID.

POST /maps : Crée une nouvelle map.

PUT /maps/{id} : Modifie une map existante.

DELETE /maps/{id} : Supprime une map existante, en supprimant d'abord les zombies et plantes liés.

⚙️ Installation et lancement
Prérequis
Java 17+

Maven

MySQL

IntelliJ IDEA (avec SmartTomcat installé)

Étapes
Cloner ou importer le projet dans IntelliJ.

Configurer la base de données MySQL :

Créer une base pvz.

Utiliser le script SQL fourni pour créer les tables et insérer les données de test.

Configurer SmartTomcat :

Ajouter une configuration SmartTomcat dans IntelliJ.

Définir la bonne version de Tomcat.

Définir le chemin du dossier webapp.

Lancer l'application via SmartTomcat.

Exemple de configuration SmartTomcat
Tomcat version : 9.x ou supérieur

Deployment directory : /src/main/webapp

Context path : /CoursEpfBack

HTTP port : 8080

Adresse accessible
Backend API : http://localhost:8080/CoursEpfBack

🔥 Notes importantes
La configuration CORS autorise les appels depuis http://localhost:5173 pour le frontend React.

Les images doivent être stockées dans /webapp/images/ sous les sous-dossiers plante/, zombie/ et map/.

Lors de la suppression d'une Map, tous les Zombies liés sont d'abord supprimés pour éviter les violations d'intégrité en base.

Structure du projet : 
com.epf
├── Controllers/
│   ├── ZombieController.java
│   ├── PlanteController.java
│   └── MapController.java
├── Core/
│   ├── ZombieService.java
│   ├── PlanteService.java
│   └── MapService.java
├── DTO/
│   ├── ZombieDTO.java
│   ├── NewZombieDTO.java
│   ├── PlanteDTO.java
│   ├── NewPlanteDTO.java
│   ├── MapDTO.java
│   └── NewMapDTO.java
├── Mapper/
│   ├── ZombieMapper.java
│   ├── PlanteMapper.java
│   └── MapMapper.java
├── Models/
│   ├── Zombie.java
│   ├── Plante.java
│   └── Map.java
├── Persistance/
│   ├── ZombieDAO.java
│   ├── PlanteDAO.java
│   └── MapDAO.java
├── RowMapper/
│   ├── ZombieRowMapper.java
│   ├── PlanteRowMapper.java
│   └── MapRowMapper.java
