package project.docEditor.followSOLID;

public class Client {

    //this is orchestrator class
    static void main(String[] args) {

        PersistenceManager pm =  new FlatFilePersistence();
        DocumentEditor editor = new DocumentEditor(new Document());
        editor.addTextElement("Hello, I m Kritica");
        editor.addNewLineELement();
        editor.addTextElement("I m learning SOLID principles");
        editor.addNewLineELement();
        editor.addImageElement("abc.png");
        editor.addNewLineELement();
        editor.addTextElement("End of document");


        DocumentRender render = new DocumentRender(editor.document);

        pm.save(render.render());

    }
}
