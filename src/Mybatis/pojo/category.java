package Mybatis.pojo;

import java.util.List;

/**
 * @Author: YHQ
 * @Date: 2020/2/10 15:56
 */
public class category {
    private int id;
    private String name;
    private List<Product> products;

    @Override
    public String toString() {
        return "category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
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
