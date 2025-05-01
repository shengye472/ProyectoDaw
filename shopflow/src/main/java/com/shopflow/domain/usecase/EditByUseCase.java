package com.shopflow.domain.usecase;

public interface EditByUseCase<T> {
    void editBy(String data, T body);
}
