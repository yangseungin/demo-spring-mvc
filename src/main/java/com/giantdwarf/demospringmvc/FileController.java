package com.giantdwarf.demospringmvc;

import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@Controller
public class FileController {

    @Autowired
    private ResourceLoader resourceLoader;

    @GetMapping("/files")
    public String fileUploadForm(Model model) {
        return "files/index";
    }

    @PostMapping("/files")
    public String fileUpload(@RequestParam MultipartFile file,
                             RedirectAttributes attributes) {
        //save됬다고 가정

        String message = file.getOriginalFilename() + " is uploaded";
        attributes.addFlashAttribute("message", message);
        return "redirect:/files";
    }

    @GetMapping("/files/{filename}")
    @ResponseBody
    public ResponseEntity<Resource> fileDownload(@PathVariable String filename) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:" + filename);
        File file = resource.getFile();

        Tika tika = new Tika();
        String mediaType = tika.detect(file);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\""+ resource.getFilename() +"\"")
                .header(HttpHeaders.CONTENT_TYPE,mediaType)
                .header(HttpHeaders.CONTENT_LENGTH, file.length()+"")
                .body(resource);
    }
}
