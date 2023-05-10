package com.kde.groupe.constants;

public class CommonConstants {
	
	
	public static final String TTL_EXTENSION = "TTL";
	
	public static final String QUERY_1_TEXT = "Which popular songs in Pop genre refers to “love” in their lyrics?";
	public static final String QUERY_1 = "PREFIX : <http://www.semanticweb.org/ontologies/music#>\n"
			+ "\n"
			+ "SELECT ?songName ?lyrics ?releaseDate where {\n"
			+ "    ?song a :Song.\n"
			+ "    ?aco a :AcousticFeatures.\n"
			+ "    ?songp a :SongPopularity.\n"
			+ "    \n"
			+ "    ?songp :popular \"True\".\n"
			+ "    ?songp :hasSong ?song.\n"
			+ "    ?song :hasFeatures ?aco.\n"
			+ "    \n"
			+ "    ?song :name ?songName.\n"
			+ "    ?aco :lyrics ?lyrics.\n"
			+ "    ?song :release_date ?releaseDate.\n"
			+ "    \n"
			+ "    FILTER CONTAINS(?lyrics,\"love\").\n"
			+ "    \n"
			+ "}";
	public static final String [] QUERY_1_HEADERS = {"Song Name", "Lyrics", "Release Date"};
	
	public static final String  QUERY_1_LYRICS_HIGHLIGHT_WORD = "love";
	
	
	public static final String QUERY_2_TEXT = "What is the average duration of songs of type solo from the most popular artist of 2017?";
	public static final String QUERY_2 = "PREFIX : <http://www.semanticweb.org/ontologies/music#>\n"
			+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
			+ "select (AVG(xsd:integer(?song_duration)/60000) as ?avg_duration) ?artistImage ?artistName where {\n"
			+ "    ?artist_2 a :Artist.\n"
			+ "    ?release a :Release.\n"
			+ "    ?album a :Album.\n"
			+ "    ?song a :Song.\n"
			+ "    ?artist_2 :name ?artistName.\n"
			+ "    ?artist_2 :artistRelease ?release.\n"
			+ "    ?release :albumRelease ?album.\n"
			+ "    ?album :isComposedBy ?song.\n"
			+ "    ?album :cover ?albumCover.\n"
			+ "    ?song :song_type ?song_type.\n"
			+ "    ?song :duration ?song_duration.\n"
			+ "    {\n"
			+ "        select ?artistName ?artistImage where {\n"
			+ "            ?artist_pop a :ArtistPopularity.\n"
			+ "            ?artist a :Artist.\n"
			+ "            ?artist_pop :hasArtist ?artist.\n"
			+ "            ?artist :name ?artistName.\n"
			+ "            ?artist :img ?artistImage.\n"
			+ "            ?artist :popularity ?artist_popularity.\n"
			+ "            ?artist_pop :year ?artist_pop_year.\n"
			+ "            FILTER(?artist_pop_year=\"2017\").\n"
			+ "        } ORDER BY DESC(?artist_popularity) LIMIT 1\n"
			+ "    }\n"
			+ "    FILTER(?song_type=\"Solo\")\n"
			+ "} GROUP BY ?artistName ?albumCover ?artistImage LIMIT 1";
	public static final String [] QUERY_2_HEADERS = {"Artist Name", "Artist Image", "Average Duration"};
	

	public static final String QUERY_3_TEXT = "Which are the popular rap albums from an artist that have the higher average of “Speechiness” among its songs?";
	public static final String QUERY_3 = "PREFIX ex: <http://www.semanticweb.org/ontologies/music#>\n"
			+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
			+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
			+ "select  ?albumName ?album_cover ?albumPopularity (AVG(xsd:double(?spichness)) as ?avg_spichness)  \n"
			+ "where { \n"
			+ "#    3. Which popular rap album from an artist has the higher average of \"Speechiness/Energy/Liveness\" among its songs? \n"
			+ "    ?album rdf:type ex:Album.\n"
			+ "    ?album ex:cover ?album_cover.\n"
			+ "    ?album ex:albumRelease ?albumRelease.\n"
			+ "    ?albumRelease ex:artistRelease ?artist.\n"
			+ "    ?album ex:popularity ?albumPopularity.\n"
			+ "    ?artist ex:genre ?artistgenre.\n"
			+ "    filter( contains(?artistgenre, \"rap\")). \n"
			+ "    ?album ex:name ?albumName.\n"
			+ "    ?album ex:containsAcousticFeatures ?features.\n"
			+ "    ?features ex:speechiness ?spichness.\n"
			+ "    ?features ex:energy ?energy.\n"
			+ "    ?features ex:liveness ?liveness.\n"
			+ "} group by ?albumName ?album_cover ?albumPopularity ORDER BY DESC(?avg_spichness) limit 100";
	
