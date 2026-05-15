package project.docEditor.initialDesign;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DocEditor {
    private List<String> data = new ArrayList<>();
    static void main(String[] args) {
        DocEditor docEditor = new DocEditor();
        docEditor.addText("This is a sample document.");
        docEditor.addText("Next line");
        docEditor.addImage("ubuntu/image/abc.jpg");
        docEditor.addImage("ubuntu/image/nextImage.png");
        docEditor.addText("End of document.");
        try {
            docEditor.saveToFile();
        }catch (IOException e){
            System.out.println("file not found "+e.getMessage());
        }
    }



    private void addText(String text) {
        data.add(text);
    }
    private void addImage(String image) {
        data.add(image);
    }
    private String renderDocument(){
        StringBuilder renderDocument = new StringBuilder();

        for(String row : data){
            if(row!=null && row.length()>0  && (row.endsWith(".jpg") || row.endsWith(".jpeg") || row.endsWith(".png"))){
                renderDocument.append("Image path is "+ row +"\n");
            }
            else{
                renderDocument.append(row +"\n");
            }
        }
        return renderDocument.toString();
    }

    private void saveToFile() throws IOException {
        Path path = Path.of("test.txt");
        if(Files.exists(path)){
            Files.delete(path);
        }
        Files.createFile(path);
        Files.writeString(path, renderDocument());


    }
}
