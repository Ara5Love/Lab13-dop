package vyatsu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Card {
    int countCard;
    public List<Product> card = new ArrayList<>();

    @Autowired
    ProductService productService;

    public void Add(Product product) {
        card.add(product);
    }

    public void Add(String productTitle) {
        try {
            card.add(productService.findByTitle(productTitle));
        }catch (Exception e){
            throw new RuntimeException(productTitle + " такого товара не существует");
        }
    }


}
