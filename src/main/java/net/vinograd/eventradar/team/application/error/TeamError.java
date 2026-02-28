package net.vinograd.eventradar.team.application.error;

import net.vinograd.eventradar.common.application.Error;
import net.vinograd.eventradar.common.application.Result;

public enum TeamError implements Error {

    NOT_FOUND,
    INACTIVE,
    NAME_OCCUPIED;

    public <T>Result<T> toResult() {
        return Result.failure(this);
    }

}
