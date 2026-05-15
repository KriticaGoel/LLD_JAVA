package project.docEditor.followSOLID;

public class DocumentEditor {
    Document document;

    public DocumentEditor(Document document) {
        this.document = document;
    }

    public void addTextElement(String text) {
        document.addElement(new TextElement(text));
    }

    public void addImageElement(String text) {
        document.addElement(new ImageElement(text));
    }

    public void addNewLineELement() {
        document.addElement(new NewLineElement());
    }
}
