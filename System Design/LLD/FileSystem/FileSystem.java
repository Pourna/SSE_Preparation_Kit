import java.util.List;

public interface FileSystem {
    void createFile(String path, String data);
    void mkdir(String path);
    void delete(String path);
    void move(String src, String dest);
    void copy(String src, String dest);
    void writeFile(String path, String content);
    String readContent(String path);
    File getFile(String path);
    List<String> ls(String path);
}
