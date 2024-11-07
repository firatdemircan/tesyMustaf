package gov.mustafa.tesymustaf.service;

import gov.mustafa.tesymustaf.model.dto.KisiRequestDTOClass;
import gov.mustafa.tesymustaf.model.dto.KisiRequestDTORecord;
import gov.mustafa.tesymustaf.model.dto.KisiRequestUpdateRecord;

import java.util.List;

public interface KisiService {

    void save(String ad,String soyad,Integer yas,String unvan);

    void save(KisiRequestDTOClass kisiRequestDTOClass);

    void saveList(List<KisiRequestDTOClass> kisiRequestDTOClass);

    void saveRecord(KisiRequestDTORecord kisiRequestDTORecord);

    void saveRecordList(List<KisiRequestDTORecord> kisiRequestDTORecords);

    void update(KisiRequestUpdateRecord updateRecord);
}
