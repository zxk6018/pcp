package com.hz.dao;

import com.hz.pojo.Certificate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CertificateDao {

//根据id查找图片路径和图片信息
     List<Certificate>certificateList(
             @Param( "pyl" )Integer pyl,

             @Param( "pageSize" )Integer pageSize,
             //证书id
             @Param( "certId" )Integer certId,
             //宠物id
             @Param("certPetId" )Integer certPetId
    );
    /**
     * 总记录数
     * @return
     */
    Integer certificateCount(@Param("certId") Integer certId,
                       @Param("certPetId") Integer certPetId);

    //新增宠物id
    Integer saveCertificate(Certificate certificate );

    /**
     * 查看证书具体信息
     * @param certificate
     * @return
     */
    Integer seeCertificate(Certificate certificate );
    //获取宠物ID
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
