package com.codesoom.assignment.application;

import java.util.List;

/**
 * 제품 관리 서비스를 제공하는 인터페이스이다.
 */
public interface ProductService<T> {

    List<T> findAll();

    T findById(long id);

    T updateProduct(long id, T target);

    T save(T request);

    void deleteProduct(T toy);
}