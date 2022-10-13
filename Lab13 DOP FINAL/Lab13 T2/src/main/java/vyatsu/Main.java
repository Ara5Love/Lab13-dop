package vyatsu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderServices order = context.getBean("orderServices", OrderServices.class);
        ProductService productService = context.getBean("productService", ProductService.class);

        System.out.println("Товары");
        productService.printAll();

        System.out.println("\nКорзина");
        Card card = context.getBean("card", Card.class);
        card.Add("Товар 2");
        card.Add("Товар 4");
        card.Add("Товар 8");
        order.createOrder();

        System.out.println("\nБыстрая покупка");
        order.fastOrder(
                productService.findByTitle("Товар 1"),
                productService.findByTitle("Товар 2")
        );


        ((AnnotationConfigApplicationContext) context).close();

    }
}
