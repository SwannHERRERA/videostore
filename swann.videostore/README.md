videostore
==========

The videostore example from Episode 3 of cleancoders.com.
Based upon, but not identical to, the first chapter of Martin Fowler's classic book: Refactoring.

---
Refacto


### Code Smell
- Indentation
- Test qui ne couvre pas tous las cas
- Mélange entre l'affichage et la logique (présentation et domaine)
- fonction trop complexe (trop de niveau d'indentation)
- fonction trop longue
- des variables en static qui determinent le type d'un film
- Les tests qui sont "des test d'intégrations" testent le fonctionnement global de l'application, sans tester que les fonctions jouent bien leurs roles. De plus les tests sont imcomplets, il est possible de les valider en faisant le mauvais calcul.

### Refactoring action

- Ajout d'une structure au projet (changelog, contributing)
- Installation de Maven (a partir de default quickstart)
- Initialisation du projet avec gitFlow ![gitflow Atlasian guide](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow)
- Modification des tests (Ajout de decorateur)
- Renommage et extraction de code dans des fonctions séparées
- Création d'une énumération pour le type du film (qui sera remplacé après)
- Création d'un objet list de rental pour pouvoir recalculer sur la modification et puis parce que certaines fonctions que j'avais fait emerger n'avaient pas de sens dans la class customer (Design Patern Utilisé: Proxy)
- Changement du fonctionnement de movie en class abstraite implémentée par 3 sous class et supression de l'énumération, utilisation du polymorphisme (Design Patern Utilisé: Factory)
- Ajout de tests pour "chaque class utile"

### Bénéfice

- Plus facilement compréhensible
- Plus facilement modifiable
- Modifiable sans risque de casser (grace au test)
- plus simple a debugger

## Détail du processus de refactoring

Après avoir lu le sujet, j'ai tout de suite voulu aller lire le code.

La première chose que j'ai faite, c'est de reformater le code j'ai juste demandé à mon IDE de le faire, mais c'est la première action qui a été mise en place avant même de lire le code.

Ensuite, j'ai déplacé les propriétés vers le haut des class, c'est une préférence personnelle.

Après avoir bien compris le code j'ai "repris le projet" j'ai créé un projet maven dans lequel j'ai reporté le code d'UncleBob.
 
J'ai ajouté des décorateurs pour les tests, sinon je n'arrivais pas à les lancer. J'ai créé des fichiers changelog et contributing premièrement pour pouvoir être plus à l'aise quand je rédigerais ceci, et aussi pour que les personnes qui reprennent le projet soient plus à l'aise en sachant comment faire et qu'est-ce qui a été fait.

Ensuite, j'ai analysé ce que je devais changer. Pour moi il était évident que le type de Movie devait être traité autrement, j'ai d'abord pensé à une énumération peut être à cause du code déjà existant j'ai ensuite changé d'avis quand j'ai essayé de travailler sur les Movies.

En tout premier lieu, mon but était de découper la complexité dans des fonctions. (pour l'instant ce n'est pas grave si ces fonctions ne sont pas à la bonne place ou pas on pourra faire émerger des classes plus tard)

J'ai aussi encapsulé la liste de Rental pour pouvoir faire des actions spécifiques dessus, tel que calculer les points de fidélité, et le MontantTotal au moment de l'ajout d'un rental dans la liste.

### Mes intérrogations

- J'ai créé une class abstraite pour les movies l'option de l'interface m'a paru moins pertinente.
- Il y a eu certains moments où j'ai du changer beaucoup de codes et que les tests ne passaient plus, pendant longtemps ce qui m'a mis mal à l'aise. Après réflexion j'aurai presque du faire du TDD pour ce projet. La question : Est-ce que le code fonctionne comme il faut m'a beaucoup dérangé.
- Pour les tests de la fonction getTitle des movies , je ne savais pas trop comment procéder. Je les ai mis dans movieChildren je ne voulais pas dupliquer le test pour tous les types de movies, je ne voulais pas non plus rendre Movie instanciable.
- Je n'ai pas crée de "builder" étant donnée que l'application n'a pas de main a proprement parler. Je me suis dis qu'il valait mieux suivre l'accornime YAGNI que d'essayer de faire quelque chose trop bien.