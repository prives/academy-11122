package homework6;

import java.io.*;

public class Task2 {
    public static void main(String[] args) throws IOException {
        File dir = new File("src/io/");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File newFile = new File("src\\io\\task2.txt");
        if (!newFile.exists()) {
            newFile.createNewFile();
        }
//        String textWithSpaces = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFile))) {
            bufferedWriter.write("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");

        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
        String textWithoutSpaces=null;
        try (BufferedReader reader = new BufferedReader(new FileReader(newFile))) {
            textWithoutSpaces = reader.readLine().replaceAll("\\s", "");
        } catch (IOException e) {
            e.printStackTrace();
        }

        File newFile2 = new File("src\\io\\result.txt");
        if (!newFile2.exists()) {
            newFile2.createNewFile();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(newFile2))) {
            bw.write(textWithoutSpaces);

        } catch (IOException e) {
            System.out.print(e.getMessage());
        }

        BufferedReader br = new BufferedReader(new FileReader(newFile2));
        for (String line; (line = br.readLine()) != null; ) {
            System.out.println(line);
        }
    }
}
