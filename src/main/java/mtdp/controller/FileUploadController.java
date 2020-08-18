package mtdp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 测试文件上传
 *
 * @author wangte
 * @date created at 2018/5/13
 */
@Controller
public class FileUploadController {

    @PostMapping(value = "/upload")
    public String handlerFileUpload(@RequestParam(value = "file") MultipartFile file, RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
        return "redirect:uploadStatus";
    }

    @GetMapping("/to_upload")
    public String toUpload() {
        return "upload";
    }


}
