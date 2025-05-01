package com.shopflow.domain.usecase;


import java.util.List;

public interface FindAllUseCase<T> {
    List<T> findAll();
}
