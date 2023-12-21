import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File file = new File("src\\text.txt");
        File file2 = new File("src\\numbers.txt");
        File file3 = new File("src\\Person.java");
        File file4 = new File("src\\PersonCopy.java");
        File file5 = new File("src\\PersonCopyReverse.java");

        //Задан файл с текстом, найти и вывести в консоль все слова, начинающиеся с гласной буквы

        try(Scanner scanner = new Scanner(file)){
            while (scanner.hasNext()){
                String s = scanner.next();
                boolean test = s.matches("^(?ui:[аеёиоуыэюя]).*");
                if(test) System.out.print(s + " ");
            }
        }catch (FileNotFoundException e){
            System.out.print(e);
        }
        System.out.println();

        //Задан файл с текстом, найти и вывести в консоль все слова,
        // для которых последняя буква одного слова совпадает с первой буквой следующего слова

        List <String> words = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)){
            while (scanner.hasNext()){
                words.add(scanner.next());
            }
        }catch (FileNotFoundException e){
            System.out.println(e);
        }

        if(!words.isEmpty()){
            for(int i = 0; i < words.size()-1; i++){
                String firstWord = words.get(i);
                String secondWord = words.get(i+1);
                char lastLetter = firstWord.charAt(firstWord.length()-1);
                char firstLetter = secondWord.charAt(0);
                if(lastLetter == firstLetter) System.out.print(firstWord + " ");
            }
        }
        System.out.println();

        //Задан файл с текстом. В каждой строке найти и вывести наибольшее число цифр, идущих подряд.

        try(Scanner scanner = new Scanner(file2)) {
            while (scanner.hasNextLine()){
                String [] splitnumbers = scanner.nextLine().split(" ");
                int maxLen = 0;

                for(int i = 0; i < splitnumbers.length; i++){
                    if(splitnumbers[i].length() > maxLen){
                        maxLen = splitnumbers[i].length();
                    }
                }
                System.out.print(maxLen + " ");
            }
        }catch (FileNotFoundException e){
            System.out.println(e);
        }

        System.out.println();

        //Задан файл с java-кодом. Прочитать текст программы из
        // файла и все слова public в объявлении атрибутов и методов класса заменить на слово private.
        // Результат сохранить в другой заранее созданный файл.

        ArrayList<String> person = new ArrayList<>();
        try(Scanner scanner = new Scanner(file3)){
            while (scanner.hasNextLine()){
                String check = scanner.nextLine();
                if(check.contains("public")){
                    check =check.replace("public", "private");
                }
                person.add(check);
            }
        }catch (FileNotFoundException e){
            System.out.println(e);
        }

        try(FileWriter fw = new FileWriter(file4)){
            for(String s : person){
                fw.write(s + "\n");
            }

        }catch (IOException e){
            System.out.println(e);
        }


        //Задан файл с java-кодом. Прочитать текст программы из файла
        // и записать в другой файл в обратном порядке символы каждой строки

        ArrayList<StringBuilder> reversedText = new ArrayList<>();
        StringBuilder personReverse = null;

        try(Scanner scanner = new Scanner(file3)){
            while (scanner.hasNextLine()){
                personReverse = new StringBuilder(scanner.nextLine());
                personReverse = personReverse.reverse();
                reversedText.add(personReverse);

            }
        }catch (FileNotFoundException e){
            System.out.println(e);
        }

        try(FileWriter fw = new FileWriter(file5)){
            for(StringBuilder s : reversedText){
                fw.write(s + "\n");
            }

        }catch (IOException e){
            System.out.println(e);
        }

    }
}
