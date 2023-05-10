# SpotifyKG
This is a project that explores the Spotify dataset and answers 10 competency questions created by SPARQL queries using the concept of knowledge graphs and ontology. The frontend of the application is done using Java with libraries such as Apache Jena and Java Swing.
# Competency Questions
Here are the 10 competency questions that this project aims to answer:

1. Which popular songs in the Pop genre refer to "love" in their lyrics?
2. What is the average duration of songs of type solo from the most popular artist of 2017?
3. Which are the popular rap albums from an artist that have the highest average of "Speechiness" among its songs?
4. Which band has the greatest number of popular albums in the last 30 years?
5. Which is their most popular live song (liveness)?
6. Who is the artist of the album which has the highest valued happiness in 2015 (valence)?
7. How many songs released in 2018 that are danceable became popular?
8. What is the average value of tempo of the 20 most popular electro genre songs?
9. Which are the 5 most popular albums with high value of energy?
10. Who is the most popular artist that produced the higher number of sad songs (valence)?

# How to use the project

To open the Query Interface, run the Musicology.jar file.

This project is implemented using the Maven architecture. The code for the frontend and backend can be found inside the src/main/java/com/kde/groupe folder or can be seen by importing this Maven project into any supported Java IDE.

Use the following command to compile and run the project:
mvn clean install

After building, the final jar with the updated code can be found under target/swing-ui-0.0.1-SNAPSHOT.jar.
