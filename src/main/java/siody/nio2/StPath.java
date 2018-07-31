package siody.nio2;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class StPath {
    public static void main(String[] args) {
        Path path = Paths.get("E:\\Desktop");
        System.out.println("file name: "+path.getFileName());
        System.out.println("file name count: "+path.getNameCount());
        System.out.println("parent directory: "+path.getParent());
        System.out.println("System root: "+path.getRoot());
        // File file = path.toFile();
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(path, "*.jpg")){
            for (Path p:paths){
                System.out.println("file name: "+p.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>(){
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (file.toString().endsWith(".jpg")) {
                        System.out.println(file.getFileName());
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
