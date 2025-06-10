import java.util.ArrayList;
import java.util.List;

public class WindowsFileSystem implements FileSystem {
    public void createFile(String path, String data) {
        System.out.println("Windows create file");
    }
    public void mkdir(String path) {
        System.out.println("Windows create file");
    }
    public void delete(String path) {
        System.out.println("Windows create file");
    }
    public void move(String src, String dest) {
        System.out.println("Windows create file");
    }
    public void copy(String src, String dest) {
        System.out.println("Windows create file");
    }
    public void writeFile(String path, String content) {
        System.out.println("Windows create file");
    }
    public File getFile(String path) {
        System.out.println("Windows create file");
        return new File("file");
    }
    public List<String> ls(String path) {
        System.out.println("Windows create file");
        return new ArrayList<>();
    }

    public String readContent(String path) {
        System.out.println("Windows create file");
        return "";
    }
}
