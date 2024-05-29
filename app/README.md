
# SandBox - COUSSEMENT Raphaël

Ce projet consiste à choisir des épisodes en fonction d'un personnage connu.  
Voila en quoi cela consiste : sur la page Home, on a la liste de tous les persos disponibles.  
Une fois le personnage choisit, un son survient et on a la liste de tous les épisodes reliés à ce perso.  
Ensuite, on peut encore cibler un épisode pour avoir plus de détails

## Table des matières
1. [AndroidManifest  ](#androidmanifest )
2. [Data  ](#data )
3. [Domain](#domain)
4. [Contribuer](#contribuer)
5. [UI](#ui)
6.  [Res  ](#res )

## AndroidManifest
Toutes les activités présentes au sein de l'application sont renseignées dans le Manifest.
Dans notre cas, étant donné qu'une vibration est présente lors d'un click, les permissions sont également gérées dans ce fichier.
## Data
La partie Data permet d'avoir la génération de toutes les données.   
Les fichiers finissant par Local sont les listes de tous les models à savoir les épisodes et les personnages  
Les fichiers finissant par Impl sont les implémentations des interfaces. Cela permet d'avoir une porte d'entrée pour les viewModels

## Domain
La partie du domain référence tout le formatage des données à savoir le Model ainsi que tous les interfaces

### Models
Dans ce dossier, il y a la liste de tous les models présent au sein de l'application. C'est donc le schéma de données. Il y a donc Character et Episode

-  **Character:**
    -  `id` : L'identifiant du personnage.
    -   `firstName` : Le prénom du personnage
    -   `lastName` : Le nom du personnage
    -  `age` : L'age du personnage.
    - `episodes` : Une liste d'épisode

-  **Episode:**
    -  `id` : L'identifiant du personnage.
    -   `date` : La date de l'épisode
    -   `name` : Le nom de l'épisode
    -  `description` : La description simple d'un épisode

### Repositories

Les repositories sont des interfaces donc des contrats. Cela permet d'avoir la liste de toutes les actions possibles à faire en lien avec les models. Une implémentation permet d'utiliser les méthodes créées au sein d'une interface.
-  **Character:**
    -  `getCharacterByIdOrNull` : retourne un perso en fonction de son Id.
    -   `getCharacters` : retourne la liste de tous les personnages

-  **Episode:**
    -  `getAllEpisodes` : retourne tous les épisodes
    -   `getEpisodeById` : retourne un épisode en fonction de son Id


## UI
### core.theme

- **Color:**
    - permet de définir toutes les couleurs utilisées au sein de l'application

- **Theme:**
    - permet la gestion des thèmes au sein de l'application

- **Type:**
    - permet la configuration des polices à savoir la taille, les poids et autres attributs de la typographie

### screen
Ce dossier contient toutes les pages de l'application à savoir les screens mais aussi tous les viewModels
- **CharacterDetails:**
    - le fichier `CharacterDetailsScreen.kt ` permet d'avoir le screen des détails d'un personnage avec tous ces épisodes associés. On peut cliquer sur un épisode pour avoir d'avantage d'informations
    - le fichier  `CharacterDetailsViewModel.kt ` permet la récupération des données en appelant les différentes implémentations. Cela est possible grâce à la gestion des états présent dans celui-ci. Toutes ces données sont ensuite transférées au screen

Des dossiers `characters ` et `épisodes ` sont également présents dans le dossier `screens `  mais ne seront pas expliqués. La logique est similaire à celle expliquée dans le dossier `charactersDetails `

### MainActivity

Le mainActivity permet de gérer le cycle de vie de l'application. Sa méthode `onCreate `  est utilisée pour initialiser l'interface utilisateur. La gestion des Intents se fait également dans ce fichier. Cela permet de faire la navigation entre les différentes screens. Cela est permis grâce à l'écoute de tous les événements détectés au sein de l'application

## RES

### drawable
- images
- icones

### mipmap
- icones optimisées


### raw
- contient le son généré lord du click

### values
- valeurs telles que les couleurs, style de texte et thêmes

### xml
- fichiers de configuration