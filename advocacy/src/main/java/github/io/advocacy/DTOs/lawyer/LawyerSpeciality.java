package github.io.advocacy.DTOs.lawyer;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum LawyerSpeciality {
    CIVIL,
    PENAL,
    TRABALHISTA;

    @JsonCreator
    public static LawyerSpeciality fromString(String value) {
        return LawyerSpeciality.valueOf(value.toUpperCase()); // To accept lowCase too
    }
}
