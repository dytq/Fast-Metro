# Fast-Metro

## Présentation du logiciel
Fast-Metro est un logiciel permettant de trouver le plus court chemin entre deux stations de métro. Ce logiciel utilise la puissance de Java,de Jframe, Maven(pas d'utilisation des tests unitaire) et du standard Json pour faciliter les transferts de données. 

## Explication de la structure du projet
Pour plus de précision j'invite le jury à consulté la javadoc. Néanmoins, voici un résumer de la structure du projet:

1) fastmetro package: contient la classe main et les classes de structures de données
	a) Main.class: class principal 
	b) Carte.class: Tous ce qui concerne la carte (detail section Carte.class)
	c) Station.class: Tous ce qui concerne une station (nom,numéro de la stations,ligne etc...)
	d) Lecture.class: Pour lire un json.

2) graphique package: pour l'interface (voir dans le doc/index.html avec un navigateur)

## Carte.class

### Structure de données

### Algorithme du plus court chemin Dijkstra

