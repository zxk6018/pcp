package com.hz.service;

import com.hz.pojo.Certificate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CertificateService {
    //新增宠物id
    Integer saveCertificate(Certificate certificate );

    /**
     * 多条件 分页查询
     * @param pyl
     * @param pageSize
     * @param certId
     * @param certPetId
     * @return
     */
    List<Certificate>findCertificateList(
            Integer pyl,
            Integer pageSize,
            //证书id
            Integer certId,
            //宠物id
            Integer certPetId
    );
    Integer certificateCount(Integer certId ,Integer certPetId);

    /**
     * 查看证书具体信息
     * @param certificate
     * @return
     */
    Integer seeCertificate(Certificate certificate );

    /**
     * 根据宠物id获取证书
     */
    Certificate findCertificateById(Integer certPetId);

    /**
     * 删除证书
     * @param certPetId
     * @return
     */
    Integer deleteCertificateById(Integer certPetId);
    /**
     * 修改证书
     * @param certificate
     * @return
     */
    Integer updateCertificate(Certificate certificate);


}
