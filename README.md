# 💼 Projet TP Java EE - JPA / Hibernate

### 👨‍💻 Réalisé par :
**Jacques Junior LEBAMA**  
Étudiant en IR4 – Majeure Big Data  
ESAIP École d'Ingénieurs

---

## 🎯 Objectif du projet

Ce projet met en pratique les concepts de Java EE avec **JPA (Jakarta Persistence API)** et **Hibernate** comme provider, via une série de TP progressifs.  
L'objectif est de :

- Modéliser une base de données bancaire relationnelle
- Manipuler des entités Java (POJOs) avec JPA
- Gérer les relations (OneToMany, ManyToOne, ManyToMany, Inheritance)
- Utiliser les annotations JPA pour le mapping objet-relationnel (ORM)
- Persister des objets en base MariaDB

---

## 📚 Technologies utilisées

| Outil / Technologie | Version |
|---------------------|---------|
| Java                | 21      |
| Hibernate ORM       | 6.3.1   |
| Jakarta Persistence | 3.1     |
| MariaDB             | 10.x    |
| IntelliJ IDEA       | 2024.3  |
| Maven               | 3.9+    |

---

## 🛠️ Configuration du projet

### 1. Base de données

- **Nom** : `banque`
- **SGBD** : MariaDB
- **Port** : `3306`
- **Identifiants** :
  - Utilisateur : `root`
  - Mot de passe : `190800`

> Les tables sont automatiquement générées par Hibernate (`schema-generation.database.action = create`).

---

### 2. Dépendances Maven (extrait `pom.xml`)

```xml
<dependencies>
    <dependency>
        <groupId>org.mariadb.jdbc</groupId>
        <artifactId>mariadb-java-client</artifactId>
        <version>3.5.3</version>
    </dependency>
    <dependency>
        <groupId>org.hibernate.orm</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>6.3.1.Final</version>
    </dependency>
</dependencies>
