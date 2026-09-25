# 👤 Users API

API REST développée avec **Java et Spring Boot** pour gérer les utilisateurs de l'application **Square Games**.

Cette application constitue un service indépendant de gestion des utilisateurs. Elle peut fonctionner en parallèle de l'application `Square Games`.

---

## 📌 Présentation

**Users API** permet de gérer les utilisateurs qui participent aux parties de **Square Games**.

L'API permet notamment de :

* créer un utilisateur ;
* récupérer un utilisateur par son identifiant ;
* supprimer un utilisateur ;
* vérifier si un utilisateur existe et est valide.

L'application est conçue comme un service indépendant afin de séparer la gestion des utilisateurs de la gestion des parties de jeux.

---

## 🛠️ Technologies utilisées

* ☕ Java
* 🌱 Spring Boot
* 🌐 Spring Web
* 🗄️ Spring Data JPA
* 🐘 PostgreSQL
* 📦 Maven
* 🔧 Git / GitHub
* 🧪 Bruno

---

# 🏗️ Architecture

Le projet utilise une architecture en couches :

```text
Controller
    ↓
Service
    ↓
DAO
    ↓
JPA / Database
```

### Controller

La couche Controller expose les endpoints REST de l'application.

### Service

La couche Service contient la logique métier.

Elle permet notamment de :

* créer un utilisateur ;
* rechercher un utilisateur ;
* supprimer un utilisateur ;
* vérifier la validité d'un utilisateur.

### DAO

La couche DAO permet de séparer la logique métier de l'accès aux données.

Elle communique avec la base de données via **JPA**.

### Entity

L'entité `User` représente un utilisateur enregistré dans la base de données.

---

# 🚀 Installation

## Prérequis

* Java
* Maven
* PostgreSQL
* Git

Cloner le dépôt :

```bash
git clone https://github.com/Mouna-MAHMOUDI/Users.git
```

Puis :

```bash
cd Users
```

Construire le projet :

```bash
./mvnw clean install
```

Lancer l'application :

```bash
./mvnw spring-boot:run
```

---

# ⚙️ Configuration

L'application Users fonctionne sur un port différent de l'application `Square Games`.

```text
Users API     → 8081
Square Games  → 8080
```

Cette séparation permet aux deux applications Spring Boot de fonctionner simultanément.

La configuration de la base de données PostgreSQL est réalisée dans les fichiers de configuration Spring Boot.

⚠️ Les identifiants, mots de passe et informations sensibles de connexion à PostgreSQL ne doivent pas être publiés sur GitHub.

---

# 🗄️ Base de données

L'application utilise **PostgreSQL** avec **Spring Data JPA**.

La base de données contient les informations nécessaires à la gestion des utilisateurs.

JPA permet notamment de :

* représenter la table utilisateur avec une entité Java ;
* sauvegarder un utilisateur ;
* rechercher un utilisateur ;
* supprimer un utilisateur.

---

# 🔌 API REST

L'application est accessible par défaut à :

```text
http://localhost:8081
```

---

## ➕ Créer un utilisateur

```http
POST /users
```

Exemple :

```json
{
  "name": "Mouna"
}
```

La réponse contient les informations du nouvel utilisateur ainsi que son identifiant.

---

## 🔎 Récupérer un utilisateur

```http
GET /users/{id}
```

Exemple :

```text
GET /users/2c22fc8d-29a6-400c-803c-7adf352053e7
```

---

## 🗑️ Supprimer un utilisateur

```http
DELETE /users/{id}
```

---

## ✅ Vérifier un utilisateur

```http
GET /users/{id}/valid
```

Cet endpoint permet de vérifier si l'utilisateur existe et peut être utilisé par l'application `Square Games`.

---

# 🔗 Communication avec Square Games

L'application **Square Games** utilise ce service pour vérifier l'existence des joueurs.

Le principe est le suivant :

```text
                    ┌─────────────────────┐
                    │     Square Games    │
                    │      Port 8080      │
                    └──────────┬──────────┘
                               │
                               │ HTTP
                               ↓
                    ┌─────────────────────┐
                    │      Users API      │
                    │      Port 8081      │
                    └──────────┬──────────┘
                               │
                               ↓
                    ┌─────────────────────┐
                    │     PostgreSQL      │
                    └─────────────────────┘
```

Lorsqu'un joueur souhaite créer une partie, `Square Games` peut vérifier auprès de `Users API` que l'utilisateur existe.

---

# 🧪 Tests

Les endpoints peuvent être testés avec **Bruno**.

Les tests permettent notamment de vérifier :

| Fonctionnalité                           |                                     Résultat attendu |
| ---------------------------------------- | ---------------------------------------------------: |
| Création d'un utilisateur                |                                        `200` / `201` |
| Récupération d'un utilisateur existant   |                                                `200` |
| Utilisateur inexistant                   |                                                `404` |
| Suppression d'un utilisateur             |                                        `200` / `204` |
| Vérification d'un utilisateur existant   |                                                `200` |
| Vérification d'un utilisateur inexistant | réponse indiquant que l'utilisateur n'est pas valide |

Les codes HTTP exacts dépendent de l'implémentation actuelle de l'API.

---

# 📂 Structure du projet

```text
Users/
│
├── .mvn/
│   └── wrapper/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── mouna/
│   │   │           └── users/
│   │   │               ├── Controller/
│   │   │               ├── Service/
│   │   │               ├── Dao/
│   │   │               ├── Entity/
│   │   │               └── UsersApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

---

# 🎯 Compétences mises en pratique

Ce projet permet de mettre en pratique :

* programmation orientée objet avec Java ;
* Spring Boot ;
* création d'une API REST ;
* injection de dépendances ;
* architecture Controller / Service / DAO ;
* JPA ;
* gestion d'une base PostgreSQL ;
* gestion des requêtes HTTP ;
* gestion des codes HTTP ;
* communication entre deux applications Spring Boot ;
* tests d'API avec Bruno ;
* Git et GitHub.

---

# 🔮 Évolutions possibles

Les évolutions possibles du projet sont notamment :

* ajouter une authentification ;
* ajouter une validation plus complète des utilisateurs ;
* documenter l'API avec Swagger / OpenAPI ;
* ajouter des tests unitaires ;
* ajouter des tests d'intégration ;
* améliorer la gestion des erreurs ;
* mettre en place une authentification JWT.

---

👩‍💻 Auteur

Mouna Mahmoudi

Projet réalisé dans le cadre d'une formation en développement d'applications Java / Spring Boot.

🔗 GitHub

Users — Mouna-MAHMOUDI
