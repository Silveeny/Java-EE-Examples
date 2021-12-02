Lab 7 CDI
=========

Point 1:
--------
* Implemented an app that allows users to login, create account and upload and view documents
* I created a login page for authenticating users, the business and domain login behind this functionality consists of the
  - an entity for the user (username, password, id and rank)
  - an authentication service that deals with business logic behind authentication (logging in the user, checking the rank and if it is authenticated)
  - a `LoginCache` bean which is application scoped and stores a list with all the authenticated usernames
  - a `CurrentUser` bean which is session scoped and stores the logged-in user for this session, this is used later in the app, for example for verifying the rank
* Then, I created a page for uploading documents:
  - we store documents as byte arrays in the entity class (we use blob type in the database)
  - any type of document on length up to `100 000` bytes can be uploaded
  - I created a `TimeframeService` which check if the upload time is in between some hardcoded boundaries
* A page for viewing the documents:
  - for simplicity (and speed), here we only display to the view layer only the name and the generated code
* The creation of new users is handled by a unit test `JPAUserRepositoryImplTest`

Point 2:
--------
* I used the `@Inject` annotation pretty much everywhere in the code to have the context inject our dependencies for us
  - For example in `DocumentUploadView` we inject a `DocumentService` (which is `ApplicationScoped` for speed concerns)
* I used `@Produces` as showcased in the course slides in the `DocumentService` bean to trigger a logging event whenever a document is uploaded
* I used the `@Interceptor` as showcased in the course slides in `utils.interceptor.LoggedInterceptor` tto create a logg Interceptor
* I used `@Decorator` to create a decorator for `Timeframe` which at each method call in `TimeframeService` loggs the time of the method call
* I used `@Observes` in `DocumentUploadView` to handle the event triggered in the `DocumentService` which basically loggs to the server logs the document that just been uploaded
