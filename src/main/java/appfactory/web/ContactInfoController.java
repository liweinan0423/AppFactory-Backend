package appfactory.web;

import appfactory.model.ContactInfo;
import appfactory.repositories.ContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liweinan
 * Date: 13-8-25
 * Time: PM6:24
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("contact_info")
public class ContactInfoController {

    @Autowired
    private ContactInfoRepository contactInfoRepository;

    @RequestMapping
    public String listContactInfo(Model model) {
        List<ContactInfo> contactInfoList = contactInfoRepository.findAll();

        model.addAttribute("contactInfoList", contactInfoList);

        return "/contact_info/list";
    }

    @RequestMapping("new")
    public String showCreateContactInfoForm(Model model) {
        model.addAttribute(new ContactInfo());

        return "/contact_info/new";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@Valid ContactInfo contactInfo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/contact_info/new";
        }

        contactInfoRepository.save(contactInfo);

        return "redirect:/contact_info";
    }

    @RequestMapping("{id}/edit")
    public String showEditContactInfoForm(@PathVariable("id") Long id, Model model) {

        ContactInfo contactInfo = contactInfoRepository.findOne(id);

        model.addAttribute(contactInfo);

        return "/contact_info/edit";

    }

    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public String updateContactInfo(@PathVariable("id") Long id, @Valid ContactInfo contactInfo, BindingResult result) {
        if (result.hasErrors()) {
            return "/contact_info/edit";
        }

        ContactInfo old = contactInfoRepository.findOne(id);
        old.setPhoneName(contactInfo.getPhoneName());
        old.setPhoneNumber(contactInfo.getPhoneNumber());

        contactInfoRepository.save(old);

        return "redirect:/contact_info";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public String deleteContactInfo(@PathVariable("id") Long id) {
        contactInfoRepository.delete(id);

        return "redirect:/contact_info";
    }

}
