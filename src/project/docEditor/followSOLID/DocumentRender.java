package project.docEditor.followSOLID;

import java.util.List;

public class DocumentRender {
    private String renderData = new String();
    Document document;
    public DocumentRender(Document document) {
        this.document = document;
    }

    public String render(){
        List<DocumentElement> documentElements = document.getDocumentElements();
        for(DocumentElement documentElement : documentElements){
            renderData=renderData+ documentElement.render();
        }
        return renderData;
    }
}
