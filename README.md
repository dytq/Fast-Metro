# Fast-Metro

## Présentation du logiciel
Fast-Metro est un logiciel permettant de trouver le plus court chemin entre deux stations de métro. Ce logiciel utilise la puissance de Java(Langage de programmation orienté objet),de Jframe(bibliothèque graphique native de Java) , Maven(pour les dépendances) et du standard Json, librairie Gson (lire et écrire sur un fichier) pour faciliter les transferts de données.

# Releases
## Execution
java -jar fastmetro.jar

## Mode d'Emploi
On selectionnne les deux stations qu'on souhaite voir le plus court chemin et le logiciel se charge de l'afficher.

## Explication de la structure du projet
Voici un résumer de la structure du projet:

1) fastmetro package: contient la classe main et les classes de structures de données
	a) Main.class: class principal.
	b) Carte.class: Tous ce qui concerne la carte.
	c) Station.class: Tous ce qui concerne une station (numéro de la stations,ligne). Un station est traversée par une ligne dans les deux sens de circulations.
	d) Gare.class: Une gare est un ensemble de stations. Elle contient un nom et une liste de stations.
	e) Lecture.class: Pour lire un json.
	f) Dijkstra: Implémentation de l'algo et utilisation d'un tableau pour faire les opérations.
	g) Ecriture.class(non utilisé): Pour écrire sur un json(initialisé des stations sur une nouvelle carte et faire un nouveau graphe)

2) GUI package: pour l'interface graphique utilisateur (voir dans la javadoc dans Documentation/index.html avec un navigateur pour plus de detail) Mais en gros, on a une fenetre, un panel(station pannel) pour dessiner les stations(changer les couleurs etc...) et circle qui représente un cercle utiliser pour l'affichage des stations. 

## Algorithme du plus court chemin Dijkstra

# Contenu
## Cartes
On peut changer de carte dans image/carte.gif (faut changer le main en conséquence)

## Stations et Gare
On peut changer les stations, elles sont sauvegardées dans data carteStation.json et carteStation.json

## Source
src/\*

## Documentation 
javadoc dans Documentation/index.html

# Annexe

## Screencapture


## Disponible sur github

\url{https://github.com/dytq/Fast-Metro}
