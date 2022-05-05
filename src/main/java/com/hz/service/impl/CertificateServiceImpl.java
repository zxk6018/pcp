package com.hz.service.impl;



import com.hz.dao.CertificateDao;
import com.hz.pojo.Certificate;
import com.hz.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateServiceImpl implements CertificateService {
    @Autowired
        private CertificateDao certificate_dao;

    @Override
    public Integer saveCertificate( Certificate certificate ) {
        return certificate_dao.saveCertificate(certificate);
    }


    @Override
    public List<Certificate> findCertificateList( Integer pageNo, Integer pageSize, Integer certId, Integer certPetId ) {
        Integer pyl = (pageNo-1)*pageSize;

        return certificate_dao.findCertificateList( pyl,pageSize,certId,certPetId );
    }
    /**
     * 查看管理员具体信息
     * @param certId
     * @return
     */
    @Override
    public Integer certificateCount( Integer certId, Integer certPetId ) {
        return certificate_dao.certificateCount( certId,certPetId );
    }

    @Override
    public Integer seeCertificate( Certificate certificate ) {
        return certificate_dao.seeCertificate(certificate);
    }
    /**
     * 根据ID查找管理员
     * @param certPetId
     * @return
     */
    @Override
    public Certificate findCertificateById( Integer certPetId ) {
        return certificate_dao.findCertificateById(certPetId  );
    }
    /**
     * 根据ID删除管理员
     * @param certPetId
     * @return
     */
    @Override
    public Integer deleteCertificateById( Integer certPetId ) {
        return certificate_dao.deleteCertificateById( certPetId );
    }
    /**
     * 根据ID修改
     * @param certificate
     * @return
     */
    @Override
    public Integer updateCertificate( Certificate certificate ) {
        return certificate_dao.updateCertificate( certificate );
    }
}
