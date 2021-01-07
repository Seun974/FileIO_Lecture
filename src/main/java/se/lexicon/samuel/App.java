package se.lexicon.samuel;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        //with the BufferedWriter  BufferedReader = chars/Strings and (not reading with bytes)
        //writing to a file
        //reading from the created file!

        List<String> content = Arrays.asList(
                "Hello", "World", "added"
        );
        //we want this to be saved as a text folder (as text) (folder name: message)
        //creating a new file where it will be stored
        //create a directory and in the directory ie text, then create a file i.e message.txt

        File file = new File("text/message.txt");

        //writing a method that will read the file and content. it overrides whatever is in the file and...
        //...prints the new items in the file
        write(file, content);
        for (String message : read(file)){
            System.out.println(message);
        }

    }

    private static List<String> write(File file, List<String> content) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            for(String messageToWrite: content){
                writer.write(messageToWrite);
                writer.newLine();
            }
            writer.flush();

        }catch (IOException ex){
            ex.printStackTrace();
        }

        return content;
    }
    private static List<String> read(File file){
        List<String> message = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while((line = reader.readLine()) != null){
                message.add(line);
            }

        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }

        return message;
    }

}

