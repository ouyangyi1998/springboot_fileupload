package com.jerry.springboot_fileupload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

@Controller
public class FileUploadController {
    @Value("${filepath}")
    private String filepath;

    @GetMapping("/upload")
    public String uploading()
    {
        return "uploading";
    }
    @PostMapping("/uploading")
    @ResponseBody
    public String uploading(@RequestParam("file")MultipartFile file)
    {
        try{
            uploadFile(file.getBytes(),filepath,file.getOriginalFilename());
        }catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("文件上传失败");
            return "uploading failure";
        }
        System.out.println("文件上传成功");
        return "uploading success";
    }
    public void uploadFile(byte[] file,String filePath,String fileName)throws Exception
    {
        File targetFile=new File(filePath);
        if(!targetFile.exists())
        {
            targetFile.mkdir();
        }
        FileOutputStream out=new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
