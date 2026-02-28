package net.vinograd.eventradar.client.application.error;

import net.vinograd.eventradar.common.application.Error;
import net.vinograd.eventradar.common.application.Result;

public enum UserError implements Error {

    ALREADY_EXISTS,
    NOT_FOUND,
    INACTIVE;

    public <T> Result<T> toResult() {
        return Result.failure(this);
    }

}