package com.hz.controller;

import com.hz.pojo.Certificate;
import com.hz.service.CertificateService;
import com.hz.utils.JsonMassage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
        @RequestMapping("/certificate")
public class CertificateController {
@Autowired
    private CertificateService CertificateService;

//新增
@RequestMapping(value = "/saveCertificate",method = RequestMethod.POST)
@ResponseBody
    public JsonMassage saveCertificate( Certificate certificate ){
    Integer i = CertificateService.saveCertificate( certificate );
    return new JsonMassage(i);
}

    /**
     * 分页查询
     * @param page  当前页
     * @param limit 每页显示条数
     * @return
     */
    @RequestMapping(value = "/findCertificateList",method = RequestMethod.GET)
    @ResponseBody
    public JsonMassage<List<Certificate>> findCertificateList( @RequestParam(value = "page",defaultValue = "1") Integer page,
                                                     @RequestParam(value = "limit",defaultValue ="10") Integer limit,
                                                     Integer certId, Integer certPetId){
        List<Certificate>list = CertificateService.findCertificateList( page, limit, certId, certPetId );
        Integer cout = CertificateService.certificateCount( certId,certPetId );
        JsonMassage<List<Certificate>>jsonMassage = new JsonMassage<List<Certificate>>(  );
        jsonMassage.setCode( 0 );
        jsonMassage.setMsg("请求成功");
        jsonMassage.setData( list );
        jsonMassage.setCount( cout );
        return jsonMassage;
}
    /**
     * 删除
     * @param certPetId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteCertificateById",method = RequestMethod.POST)
    public JsonMassage deleteAdminById(Integer certPetId){
        Integer i = CertificateService.deleteCertificateById(certPetId);
        return new JsonMassage(i);
    }
    /**
     * 修改
     * @param certificate
     * @return
     */
    @RequestMapping(value = "/updateCertificate",method = RequestMethod.POST)
    @ResponseBody
    public JsonMassage updateAdmin(Certificate certificate){
        Integer i = CertificateService.updateCertificate(certificate);
        return new JsonMassage(i);
    }
    /**
     * 查看管理员详情
     * @param certPetId
     * @param model
     * @return
     */

    @RequestMapping("/findCertificateById/{certPetId}")
    public String findCertificateById( @PathVariable("certPetId") Integer certPetId, Model model){
        System.out.println("id========="+certPetId);
        model.addAttribute("sd", CertificateService.findCertificateById(certPetId));
        return  "certificate/certificate_edit";
    }
    @RequestMapping(value = "/seeCertificate",method = RequestMethod.POST)
    @ResponseBody
    public String seeCertificate(Certificate certificate){
        Integer i = CertificateService.seeCertificate(certificate);
        return "";
    }
    @RequestMapping("/seefindCertificateById/{certPetId}")
    public String seefindCertificateById( @PathVariable("certPetId") Integer certPetId, Model model){
        System.out.println("id========="+certPetId);
        model.addAttribute("sdd", CertificateService.findCertificateById(certPetId));
        return  "certificate/certificate_see";
    }

}