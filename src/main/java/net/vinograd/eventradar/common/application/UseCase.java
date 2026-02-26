package net.vinograd.eventradar.common.application;

public interface UseCase<C, R> {

    Result<R> execute(C command);

}