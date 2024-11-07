package gov.mustafa.tesymustaf.model.dto;

import jakarta.validation.constraints.*;

public record KisiRequestUpdateRecord (Long id, @Size(max = 30,min = 10) String ad, @NotNull @Max(99) @Min(18) String soyad, @Positive Integer yas, String unvan){
}
