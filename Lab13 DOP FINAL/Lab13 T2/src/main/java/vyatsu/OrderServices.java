package vyatsu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServices {

    @Autowired
    Card card;

    public void createOrder()
    {
        int Price = 0;
        System.out.println("Ваш заказ из корзины");
        for(Product x : card.card)
        {
            Price += x.getPrice();
            System.out.println(x.title);
        }
        System.out.println("Общая цена " + Price);
    }

    public void fastOrder(Product... products)
    {
        int cost = 0;
        for (Product product : products) {
            System.out.println(product);
            cost+=product.getPrice();
        }
        System.out.println("\nОбщая цена " + cost);
    }
}
