# Fast-Metro

## Présentation du logiciel
Fast-Metro est un logiciel permettant de trouver le plus court chemin entre deux stations de métro. Ce logiciel utilise la puissance de Java(Langage de programmation orienté objet),de Jframe(bibliothèque graphique native de Java) , Maven(pour les dépendances) et du standard Json (lire et écrire sur un fichier) pour faciliter les transferts de données.

# Releases
## Execution
java -jar fastmetro.jar

## Mode d'Emploi
Quand on lance le logiciel, vous avez surement sur le prompt le message suivant:
`` Choose your mode [es,eg,u]:  ``

### es: Mode editeur - Init Station
Sert a initialiser des stations et à le sauvegarder dans un fichier. On clique sur la map et on rentre les informations necessaire sur le prompt.

### eg: Mode editeur - Init Graphe
On utilise le prompt pour entrer les valeurs du graphe

### u: Mode utilisateur
On selectionnne les deux stations qu'on souhaite voir le plus court chemin et le logiciel se charge de l'afficher.


## Explication de la structure du projet
Voici un résumer de la structure du projet:

1) fastmetro package: contient la classe main et les classes de structures de données
	a) Main.class: class principal 
	b) Carte.class: Tous ce qui concerne la carte (detail section Carte.class)
	c) Station.class: Tous ce qui concerne une station (nom,numéro de la stations,ligne etc...)
	d) Lecture.class: Pour lire un json.
	e) Ecriture.class: Pour écrire sur un json(initialisé des stations sur une nouvelle carte et faire un nouveau graphe)

2) GUI package: pour l'interface graphique utilisateur (voir dans la java dans doc/index.html avec un navigateur)

## Carte.class

### Structure de données

### Algorithme du plus court chemin Dijkstra
