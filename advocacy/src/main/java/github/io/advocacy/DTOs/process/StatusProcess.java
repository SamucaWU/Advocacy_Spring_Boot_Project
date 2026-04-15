package github.io.advocacy.DTOs.process;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum StatusProcess {
    EM_ANDAMENTO,
    CONCLUIDO,
    ARQUIVADO;

    @JsonCreator
    public static StatusProcess fromString(String value) {
        return StatusProcess.valueOf(value.toUpperCase()); // To accept lowCase too
    }
}
