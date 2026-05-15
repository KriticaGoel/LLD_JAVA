package project.docEditor.followSOLID;

import java.util.ArrayList;
import java.util.List;

public class Document {

    private List<DocumentElement> documentElements = new ArrayList<>();

    public void addElement(DocumentElement element) {
        documentElements.add(element);
    }

    public List<DocumentElement> getDocumentElements() {
        return documentElements;
    }


}