	public static final String [] QUERY_3_HEADERS = {"Album", "Album Art", "Album Popularity", "Spichness"};
	
	

	public static final String QUERY_4_TEXT = "Which band has the greatest number of popular albums in the last 30 years?";	
	public static final String QUERY_4 = "#PREFIX ex: <http://xmlns.com/foaf/0.1/>\n"
			+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
			+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
			+ "PREFIX ex: <http://www.semanticweb.org/ontologies/music#>\n"
			+ "\n"
			+ "select ?artist_name ?artist_img ?maxx\n"
			+ "where\n"
			+ "{\n"
			+ "	?artist ex:name ?artist_name.\n"
			+ "	?artist ex:img ?artist_img.\n"
			+ "    {\n"
			+ "    select ?artist (count(?album) as ?maxx)\n"
			+ "    where { \n"
			+ "\n"
			+ "        ?album rdf:type ex:Album.\n"
			+ "        ?album ex:albumRelease ?albumRelease.\n"
			+ "        ?album ex:cover ?album_cover.\n"
			+ "        ?album ex:popularity ?albumpop.\n"
			+ "        ?albumRelease ex:artistRelease ?artist.\n"
			+ "\n"
			+ "        ?artist ex:name ?artistName.\n"
			+ "            ?artist ex:artist_type ?artistType.\n"
			+ "            filter(?artistType=\"band\")\n"
			+ "        filter(?albumpop > \"80\").\n"
			+ "    } GROUP BY ?artist ORDER BY DESC(?maxx)\n"
			+ "    limit 1\n"
			+ "    }\n"
			+ "}";
	public static final String [] QUERY_4_HEADERS = {"Band Name", "Band Image", "No of Popular Albums"};
	
	
	
	public static final String QUERY_5_TEXT = "Which is their most popular live song (liveness)?";	
	public static final String QUERY_5 = "#PREFIX ex: <http://xmlns.com/foaf/0.1/>\n"
			+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
			+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
			+ "PREFIX ex: <http://www.semanticweb.org/ontologies/music#>\n"
			+ "\n"
			+ "select ?artistName ?album_cover ?songname ?liveness ?songPop\n"
			+ "{\n"
			+ "    ?artist ex:name ?artistName.\n"			
			+ "    ?album ex:isComposedBy ?songs.\n"
			+ "    ?album ex:cover ?album_cover.\n"			
			+ "    ?songs ex:name ?songname.\n"
			+ "    ?songs ex:hasFeatures ?features.\n"
			+ "    ?features ex:liveness ?liveness.\n"			
			+ "    ?songs ex:popularity ?songPop.\n"
			+ "    ?album ex:albumRelease ?albumRelease.\n"
			+ "    ?albumRelease ex:artistRelease ?artist.\n"
			+ "    \n"
			+ "    {\n"
			+ "        select ?artist ?artist_name ?artist_img ?maxx\n"
			+ "        where\n"
			+ "        {\n"
			+ "            ?artist ex:name ?artist_name.\n"
			+ "            ?artist ex:img ?artist_img.\n"
			+ "            {\n"
			+ "            select ?artist (count(?album) as ?maxx)\n"
			+ "            where { \n"
			+ "\n"
			+ "                ?album rdf:type ex:Album.\n"
			+ "                ?album ex:albumRelease ?albumRelease.\n"
			+ "                ?album ex:cover ?album_cover.\n"
			+ "                ?album ex:popularity ?albumpop.\n"
			+ "                ?albumRelease ex:artistRelease ?artist.\n"
			+ "\n"
			+ "                ?artist ex:name ?artistName.\n"
			+ "                    ?artist ex:artist_type ?artistType.\n"
			+ "                    filter(?artistType=\"band\")\n"
			+ "                filter(?albumpop > \"80\").\n"
			+ "            } GROUP BY ?artist ORDER BY DESC(?maxx)\n"
			+ "            limit 1\n"
			+ "            }\n"
			+ "        }\n"
			+ "    }\n"
			+ "}ORDER BY DESC(?liveness) limit 1";
	
