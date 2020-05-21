package abstractClassAndInterface;

import java.util.Objects;

/**
 * @Author: YHQ
 * @Date: 2019/11/9 21:03
 */
public class employee implements Comparable<employee>{
    private int sales;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        employee employee = (employee) o;
        return sales == employee.sales &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sales, name);
    }

    public employee(int sales, String name) {
        this.sales = sales;
        this.name = name;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(employee o) {
        int x = this.sales;
        int y = o.getSales();
        return Integer.compare(x,y);
    }
}
