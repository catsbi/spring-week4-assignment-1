package com.codesoom.assignment.application;

import java.util.List;

/**
 * 장난감 관리 서비스를 제공하는 인터페이스이다.
 */
public interface ToyService <T>{

    List<T> findAll();

    T findById(Long id);

    T updateCatToy(Long id, T target);

    T save(T request);

    void deleteToy(Long id);
}