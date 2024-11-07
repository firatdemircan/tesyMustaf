package gov.mustafa.tesymustaf.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import gov.mustafa.tesymustaf.model.dto.KisiRequestDTOClass;
import gov.mustafa.tesymustaf.model.dto.KisiRequestDTORecord;
import gov.mustafa.tesymustaf.model.dto.KisiRequestUpdateRecord;
import gov.mustafa.tesymustaf.model.entity.KisiEntity;
import gov.mustafa.tesymustaf.repository.KisiRepository;
import gov.mustafa.tesymustaf.utils.TmoEntityNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KisiServiceImpl implements KisiService {


    private final KisiRepository kisiRepository;
    private final ProjectInfoAutoConfiguration projectInfoAutoConfiguration;

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
        // BeanUtils.copyProperties(kisiRequestDTOClass, kisiEntity);


        kisiEntity.setAd(kisiRequestDTOClass.getAd());
        kisiEntity.setSoyad(kisiRequestDTOClass.getSoyad());
        kisiEntity.setYas(kisiRequestDTOClass.getYas());
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
            kisiEntity.setAd(requestDTOClass.getAd());
            kisiEntity.setSoyad(requestDTOClass.getSoyad());
            kisiEntity.setYas(requestDTOClass.getYas());
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

    @Override
    public void saveRecordList(List<KisiRequestDTORecord> kisiRequestDTORecords) {
        List<KisiEntity> kisiEntityList = new ArrayList<>();

        for (KisiRequestDTORecord kisiRequestDTORecord : kisiRequestDTORecords) {
            KisiEntity kisiEntity = new KisiEntity();
            kisiEntity.setAd(kisiRequestDTORecord.ad());
            kisiEntity.setSoyad(kisiRequestDTORecord.soyad());
            kisiEntity.setYas(kisiRequestDTORecord.yas());
            kisiEntity.setUnvan(kisiRequestDTORecord.unvan());

            kisiEntityList.add(kisiEntity);
        }

        kisiRepository.saveAll(kisiEntityList);

    }

    @Override
    public void update(KisiRequestUpdateRecord updateRecord) {

        KisiEntity kisiEntity = kisiRepository.findById(updateRecord.id()).orElseThrow(() -> new TmoEntityNotFoundException(updateRecord.id() + " idli bir Kişi Yok Kardeş"));

        kisiEntity.setAd(updateRecord.ad());
        kisiEntity.setSoyad(updateRecord.soyad());
        kisiEntity.setYas(updateRecord.yas());
        kisiEntity.setUnvan(updateRecord.unvan());
        kisiRepository.save(kisiEntity);
        /*
        Optional<KisiEntity> byId = kisiRepository.findById(updateRecord.id());
        if(byId.isPresent()) {
            KisiEntity kisiEntity = byId.get();
            kisiEntity.setAd(updateRecord.ad());
            kisiEntity.setSoyad(updateRecord.soyad());
            kisiEntity.setYas(updateRecord.yas());
            kisiEntity.setUnvan(updateRecord.unvan());

            kisiRepository.save(kisiEntity);
        }
         */
    }

}
