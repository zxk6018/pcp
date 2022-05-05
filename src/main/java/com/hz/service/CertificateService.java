package com.hz.service;

import com.hz.pojo.Certificate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CertificateService {
    //新增宠物id
    Integer saveCertificate(Certificate certificate );


    List<Certificate>certificateList(

            @Param( "pyl" )Integer pyl,

            @Param( "pageSize" )Integer pageSize,
            //证书id
            @Param( "certId" )Integer certId,
            //宠物id
            @Param("certPetId" )Integer certPetId
    );
    Integer certificateCount(Integer certId ,Integer certPetId);

    /**
     * 查看证书具体信息
     * @param certificate
     * @return
     */
    Integer seeCertificate(Certificate certificate );
    //根据宠物id获取证书
    Certificate findCertificateById(Integer certPetId);
    /**
     * 删除
     * @param certPetId
     * @return
     */
    Integer deleteCertificateById(Integer certPetId);
    /**
     * 修改
     * @param certificate
     * @return
     */
    Integer updateCertificate(Certificate certificate);


}
