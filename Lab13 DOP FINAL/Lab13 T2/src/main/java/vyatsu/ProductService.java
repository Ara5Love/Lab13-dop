package vyatsu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
@Component
public class ProductService {
    private List<Product> productList;

    @PostConstruct
    public void init()
    {
        productList = new ArrayList<>();
        Random Cost = new Random();
        for(int i = 0;i < 10;i++)
        {
            productList.add(new Product(i,"Товар "+i,Cost.nextInt(300 - 100) + 100));
        }
    }
    public Product getProduct(int x){
        return productList.get(x);
    }


    public void printAll()
    {
        for(Product x : productList)
        {
            System.out.println(x.info());
        }
    }

    public Product findByTitle(String title)
    {
        for(Product x : productList)
        {
            if(x.getTitle().equals(title))
            {
                return getProduct(x.getId());
            }
        }
        return null;
    }


}
