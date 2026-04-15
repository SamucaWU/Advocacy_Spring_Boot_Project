package github.io.advocacy.DTOs.scheduling;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum SchedulingStatus {
    AGENDADO,
    REALIZADO,
    CANCELADO;

    @JsonCreator
    public static SchedulingStatus fromString(String value) {
        return SchedulingStatus.valueOf(value.toUpperCase()); // To accept lowCase too
    }
}
