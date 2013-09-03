package appfactory.utils;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: liweinan
 * Date: 13-9-3
 * Time: PM9:04
 * To change this template use File | Settings | File Templates.
 */
public class FileUploadUtils {

    public static String generateUUIDFileNameAndSaveFile(MultipartFile file, String uploadDir) throws IOException {

        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String fileName = null;

        if (file.getOriginalFilename().contains(".")) {

            String fileExtension = file.getOriginalFilename().split("\\.")[1];

            fileName = uuid + "." + fileExtension;
        } else {
            fileName = uuid;
        }

        FileUtils.copyInputStreamToFile(file.getInputStream(), new File(uploadDir, fileName));

        return fileName;
    }

}
