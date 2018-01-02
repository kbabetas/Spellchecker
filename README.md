# Spellchecker
### Team Name: **Dirty Bits**

Spellchecker is a Java application which checks the spelling in Greek or English. It can check the spelling either on a text the user has typed or on a provided txt file.

Spellchecker is a team project assigned by Diomidis Spinellis for the course of Programming II at the Department of Management Science and Technology (DMST) of the Athens University of Economics and Business (AUEB).

## Authors

* **8160017 Βούγιας Ιωάννης - IoannisVougias**

* **8160020 Γεωργούλη Χριστιάννα - javalicious**

* **8160035 Κακουλάκη Μαρίνα - MarinaKakoulaki**

* **8160058 Λαζαρίδη Ιωάννα - ioannalaza**

* **8160059 Λαζαρίδου Ιωάννα - ioannalazaridou**

* **8160078 Μπαμπέτας Κωνσταντίνος - kbabetas**

* **8160105 Παυλίδη Μαρία Μαρίνα - marininapav**

* **8160121 Σπέρτου Χρυσή - chrysasp**

## To Build:
Primary build is supported with **maven**.
```
mvn package
```
Artifacts:
* ``` Spellchecker/target/Spellchecker-1.0-SNAPSHOT.jar ```

## Installation
There are two install options: a bat file or a self-contained jar file.

To start from the bat file, simply double click on the ``` run_Spellchecker.bat ```

If you would like to run the Spellchecker-1.0-SNAPSHOT.jar, change the directory to Spellchecker/target, then execute:

``` 
java -jar Spellchecker-1.0-SNAPSHOT.jar
```

After installation, the output should contain:

```
Active code page: 737
Press 1 for Greek/ Πιέστε 1 για ελληνικά:
Press 2 for English/ Πιέστε 2 για αγγλικά:
Press 3 to exit/ Πιέστε 3 για έξοδο:

1

Πληκτρολόγησε 1 άμα θέλεις να γράψεις ένα δικό σου  κείμενο:
Πληκτρολόγησε 2 άμα θέλεις να ελέγξεις ορθογραφικά ένα αρχείο της επιλογής σου:

1

Πληκτρολόγησε ένα κείμενο στα ελληνικά και θα ελέγξουμε άμα είναι ορθογραφικά σωστό:

Καλησπέρα, αυτώ ειναι ένα παράδειγμα ορθογραφικού ελέγχου.

Προτεινόμενες λέξεις για: αυτώ :
αιτώ
αυτά
αυτέ
αυτή
αυτί
αυτό
αυτών
παυτώ
ψαυτώ
-
Προτεινόμενες λέξεις για: ειναι :
είναι
-

Οι λάθος λέξεις είναι :

αυτώ
ειναι
```

## Requirements

* [Java](http://www.oracle.com/technetwork/java/javase/downloads/jdk9-downloads-3848520.html) - Java jdk
* [Maven](https://maven.apache.org/) - Dependency Management
