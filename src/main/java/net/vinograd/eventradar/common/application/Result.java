package net.vinograd.eventradar.common.application;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Result<E> {

    private final E entity;

    private final Error error;

    private final boolean isSuccess;


    public static <E> Result<E> success(E entity) {
        return new Result<>(entity, null, true);
    }

    public static <E> Result<E> success() {
        return success(null);
    }

    public static <E> Result<E> failure(Error error) {
        return new Result<>(null, error, false);
    }

    public boolean isFailure() {
        return !isSuccess;
    }

    public E getValue() {
        if (isFailure())
            throw new IllegalStateException("Result isn't successful, impossible to have a value");

        if (Objects.isNull(entity))
            throw new IllegalStateException("Empty success! There is no value");

        return entity;
    }

    public Error getError() {
        if (isSuccess)
            throw new IllegalStateException("Result is successful, impossible to have an error");

        return error;
    }

}
