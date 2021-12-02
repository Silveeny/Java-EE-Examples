package lab7.beans;

import com.sun.tools.javac.util.Pair;
import lab7.entities.Document;
import lab7.services.authentication.AuthenticationService;
import lab7.services.document.DocumentService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean(name = "document")
@RequestScoped
public class DocumentView {

    @Inject
    DocumentService documentService;

    @Inject
    AuthenticationService authenticationService;

    private List<Pair<String, String>> docs;

    @PostConstruct
    public void setStuff() {
        if (authenticationService.canViewDocs()) {
            docs = documentService.getSimplifiedAll();
        }
    }

    public DocumentView() {
        System.out.println("test");
    }

    public DocumentService getDocumentService() {
        return documentService;
    }

    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }

    public List<Pair<String, String>> getDocs() {
        return docs;
    }

    public void setDocs(List<Pair<String, String>> docs) {
        this.docs = docs;
    }
    // check for user rank - set the docs variable -
    public void submit() {
        System.out.println("test");
        if (authenticationService.canViewDocs()) {
            docs = documentService.getSimplifiedAll();
        }
    }

}
