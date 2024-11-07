package gov.mustafa.tesymustaf.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KisiEntity {

    public KisiEntity(String ad,String soyad,Integer yas,String unvan) {
        this.ad = ad;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ad;
    private String soyad;
    private Integer yas;
    private String unvan;


}
