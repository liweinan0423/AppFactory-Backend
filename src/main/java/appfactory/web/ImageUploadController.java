package appfactory.web;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

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

    @RequestMapping
    public String upload(MultipartFile upload, HttpServletRequest request, Model model) throws IOException {

        String uploadDirPath = request.getSession().getServletContext().getRealPath("/upload");

        String fileExtension = upload.getOriginalFilename().split("\\.")[1];

        String uuid = UUID.randomUUID().toString().replaceAll("-", "");

        String fileName = uuid + "." + fileExtension;

        String fileUrl = request.getContextPath() + "/upload/" + fileName;

        FileUtils.copyInputStreamToFile(upload.getInputStream(), new File(uploadDirPath, fileName));

        model.addAttribute("fileUrl", fileUrl);

        return "/images/upload";
    }

}
