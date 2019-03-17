package com.zt.controller;

import com.zt.JsonUtils;
import com.zt.service.PictureService;
import com.zt.vo.ImageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PictureController {
    @Autowired
    private PictureService pictureService;
    @RequestMapping("/pic/upload")
    @ResponseBody
    public String upload(MultipartFile multipartFile){
        ImageResult imageResult = pictureService.uploadPic(multipartFile);
        String s = JsonUtils.objectToJson(imageResult);
        return s;
    }
}
