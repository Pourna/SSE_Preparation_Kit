public class FileSystemFactory {
    public static FileSystem getFileSystem() {
        String os = System.getProperty("os.name").toLowerCase();
        if(os.startsWith("win")) {
            return new WindowsFileSystem();
        } else {
            return new LinuxFileSystem();
        }
    }
}
