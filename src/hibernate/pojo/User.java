package hibernate.pojo;

import java.util.Set;

/**
 * @Author: YHQ
 * @Date: 2020/1/8 12:43
 */
public class User {
    private int id;
    private String name;
    private Set<Product> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
