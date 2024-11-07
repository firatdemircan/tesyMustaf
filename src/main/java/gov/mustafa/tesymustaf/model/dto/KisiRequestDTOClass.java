package gov.mustafa.tesymustaf.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KisiRequestDTOClass {
    private String kisiAdi;
    private String kisiSoyadi;
    private Integer kisiYas;
    private String unvan;
}
