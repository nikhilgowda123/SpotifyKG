package com.kde.groupe.backend;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

import com.kde.groupe.constants.CommonConstants;

public class QueryProcessor {

	public static ArrayList<String[]> processQuery(String queryString) {
		InputStream finalTtlFile = QueryProcessor.class.getResourceAsStream(CommonConstants.OUTPUT_TTL_FILE);
		Model model = ModelFactory.createDefaultModel();
		model.read(finalTtlFile, null,CommonConstants.TTL_EXTENSION);
		Query query = QueryFactory.create(queryString);
		QueryExecution queryExecution = QueryExecutionFactory.create(query, model);
		ResultSet results = queryExecution.execSelect();
		ArrayList<String[]> temp3 = new ArrayList<String[]>();
		while (results.hasNext()) {
			QuerySolution soln = results.nextSolution();
			List<String> tempValues = new ArrayList<String>();
			Iterator<String> variableNames = soln.varNames();
			while (variableNames.hasNext()) {
				tempValues.add(soln.get(variableNames.next()).toString());

			}
			temp3.add(tempValues.stream().toArray(String[]::new));
		}
		return temp3;

	}

}
