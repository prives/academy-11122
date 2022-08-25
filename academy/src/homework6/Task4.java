package homework6;

import javax.swing.*;
import java.io.*;

public class Task4 {

    public static void main(String[] args) throws IOException {
        String text1 = null;
        File dir = new File("src/io/100files");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("src\\io\\task2.txt"))) {
            text1 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int count = text1.length();

        for (int i = 1; i <= 100; i++) {
            String fileName = i + ".txt";
            File newFile = new File(dir, fileName);
            if (!newFile.exists()) {
                newFile.createNewFile();
                String string = text1.substring(0, (int) (Math.random() * count));
                try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFile))) {
                    bufferedWriter.write(string);
                } catch (IOException e) {
                    System.out.print(e.getMessage());
                }
            }
            File newFileResul = new File("src\\io\\100files\\result.txt");
            try (BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(newFileResul))) {
                for (File e : dir.listFiles()) {
                    bufferedWriter2.write("File name: " + e.getName()+ " " + "File size: " + e.length()+ " bytes");
                    bufferedWriter2.newLine();

                }
            } catch (IOException e) {
                System.out.print(e.getMessage());
            }
        }
    }