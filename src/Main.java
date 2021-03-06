
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;


public class Main {
    void copyFileUsingJava7Files(File source, File dest){

    }
    void copyFileUsingJavaStream(File source, File dest) {

    }
    private static void copyFileUsingJava7File(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
    private static void copyFileUsingStream(File source, File dest) throws  IOException{
        try (InputStream is = new FileInputStream(source); OutputStream os = new FileOutputStream(dest)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter source file: ");
        String sourcePath = scanner.nextLine();
        System.out.println("Enter Destination File: ");
        String destPath = scanner.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        try {
            //copyFileUsingJava7File(sourceFile, destFile);
            copyFileUsingStream(sourceFile,destFile);
        } catch (IOException e) {
            System.out.println("Can not copy that file");
            System.out.println(e.getMessage());
        }
    }
}
