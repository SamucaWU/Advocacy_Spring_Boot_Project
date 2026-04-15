package github.io.advocacy.DTOs.process;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TypeProcess {

    CIVIL,
    PENAL,
    TRABALHISTA,
    ADMINISTRATIVO;

    @JsonCreator
    public static TypeProcess fromString(String value) {
        return TypeProcess.valueOf(value.toUpperCase());
    }
}
