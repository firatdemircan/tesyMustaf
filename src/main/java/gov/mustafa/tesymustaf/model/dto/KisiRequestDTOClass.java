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
    private String ad;
    private String soyad;
    private Integer yas;
    private String unvan;
}
