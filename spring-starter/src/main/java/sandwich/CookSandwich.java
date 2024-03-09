package sandwich;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import sandwich.components.Cheese;
import sandwich.components.Ham;
import sandwich.components.Salami;
import sandwich.components.Sous;
import sandwich.products.Beef;
import sandwich.products.Milk;
import sandwich.products.Pork;
import sandwich.products.Tomato;
import sandwich.typesOfSandwiches.BMT;

public class CookSandwich {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        BMT bmt = context.getBean("bmt", BMT.class);
        BMT bmt2 = context.getBean("bmt", BMT.class);
        BMT bmt3 = context.getBean("bmt", BMT.class);
        BMT bmt4 = context.getBean("bmt", BMT.class);
    }
}
