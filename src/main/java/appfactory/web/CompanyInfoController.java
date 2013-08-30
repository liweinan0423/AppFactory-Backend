package appfactory.web;

import appfactory.model.CompanyInfo;
import appfactory.repositories.CompanyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
public class CompanyInfoController {

    @Autowired
    private CompanyInfoRepository companyInfoRepository;

    @RequestMapping("/company_info/edit")
    public String editCompanyInfo(Model model) {
        CompanyInfo companyInfo = companyInfoRepository.findCompanyInfo();
        model.addAttribute(companyInfo);

        return "/company_info/edit";
    }

    @RequestMapping("/company_info")
    public String showCompanyInfo(Model model) {
        CompanyInfo companyInfo = companyInfoRepository.findCompanyInfo();
        model.addAttribute(companyInfo);

        return "/company_info/show";
    }

    @RequestMapping(value = "/company_info", method = RequestMethod.PUT)
    public String editCompanyInf(@Valid CompanyInfo companyInfo, BindingResult result) {
        if (result.hasErrors()) {
            return "/company_info/edit";
        }

        CompanyInfo old = companyInfoRepository.findCompanyInfo();
        old.setContent(companyInfo.getContent());
        companyInfoRepository.save(old);

        return "redirect:/company_info/edit";
    }


}
