package gov.mustafa.tesymustaf.service;

import gov.mustafa.tesymustaf.model.dto.KisiRequestDTOClass;
import gov.mustafa.tesymustaf.model.dto.KisiRequestDTORecord;
import gov.mustafa.tesymustaf.model.entity.KisiEntity;
import gov.mustafa.tesymustaf.repository.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KisiServiceImpl implements KisiService {

    private final KisiRepository kisiRepository;

    @Override
    public void save(String ad, String soyad, Integer yas, String unvan) {
        KisiEntity kisiEntity = new KisiEntity();
        kisiEntity.setAd(ad);
        kisiEntity.setSoyad(soyad);
        kisiEntity.setYas(yas);
        kisiEntity.setUnvan(unvan);
        kisiRepository.save(kisiEntity);
    }

    @Override
    public void save(KisiRequestDTOClass kisiRequestDTOClass) {


        KisiEntity kisiEntity = new KisiEntity();
        kisiEntity.setAd(kisiRequestDTOClass.getKisiAdi());
        kisiEntity.setSoyad(kisiRequestDTOClass.getKisiSoyadi());
        kisiEntity.setYas(kisiRequestDTOClass.getKisiYas());
        kisiEntity.setUnvan(kisiRequestDTOClass.getUnvan());
        kisiRepository.save(kisiEntity);

        //KisiEntity kisiEntity1 = new KisiEntity(kisiRequestDTOClass.getKisiAdi(), kisiRequestDTOClass.getKisiSoyadi(), kisiRequestDTOClass.getKisiYas(), kisiRequestDTOClass.getUnvan());
        //kisiRepository.save(kisiEntity1);

    }

    @Override
    public void saveList(List<KisiRequestDTOClass> kisiRequestDTOClass) {
        List<KisiEntity> kisiEntityList = new ArrayList<>();
        for (KisiRequestDTOClass requestDTOClass : kisiRequestDTOClass) {
            KisiEntity kisiEntity = new KisiEntity();
            kisiEntity.setAd(requestDTOClass.getKisiAdi());
            kisiEntity.setSoyad(requestDTOClass.getKisiSoyadi());
            kisiEntity.setYas(requestDTOClass.getKisiYas());
            kisiEntity.setUnvan(requestDTOClass.getUnvan());
            kisiEntityList.add(kisiEntity);
        }
        //List<KisiEntity> kisiEntities = kisiRequestDTOClass.stream().map(a -> new KisiEntity(a.getKisiAdi(), a.getKisiSoyadi(), a.getKisiYas(), a.getUnvan())).toList();

        kisiRepository.saveAll(kisiEntityList);

    }

    @Override
    public void saveRecord(KisiRequestDTORecord kisiRequestDTORecord) {
        //KisiEntity kisiEntity = new KisiEntity(kisiRequestDTORecord.ad(),kisiRequestDTORecord.soyad(),kisiRequestDTORecord.yas(),kisiRequestDTORecord.unvan());
        //kisiRepository.save(kisiEntity);

        KisiEntity kisiEntity = new KisiEntity();
        kisiEntity.setAd(kisiRequestDTORecord.ad());
        kisiEntity.setSoyad(kisiRequestDTORecord.soyad());
        kisiEntity.setYas(kisiRequestDTORecord.yas());
        kisiEntity.setUnvan(kisiRequestDTORecord.unvan());

        kisiRepository.save(kisiEntity);
    }
}
