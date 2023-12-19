import java.io.IOException;
import java.sql.SQLException;

public class MyClass {
    public static void methodForMyException() throws MyException{
        throw new MyException();
    }

    public static void randomException() throws IOException, SQLException, RuntimeException{
        int result = (int) (Math.random() * 10 / 4);
        if(result == 0) throw new IOException();
        if(result == 1) throw new RuntimeException();
        if(result == 2) throw new SQLException();
    }
}
