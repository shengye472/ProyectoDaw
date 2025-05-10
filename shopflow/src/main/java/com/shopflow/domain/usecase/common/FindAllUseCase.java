package com.shopflow.domain.usecase.common;


import java.util.List;

public interface FindAllUseCase<T> {
    List<T> findAll();
}
