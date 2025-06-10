public class File extends Node {
    StringBuilder content;

    File(String name) {
        this.name = name;
        this.createdAt = System.currentTimeMillis();
        this.modifiedAt = this.createdAt;
        this.content = new StringBuilder();
    }

    @Override
    boolean isDirectory() {
        return false;
    }

    public void writeContent(String data) {
        this.content.append(data);
    }
    
    public String readContent() {
        return content.toString();
    }
}


