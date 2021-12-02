package lab7.services.document;

import com.sun.tools.javac.util.Pair;
import lab7.entities.Document;
import lab7.repository.DocumentRepository;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@SessionScoped
public class DocumentService implements Serializable {

    @Inject @Any
    Event<Document> documentEvent;

    @Inject
    DocumentRepository documentRepository;
    // The fire call triggers the event exactly as in the course slides
    public void upload(byte[] content, String name) {
        UUID code = UUID.randomUUID();

        Document document = new Document(code.toString(), name, content);
        documentEvent.fire(document);
        documentRepository.save(document);
    }

    public List<Pair<String, String>> getSimplifiedAll() {
        List<Document> documents = documentRepository.getAll();

        List<Pair<String, String>> simplifiedDocs = new ArrayList<>();

        for (Document document : documents) {
            simplifiedDocs.add(new Pair<>(document.getName(), document.getCode()));
        }

        return simplifiedDocs;
    }

}
