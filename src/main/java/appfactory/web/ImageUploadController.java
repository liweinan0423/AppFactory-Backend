package appfactory.web;

import appfactory.utils.FileUploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: liweinan
 * Date: 13-8-24
 * Time: PM8:31
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/images/upload", method = RequestMethod.POST)
public class ImageUploadController extends AbstractBaseController {


    @Autowired
    private ServletContext servletContext;


    @RequestMapping
    public String upload(MultipartFile upload, HttpServletRequest request, Model model) throws IOException {


        String fileName = FileUploadUtils.generateUUIDFileNameAndSaveFile(upload, servletContext.getRealPath("/upload"));

        model.addAttribute("fileUrl", "/upload/" + fileName);

        return "/images/upload";
    }

}
