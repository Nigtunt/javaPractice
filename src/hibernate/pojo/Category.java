package hibernate.pojo;

import java.util.Set;

/**
 * @Author: YHQ
 * @Date: 2020/1/8 11:45
 */
public class Category {
    private int id;
    private String name;
    private Set<Product> products;

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

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

}
