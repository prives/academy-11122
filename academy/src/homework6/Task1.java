package homework6;

import java.io.*;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) throws IOException {
        File dir = new File("src/io/");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File newFile = new File("src\\io\\file.txt");
        if (!newFile.exists()) {
            newFile.createNewFile();
        }
//        Scanner scan = new Scanner(System.in);
//
//        System.out.println("Please enter some Strings. If you want to stop, please enter - STOP.");
//        while (true) {
//            String input = scan.nextLine();
//            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFile))) {
//                bufferedWriter.write(input);
//                bufferedWriter.newLine();
//            } catch (IOException e) {
//                System.out.print(e.getMessage());
//            }
//            if (input.equals("STOP"))
//                break;
//
//        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(newFile))) {
                String line;
                System.out.println("Please enter some Strings. If you want to stop, please enter - STOP.");
                while (!(line = reader.readLine()).equals("STOP")) {
                    writer.write(line);
                    writer.newLine();
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(new FileReader(newFile));
        for (String line; (line = br.readLine()) != null; ) {
            System.out.println(line);
            
        }
    }
}
