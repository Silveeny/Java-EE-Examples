package lab7.repository;

import lab7.entities.Document;

import java.util.List;

public interface DocumentRepository {

    void save(Document document);

    Document get(String code);

    List<Document> getAll();

}
