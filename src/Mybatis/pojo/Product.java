package Mybatis.pojo;

/**
 * @Author: YHQ
 * @Date: 2020/2/11 13:49
 */
public class Product {
    private int id;
    private String name;
    private float price;
    private category category;

    public category getCategory() {
        return category;
    }
    public void setCategory(category category) {
        this.category = category;
    }
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