	public static final String [] QUERY_5_HEADERS = {"Band Name", "Album Cover", "Song", "Liveness", "Popularity"};
	
	
	
	public static final String QUERY_6_TEXT = "Who is the artist of the album which has the highest valued happiness in 2015 (valance)?";	
	public static final String QUERY_6 = "PREFIX : <http://www.semanticweb.org/ontologies/music#>\n"
			+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
			+ "select (AVG(xsd:double(?valence)) as ?avg_val) ?albumName ?album_cover ?artistName ?release_date where {\n"
			+ "    {\n"
			+ "        select ?valence ?albumName ?album_cover ?songName ?artistName ?release_date where {\n"
			+ "            ?artist a :Artist.\n"
			+ "            ?album a :Album.\n"
			+ "            ?aco a :AcousticFeatures.\n"
			+ "            ?release a :Release.\n"
			+ "            ?aco :valence ?valence.\n"
			+ "            ?album :containsAcousticFeatures ?aco.\n"
			+ "            ?artist :artistRelease ?release.\n"
			+ "            ?album :name ?albumName.\n"
			+ " 			?album :cover ?album_cover.\n"
			+ "            ?artist :name ?artistName.\n"
			+ "            ?album :albumRelease ?release.\n"
			+ "            ?release :release_date ?release_date.\n"
			+ "            FILTER CONTAINS(?release_date,\"2015\")\n"
			+ "        } GROUP BY ?albumName ?album_cover ?valence ?songName ?artistName ?release_date\n"
			+ "    }\n"
			+ "} GROUP BY ?albumName ?album_cover ?artistName ?release_date ORDER BY DESC(?avg_val)";
	
	public static final String [] QUERY_6_HEADERS = {"Album Name", "Album Cover", "Artist Name", "Release Date", "Average of Happiness Factor (Valence)"};
	
	
	
	public static final String QUERY_7_TEXT = "How many songs released in 2018 that are danceable became popular?";		
	public static final String QUERY_7 = "PREFIX : <http://www.semanticweb.org/ontologies/music#>\n"
			+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
			+ "select ?songName ?dance ?release_date where{\n"
			+ "    \n"
			+ "    ?song_pop a :SongPopularity.\n"
			+ "    ?song a :Song.\n"
			+ "    ?aco a :AcousticFeatures.\n"
			+ "    \n"
			+ "    ?song_pop :hasSong ?song.\n"
			+ "    ?song :hasFeatures ?aco.\n"
			+ "    ?song :name ?songName.\n"
			+ "    ?song_pop :popular \"True\".\n"
			+ "    ?aco :danceability ?dance.\n"
			+ "    \n"
			+ "    ?song :release_date ?release_date.\n"
			+ "    FILTER CONTAINS(?release_date,\"2018\").\n"
			+ "    \n"
			+ "    FILTER(xsd:double(?dance) > 0.7).\n"
			+ "}";
	
	public static final String [] QUERY_7_HEADERS = {"Song Name", "Danceable Factor", "Release Date"};
	
	
	
