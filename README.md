Ecom-Application Backend

 Description
Ce projet constitue le backend d'une application de commerce électronique. Il fournit des API pour gérer les produits, les utilisateurs, les commandes et d'autres fonctionnalités nécessaires à une application e-commerce.

 Fonctionnalités principales
- Gestion des utilisateurs : inscription, connexion et gestion des profils.
- Gestion des produits : ajout, modification, suppression et récupération des produits.
- Gestion des commandes : création, suivi et historique des commandes.
- Intégration avec des services tiers pour les paiements ou les notifications.

 Microservices
Le projet est basé sur une architecture de microservices comprenant :
- Config Service : gestion centralisée de la configuration.
- Discovery Service : découverte des services pour l'intercommunication.
- Billing Service : gestion des factures et des paiements.
- Inventory Service : gestion des stocks de produits.
- Customer Service : gestion des données des clients.

 Technologies utilisées
- Langage : Java
- Framework : Spring Boot
- Base de données :H2
- Gestion des dépendances : Maven
- Authentification : JWT (JSON Web Tokens)

 Prérequis
- JDK : version 17 
- Base de données : H2

![Capture d'écran 202![Capture d'écran 2024-12-18 101444](https://github.com/user-attachments/assets/3857e664-742d-4efd-999b-ed62660615cd)
![Capture d'écran 2024-12-18 101237](https://github.com/user-attachments/assets/03df828e-4a01-44d6-b9d7-f65da8f13886)
4-12-18 101132](https://github.com/user-attachments/assets/178aeee5-28ab-45b6-b1c6-d96d7d91b917)
![Capture d'écran 2024-12-18 100942](https://github.com/user-attachments/assets/46a716d5-4622-481b-86ae-f886643858d3)
 Installation
1. Clonez le dépôt :
   ```bash
   git clone https://github.com/meryemlaafar/Backend-App.git
   ```
2. Naviguez dans le répertoire du projet :
   ```bash
   cd ecom-application
   ```
3. Configurez les paramètres de la base de données dans `application.properties` :
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/ecom_db
   ```
4. Compilez et packagez l'application :
   ```bash
   mvn clean package
   ```
 Utilisation
- L'application sera disponible à l'adresse suivante : `http://localhost:8080`
Auteur
Meryem Laafar


