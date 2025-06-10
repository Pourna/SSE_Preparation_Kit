public class FileSystemDemo {
    public static void main(String[] args) {
        FileSystem fs = FileSystemFactory.getFileSystem();
        fs.mkdir("/a/b/c");
        fs.createFile("/a/b/c/file.txt", "Hello World!");
        System.out.println("File Content::" +fs.readContent("/a/b/c/file.txt"));
        System.out.println("List content from the given directory::" + fs.ls("/a/b/c"));
        fs.move("/a/b/c/file.txt", "/a/b/file.txt");
        System.out.println("List content from the given directory after file move:" + fs.ls("/a/b/"));
        fs.copy( "/a/b/file.txt", "/a/b/c/fileCopied.txt");
        System.out.println("List content from the given directory after file copied:" + fs.ls("/a/b/c"));
        fs.delete( "/a/b/c/fileCopied.txt");
        System.out.println("List content from the given directory after file copied:" + fs.ls("/a/b/c"));
    }
}
