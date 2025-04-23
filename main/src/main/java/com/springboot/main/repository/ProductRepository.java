package com.springboot.main.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.model.Product;


@Repository
public class ProductRepository {
    private final List<Product> products = new ArrayList<>();
    public ProductRepository(){
        products.add(new Product(1, "laptop", "Technologie", 1000.0, 10));
        products.add(new Product(2, "mouse", "Technologie", 20.0, 100));
        products.add(new Product(3, "monitor", "Technologie", 200.0, 50));
        products.add(new Product(4, "keyboard", "Technologie", 30.0, 75));
        products.add(new Product(5, "printer", "Technologie", 150.0, 20));
        products.add(new Product(6, "tablet", "Technologie", 300.0, 30));
        products.add(new Product(7, "smartphone", "Technologie", 500.0, 40));
        products.add(new Product(8, "headphones", "Tecnologie", 80.0, 60));
        products.add(new Product(9, "webcam", "Tecnologie", 50.0, 25));
        products.add(new Product(10, "microphone", "Tecnologie", 70.0, 15));
        products.add(new Product(11, "smartwatch", "Tecnologie", 250.0, 35));
        products.add(new Product(12, "speaker", "Tecnologie", 120.0, 45));
        products.add(new Product(13, "router", "Tecnologie", 90.0, 55));
        products.add(new Product(14, "external hard drive", "Tecnologie", 100.0, 20));
        products.add(new Product(15, "USB flash drive", "Tecnologie", 15.0, 80));
        products.add(new Product(16, "graphics card", "Tecnologie", 400.0, 10));
        products.add(new Product(17, "motherboard", "Tecnologie", 250.0, 5));
        products.add(new Product(18, "processor", "Tecnologie", 300.0, 8));
        products.add(new Product(19, "RAM", "Tecnologie", 100.0, 12));
        products.add(new Product(20, "power supply", "Tecnologie", 80.0, 18));
    }
    public List<Product> findAll() { return products; }

    @RestController
    @RequestMapping("/api")
    public class ProductController {
        private final ProductRepository repo;
        public ProductController(ProductRepository repo) { 
            this.repo = repo; 
        }

        @GetMapping("/products")
        public List<Product> getProducts(
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) String category
        ) {            
            return repo.findAll().stream()
            .filter(p -> minPrice == null || p.getPrice() >= minPrice);
        }
    }
}
