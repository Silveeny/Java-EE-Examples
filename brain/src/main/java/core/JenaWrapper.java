package core;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.util.FileManager;

import java.util.ArrayList;
import java.util.List;

public class JenaWrapper {

    public static List<String> getAllCountries() {
        List<String> countries = new ArrayList<String>();

        FileManager.get().addLocatorClassLoader(JenaWrapper.class.getClassLoader());
		Model model = FileManager.get().loadModel("http://host.docker.internal:3030/test");
		Query query = QueryFactory.create("" +
		        "prefix owl: <http://www.w3.org/2002/07/owl#>\n" +
                "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "\n" +
                "SELECT DISTINCT  ?label \n" +
                "WHERE {\n" +
                "  ?class rdfs:subClassOf <http://www.semanticweb.org/wadeonto#Country> .\n" +
                "  ?class rdfs:label ?label\n" +
                "}\n");

		try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
            ResultSet results = qexec.execSelect() ;

            for ( ; results.hasNext() ; ) {
                QuerySolution soln = results.nextSolution() ;

                countries.add(soln.get("label").toString());
            }
        }

        return countries;
    }

    public static List<String> getAllIngredients() {
        List<String> ingredients = new ArrayList<String>();

        FileManager.get().addLocatorClassLoader(JenaWrapper.class.getClassLoader());
		Model model = FileManager.get().loadModel("http://host.docker.internal:3030/test");
		Query query = QueryFactory.create(
		        "prefix owl: <http://www.w3.org/2002/07/owl#>\n" +
                "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "\n" +
                "SELECT DISTINCT  ?label \n" +
                "WHERE {\n" +
                "  ?class rdfs:subClassOf <http://www.semanticweb.org/wadeonto#Ingredient> .\n" +
                "  ?class rdfs:label ?label\n" +
                "}\n");

		try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
            ResultSet results = qexec.execSelect() ;

            for ( ; results.hasNext() ; ) {
                QuerySolution soln = results.nextSolution() ;

                ingredients.add(soln.get("label").toString());
            }
        }

        return ingredients;
    }

    public static List<String> getAllRestrictions() {
        List<String> restrictions = new ArrayList<String>();

        FileManager.get().addLocatorClassLoader(JenaWrapper.class.getClassLoader());
		Model model = FileManager.get().loadModel("http://host.docker.internal:3030/test");
		Query query = QueryFactory.create("prefix owl: <http://www.w3.org/2002/07/owl#>\n" +
                "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "\n" +
                "SELECT DISTINCT  ?label \n" +
                "WHERE {\n" +
                "  ?class rdfs:subClassOf <http://www.semanticweb.org/wadeonto#Restriction> .\n" +
                "  ?class rdfs:label ?label\n" +
                "}");

		try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
            ResultSet results = qexec.execSelect() ;

            for ( ; results.hasNext() ; ) {
                QuerySolution soln = results.nextSolution() ;

                restrictions.add(soln.get("label").toString());
            }
        }

        return restrictions;

    }

    public static List<String> getAllEvents() {
        List<String> events = new ArrayList<String>();

        FileManager.get().addLocatorClassLoader(JenaWrapper.class.getClassLoader());
		Model model = FileManager.get().loadModel("http://host.docker.internal:3030/test");
		Query query = QueryFactory.create("prefix owl: <http://www.w3.org/2002/07/owl#>\n" +
                "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "\n" +
                "SELECT DISTINCT  ?label \n" +
                "WHERE {\n" +
                "  ?class rdfs:subClassOf <http://www.semanticweb.org/wadeonto#Events> .\n" +
                "  ?class rdfs:label ?label\n" +
                "}");

		try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
            ResultSet results = qexec.execSelect() ;

            for ( ; results.hasNext() ; ) {
                QuerySolution soln = results.nextSolution() ;

                events.add(soln.get("label").toString());
            }
        }

        return events;
    }

    public static List<String> getAllCarbonatedDrinks() {
        List<String> carbonatedDrinks = new ArrayList<String>();

        FileManager.get().addLocatorClassLoader(JenaWrapper.class.getClassLoader());
		Model model = FileManager.get().loadModel("http://host.docker.internal:3030/test");
		Query query = QueryFactory.create("PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "prefix owl: <http://www.w3.org/2002/07/owl#>\n" +
                "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "\n" +
                "SELECT DISTINCT  ?label\n" +
                "WHERE {\n" +
                "  ?class rdfs:subClassOf* <http://www.semanticweb.org/wadeonto#CarbonatedDrinks> .\n" +
                "  ?class rdfs:label ?label\n" +
                "}\n");

		try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
            ResultSet results = qexec.execSelect() ;

            for ( ; results.hasNext() ; ) {
                QuerySolution soln = results.nextSolution() ;

                carbonatedDrinks.add(soln.get("label").toString());
            }
        }

        return carbonatedDrinks;

    }

    public static List<String> getAllMocktails() {
        List<String> mocktails = new ArrayList<String>();

        FileManager.get().addLocatorClassLoader(JenaWrapper.class.getClassLoader());
        // cannot use simply localhost for docker, have to usee hostmachine localhost
        // https://stackoverflow.com/questions/24319662/from-inside-of-a-docker-container-how-do-i-connect-to-the-localhost-of-the-mach
		Model model = FileManager.get().loadModel("http://host.docker.internal:3030/test");
		Query query = QueryFactory.create("PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "prefix owl: <http://www.w3.org/2002/07/owl#>\n" +
                "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "\n" +
                "SELECT DISTINCT ?label\n" +
                "WHERE {\n" +
                "  ?class rdfs:subClassOf <http://www.semanticweb.org/wadeonto#Mocktail> .\n" +
                "  ?class rdfs:label ?label\n" +
                "}\n");

		try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
            ResultSet results = qexec.execSelect() ;

            for ( ; results.hasNext() ; ) {
                QuerySolution soln = results.nextSolution() ;

                mocktails.add(soln.get("label").toString());
            }
        }

        return mocktails;
    }

    public static List<String> getAllCoffees() {
        List<String> coffees = new ArrayList<String>();

        FileManager.get().addLocatorClassLoader(JenaWrapper.class.getClassLoader());
		Model model = FileManager.get().loadModel("http://host.docker.internal:3030/test");
		Query query = QueryFactory.create("PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "prefix owl: <http://www.w3.org/2002/07/owl#>\n" +
                "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "\n" +
                "SELECT DISTINCT ?label\n" +
                "WHERE {\n" +
                "  ?class rdfs:subClassOf <http://www.semanticweb.org/wadeonto#Coffee> .\n" +
                "  ?class rdfs:label ?label\n" +
                "}\n");

        try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
            ResultSet results = qexec.execSelect() ;

            for ( ; results.hasNext() ; ) {
                QuerySolution soln = results.nextSolution() ;

                coffees.add(soln.get("label").toString());
            }
        }

        return coffees;
    }

    public static List<String> getAllTeas() {
        List<String> teas = new ArrayList<String>();

        FileManager.get().addLocatorClassLoader(JenaWrapper.class.getClassLoader());
		Model model = FileManager.get().loadModel("http://host.docker.internal:3030/test");
		Query query = QueryFactory.create("PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "prefix owl: <http://www.w3.org/2002/07/owl#>\n" +
                "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "\n" +
                "SELECT DISTINCT ?label\n" +
                "WHERE {\n" +
                "  ?class rdfs:subClassOf <http://www.semanticweb.org/wadeonto#Tea> .\n" +
                "  ?class rdfs:label ?label\n" +
                "}\n");

        try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
            ResultSet results = qexec.execSelect() ;

            for ( ; results.hasNext() ; ) {
                QuerySolution soln = results.nextSolution() ;

                teas.add(soln.get("label").toString());
            }
        }

        return teas;
    }

    public static void search(String country, List<String> ingredients, List<String> restrictions, List<String> event) {


    }

    public static void main(String[] args) {
        List<String> countries = getAllCountries();
        List<String> ingredients = getAllIngredients();
        List<String> restrictions = getAllRestrictions();
        List<String> events = getAllEvents();
        List<String> carbonatedDrinks = getAllCarbonatedDrinks();
        List<String> mocktails = getAllMocktails();
        List<String> coffee = getAllCoffees();
        List<String> teas = getAllTeas();

        System.out.println(events);


        System.out.println(carbonatedDrinks);
        System.out.println(mocktails);
        System.out.println(coffee);
        System.out.println(teas);
    }

}
