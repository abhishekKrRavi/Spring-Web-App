package com.SpringProject.SpringProjectProduct.repo;

import com.SpringProject.SpringProjectProduct.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query("SELECT p from Product p where lower(p.name) like lower(concat('%', :keyword, '%')) or "+
            "lower(p.decription) like lower(concat('%', :keyword, '%')) or " +
            "lower(p.category) like lower(concat('%', :keyword, '%')) or " +
            "lower(p.brand) like lower(concat('%', :keyword, '%'))")
    List<Product> searchProduct(String keyword);
}
