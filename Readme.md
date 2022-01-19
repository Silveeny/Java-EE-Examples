Overview for Wade&Java
=========

There are 2 microservice:
- **brain** that performs various SPARQL queries on the ontology exposed by apache jena fuseki server on the endpoint `localhost:3030/test`
 and exposes thee results obtained by running these queries to various JAX-RS endpoints
- **wingman-core** that exposes a vanilla js web uit (written using bootstrap, jquery and plain html/css3) that performs AJAX calls to wingman.
wingman receives the AJAX calls froom the vanilla js client and calls the appropiate endpoint exposed by brain in order to fetch the desired data
and returns a JSON with the output to the client.

Both microservices run using payara-micro in docker containeers.

Next Steps
===========
* the search functionality is still work in progress
* I plan to add a container with memcached in order to cache common queris in brain, saving compute time (basically I will add a Kafka queue to which I push every query and a background job will reead from thee topic and createe the appropiate memchached entry)
