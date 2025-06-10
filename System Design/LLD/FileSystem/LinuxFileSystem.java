import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LinuxFileSystem implements FileSystem {
    Directory root;

    LinuxFileSystem() {
        this.root = new Directory("/");
    }

    public void mkdir(String path) {
        Directory curr = root;
        String[] parts = path.split("/");
        for(String part : parts) {
            if(part.isBlank()) continue;
            Node child = curr.children.get(part);
            if(child==null) {
                child = new Directory(part);
                child.parent = curr;
                curr.children.put(part, child);
            } else if (!child.isDirectory()) {
                throw new IllegalArgumentException("Not a directory but file exist in the given path");
            }
            curr = (Directory) curr.children.get(part);
        }
    }

    public void createFile(String filePath, String content) {
        int index = filePath.lastIndexOf("/");
        String dirPath = filePath.substring(0,index);
        String fileName = filePath.substring(index+1);
        mkdir(dirPath);
        Directory parent = traverseToDir(dirPath);
        if(parent.children.containsKey(filePath)) {
            throw new RuntimeException("File already exist");
        }
        File file = new File(fileName);
        file.writeContent(content);
        file.parent = parent;
        parent.children.put(fileName, file);
    }

    public Node traverse(String dirPath) {
        String[] parts = dirPath.split("/");
        Node curr = root;
        for (String part : parts) {
            if(part.isBlank()) continue;
            if(!curr.isDirectory()) throw new RuntimeException("Not a directory");
            curr = ((Directory) curr).children.get(part);
            if(curr==null) throw new RuntimeException("Path doesn't exist");
        }
        return curr;
    }

    public Directory traverseToDir(String path) {
        Node dir = traverse(path);
        if(!dir.isDirectory()) throw new RuntimeException("Not a directory");
        return (Directory) dir;
    }

    public File getFile(String path) {
        Node file = traverse(path);
        if(file.isDirectory()) throw new RuntimeException("Not a file");
        return (File) file;
    }

    public void writeFile(String path, String content) {
        File file = getFile(path);
        file.writeContent(content);
    }

    public String readContent(String path) {
        File file = getFile(path);
        return file.readContent();
    }

    public List<String> ls(String path) {
        Node node = traverse(path);
        if(!node.isDirectory()) {
            return Collections.singletonList(node.name);
        }
        List<String> res = new ArrayList<>(((Directory) node).children.keySet());
        Collections.sort(res);
        return res;
    }

    public void delete(String path) {
        Node node = traverse(path);
        Directory parent = node.parent;
        if(parent!=null) {
            parent.children.remove(node.name);
        }
    }

    public void move(String src, String dest) {
        Node node = traverse(src);
        delete(src);

        int index = dest.lastIndexOf("/");
        String dirName = dest.substring(0, index);
        String fileName = dest.substring(index+1);
        mkdir(dirName);
        Directory parent = traverseToDir(dirName);
        node.name = fileName;
        node.parent = parent;
        parent.children.put(fileName, node);
    }

    public void copy(String src, String dest) {
        File file = getFile(src);
        createFile(dest, file.readContent());
    }

}
