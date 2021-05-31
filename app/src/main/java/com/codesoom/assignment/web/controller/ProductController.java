package com.codesoom.assignment.web.controller;

import com.codesoom.assignment.core.application.ProductService;
import com.codesoom.assignment.core.domain.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 고양이 장난감 물품에 대한 Request 처리하여 Response를 반환합니다.
 */
@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * 모든 고양이 장난감 목록을 반환합니다.
     * @return 고양이 장난감 목록
     */
    @GetMapping
    public List<Product> products() {
        return productService.fetchProducts();
    }

    /**
     * 새로운 고양이 장난감을 등록합니다.
     * @param product
     * @return 생성된 고양이 장난감
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    /**
     * 요청 ID에 해당하는 고양이 장난감을 반환한다.
     * @param id
     * @return 해당 고양이 장난감
     */
    @GetMapping("{id}")
    public Product product(@PathVariable Long id) {
        return productService.fetchProductById(id);
    }

    /**
     * 요청 ID에 해당하는 고양이 장난감을 삭제한다.
     * @param id
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
    }

    /**
     * 요청 ID에 해당하는 고양이 장난감을 수정하고, 수정된 장난감을 반환한다.
     * @param id
     * @param product
     * @return 갱신된 고양이 장난감
     */
    @PatchMapping("{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProductById(id, product);
    }
}