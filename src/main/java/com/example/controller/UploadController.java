package com.example.controller;

import com.example.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
        log.info("文件上传：{}, {}, {}", username, age, image);
        // 获取原始文件名
        String originalFilename = image.getOriginalFilename();
        // 构造唯一的文件名（不能重复） - uuid（通用唯一标识符）
        int index = originalFilename.lastIndexOf(".");
        String extname = originalFilename.substring(index);
        String newFileName = UUID.randomUUID().toString() + extname;
        log.info("新的文件名：{}", newFileName);

        // 将文件存储在服务器的磁盘目录中
        image.transferTo(new File("E:\\image\\" + newFileName));

        return Result.success();
    }
}