	public static final String QUERY_8_TEXT = "What is the average value of temp of the 20 most popular electro genre songs?";		
	public static final String QUERY_8 = "PREFIX : <http://www.semanticweb.org/ontologies/music#>\n"
			+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
			+ "select (AVG(xsd:double(?tempo)) as ?avg_temp) where{\n"
			+ "    {\n"
			+ "        select ?tempo where {\n"
			+ "            ?artist a :Artist.\n"
			+ "            ?release a :Release.\n"
			+ "            ?album a :Album.\n"
			+ "            ?song a :Song.\n"
			+ "            ?artist :artistRelease ?release.\n"
			+ "            ?release :albumRelease ?album.\n"
			+ "            ?album :isComposedBy ?song.\n"
			+ "            ?song :tempo ?tempo.\n"
			+ "            ?artist :genre ?genre.\n"
			+ "            ?artist :name ?artistName.\n"
			+ "            ?song :release_date ?release_date.\n"
			+ "            ?song :popularity ?song_popularity.\n"
			+ "            FILTER CONTAINS(?genre,\"electro\").\n"
			+ "        } ORDER BY DESC(?song_popularity) LIMIT 20\n"
			+ "    }\n"
			+ "}";
	
	public static final String [] QUERY_8_HEADERS = {"Average Tempo"};
	
	
	public static final String QUERY_9_TEXT = "Which are the 5 most popular albums with high value of energy?";		
	public static final String QUERY_9 = "PREFIX : <http://www.semanticweb.org/ontologies/music#>\n"
			+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
			+ "select ?albumName ?album_cover ?avg_energy ?popularity where {\n"
			+ "    {\n"
			+ "        select ?albumName ?album_cover ?popularity (AVG(xsd:double(?energy)) as ?avg_energy) where{\n"
			+ "            ?album a :Album.\n"
			+ "            ?aco a :AcousticFeatures.\n"
			+ "            ?album :containsAcousticFeatures ?aco.\n"
			+ "            ?album :name ?albumName.\n"
			+ "            ?album :cover ?album_cover.\n"
			+ "            ?aco :energy ?energy.\n"
			+ "            FILTER(xsd:double(?energy) > 0.5).\n"
			+ "            ?album :popularity ?popularity.\n"
			+ "        } GROUP BY ?albumName ?album_cover ?popularity ORDER BY DESC(?popularity) \n"
			+ "    }\n"
			+ "}ORDER BY DESC(?avg_energy) LIMIT 5";
	
	public static final String [] QUERY_9_HEADERS = {"Album Name", "Album Cover", "Popularity", "Average Energy"};
	
	
	public static final String QUERY_10_TEXT = "Who is the most popular artist that produced the higher number of sad songs (valence)?";		
	public static final String QUERY_10 = "#PREFIX ex: <http://xmlns.com/foaf/0.1/>\n"
			+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
			+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
			+ "PREFIX ex: <http://www.semanticweb.org/ontologies/music#>\n"
			+ "\n"
			+ "select ?artistname ?artist_img ?artistpop ?num_of_sadsongs\n"
			+ "where{\n"
			+ "    ?artist ex:name ?artistname.\n"
			+ "    ?artist ex:img ?artist_img.\n"
			+ "    ?artist ex:popularity ?artistpop.\n"
			+ "    {\n"
			+ "        select ?artist  (count(?songs) as ?num_of_sadsongs) \n"
			+ "        where { \n"
			+ "\n"
			+ "            ?album rdf:type ex:Album.\n"
			+ "            ?album ex:albumRelease ?albumRelease.\n"
			+ "            ?album ex:cover ?album_cover.\n"
			+ "            ?albumRelease ex:artistRelease ?artist.\n"
			+ "\n"
			+ "            ?album ex:isComposedBy ?songs.\n"
			+ "            ?songs ex:hasFeatures ?features.\n"
			+ "            ?features ex:valence ?valence.\n"
			+ "\n"
			+ "            filter(xsd:double(?valence) < 0.5)\n"
			+ "        } group by ?artist  ORDER BY DESC(?num_of_sadsongs) limit 1\n"
			+ "    }\n"
			+ "}";
	public static final String [] QUERY_10_HEADERS = {"Artist Name", "Artist Image", "Artist Popularity", "Number of Sad Songs"};
	
	public static final String OUTPUT_TTL_FILE = "/final_output.ttl";


}
