package net.vinograd.eventradar.team.application.error;

import net.vinograd.eventradar.common.application.ApiError;
import net.vinograd.eventradar.common.application.Result;

public enum TeamError implements ApiError {

    NOT_FOUND,
    INACTIVE,
    NAME_OCCUPIED;

    public <T>Result<T> toResult() {
        return Result.failure(this);
    }

}
