import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pleas enter filename:");
        String filename = scanner.nextLine();
        try {
            FileWriterS(filename + '\n', "ŚcieżkiPlików.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader br = null;
        boolean isFile = true;
        try{
            File f = new File(filename);
            FileReader Fr = new FileReader(f);
            br = new BufferedReader(Fr);
        }catch(FileNotFoundException e)
        {
            isFile = false;
            System.out.println("File doesn't exist");
        }
        String text = new String();
        while (isFile) {
                scanner.next().charAt(0);
                boolean flag = false;
                try{
                    flag = ReadNextChars(br);
                }catch(IOException e)
                {
                    e.printStackTrace();
                }
                if(flag == false)
                {
                    System.out.println("Koniec pliku");
                    break;
                }
        }
    }

    public static void FileWriterS(String text, String filename) throws IOException {
        FileWriter File = null;
        try {
            File = new FileWriter(filename,true);
            File.write(text);
        } finally {
            if (File != null)
                File.close();
        }
    }

    public static boolean  ReadNextChars(BufferedReader br) throws IOException{
        Random r = new Random();
        int count = r.nextInt((5 - 1) + 1) + 1;
        String result = new String();
        int c = 0;
        try{
            while (count > 0 &&  (c = br.read()) != -1) {
                result = result + (char)c;
                count--;
            }
        }catch(IOException e)
        {
            throw new IOException();
        }
        if(c == -1)
            return false;
        System.out.println(result);
        return true;
    }

    public static String FileReaderS(String filename) throws IOException {
        Scanner scanner = null;
        String result = new String();
        try {
            FileReader F = new FileReader(filename);
            scanner = new Scanner(F);
            while (scanner.hasNextLine()) {
                result = result + scanner.nextLine() + "\n";
            }
        } catch (FileNotFoundException e) {
            throw e;
        } finally {
            if (scanner != null) {
                scanner.close();
            }
            return result;
        }

    }
}
