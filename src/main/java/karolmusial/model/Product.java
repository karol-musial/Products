package karolmusial.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private int id;

    @NotBlank(message = "Product name must not be empty")
    private String name;

    @NotNull(message = "Please enter id")
    private int price;

    @NotNull(message = "Please enter expiration date")
    private LocalDateTime expirationDate;

    private LocalDateTime createdOn;
    private String description;

    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory category;

    public Product() {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void updateFrom(Product source) {
          name = source.name;
          price = source.price;
          expirationDate = source.expirationDate;
          description = source.description;
    }

    @PrePersist
    void prePersist() {
        createdOn = LocalDateTime.now();
    }

//    drop table if exists products;
//    create table products(
//            id int primary key auto_increment;
//            productName varchar(100) not null;
//    price int not null;
//    description varchar(100);
//    expirationDate varchar(100) not null;
//
//)

}
