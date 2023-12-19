import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws MyException {

        //Объявите ссылочную переменную со значением null.
        // Вызовите метод у этой переменной.
        // Отловить возникшее исключение c помощью блока try-catch

        String s = null;

        try {
            s.toUpperCase();
        }catch (NullPointerException e){
            System.out.println(e);
        }

        //Написать код, который создаст,
        //а затем отловит ArrayIndexOutOfBoundsException

        int [] array = {1,2,3};

        try {
            for(int i = 0; i <= array.length; i++){
                System.out.println(array[i]);
            };
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }

        //Создать собственный класс-исключение - наследник класса Exception.
        // Создать метод, выбрасывающий это исключение.
        // Вызвать этот метод и отловить исключение. Вывести stack trace в консоль.

        try {
            MyClass.methodForMyException();
        }catch (MyException e){
            e.printStackTrace();
        }

        //Бросить одно из существующих в JDK исключений,
        // отловить его и оберните его в свое кастомное
        // исключение указав в качестве причины отловленное.


        try {
            throw new ArrayIndexOutOfBoundsException();
        }catch (ArrayIndexOutOfBoundsException e){
            var original =  new MyException();
            original.initCause(e);
        }

        //Создать метод случайным образом выбрасывающий одно из 3-х видов исключений.
        // Вызвать этот метод в блоке try-catch, отлавливающим любое из 3-х.

        try {
            MyClass.randomException();
        }catch (RuntimeException | SQLException | IOException e){
            System.out.println(e);
        }
    }
}
