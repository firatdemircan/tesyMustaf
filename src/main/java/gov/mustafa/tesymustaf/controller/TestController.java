package gov.mustafa.tesymustaf.controller;

import gov.mustafa.tesymustaf.model.dto.KisiRequestDTOClass;
import gov.mustafa.tesymustaf.model.dto.KisiRequestDTORecord;
import gov.mustafa.tesymustaf.model.dto.KisiRequestUpdateRecord;
import gov.mustafa.tesymustaf.service.KisiService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    private final KisiService kisiService;

    public TestController(KisiService kisiService) {
        this.kisiService = kisiService;
    }

    @GetMapping
    public String xx() {
        return "Nasılsın";
    }

    @GetMapping("getname/{ad}")
    public String getName(@PathVariable String ad) {
        System.out.println(ad);
        if (ad.equals("Fırat")) {
            return "DEMİRCAN";
        } else if (ad.trim().equals("Mustafa")) {
            return "ERKARA";
        }

        return "Kişi Bulunamadı";
    }

    @GetMapping("getname")
    public String getNamea() {

        return "Kişi Bulunamadı";
    }


    @PostMapping("kisi/{ad}/{soyadi}/{yas}/{unvan}")
    public String kisi(@PathVariable String ad, @PathVariable String soyadi, @PathVariable Integer yas, @PathVariable String unvan) {
        kisiService.save(ad, soyadi, yas, unvan);

        return "Kayıt İşlemi Başarılı";
    }

    @PostMapping("save")
    public String save(@RequestBody KisiRequestDTOClass kisiRequestDTOClass) {
        kisiService.save(kisiRequestDTOClass);

        return "Kayıt İşlemi Başarılı";

    }

    @PostMapping("saveList")
    public String saveList(@RequestBody List<KisiRequestDTOClass> kisiRequestDTOClass) {
        kisiService.saveList(kisiRequestDTOClass);

        return "Hepsini Kaydettim";
    }


    @PostMapping("saveRecord")
    public String saveRecord(@RequestBody KisiRequestDTORecord kisiRequestDTORecord) {
        kisiService.saveRecord(kisiRequestDTORecord);
        return "Recordla Kaydettim";
    }

    @PostMapping("saveRecordList")
    public String saveRecordList(@RequestBody List<KisiRequestDTORecord> kisiRequestDTORecords) {
        kisiService.saveRecordList(kisiRequestDTORecords);
        return "Hepsini Recordla Kaydettim";
    }


    @PostMapping("updateRecord")
    public String updateRecord(@RequestBody @Valid KisiRequestUpdateRecord updateRecord) {
        kisiService.update(updateRecord);
        return "Güncelleme Başarılı";
    }



}
