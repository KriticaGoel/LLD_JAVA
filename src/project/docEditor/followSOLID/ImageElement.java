package project.docEditor.followSOLID;

public class ImageElement implements DocumentElement {
    private String image;
    public ImageElement(String image) {
        this.image = image;
    }
    @Override
    public String render() {
        return "Image ["+ image+"]";
    }
}
