package lab7.beans;

import lab7.entities.Document;
import lab7.services.document.DocumentService;
import lab7.services.timeframe.TimeFrameService;
import lab7.services.timeframe.Timeframe;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import javax.enterprise.event.Observes;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
@ManagedBean(name = "documentUpload")
public class DocumentUploadView {

    @Inject
    DocumentService documentService;

    @Inject
    Timeframe timeFrameService;

    private UploadedFile file;
    // from lecture notes
    public void upload() {
        if (file != null && timeFrameService.isTimeToUpload()) {
            FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);

            documentService.upload(file.getContent(), file.getFileName());
        }
    }

    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }


    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public DocumentService getDocumentService() {
        return documentService;
    }

    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }

    public void onAnyDocumentEvent(@Observes Document doc) {
        System.out.println("Document ");
        System.out.println(doc);
        System.out.println("uploaded");
    }
}