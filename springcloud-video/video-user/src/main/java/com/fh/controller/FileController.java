package com.fh.controller;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.fh.util.SystemConstant;
import com.fh.util.FTPUtils;
import com.fh.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
@Controller
public class FileController {

    /**
     * 图片文件上传
     */
    @RequestMapping( "/photoUpload")
    @ResponseBody
    public  Map photoUpload(MultipartFile file, HttpServletRequest request) throws Exception {
        Map map = new HashMap();
        if (file!=null) {// 判断上传的文件是否为空
            String fileName=file.getOriginalFilename();// 文件原名称
            //System.out.println("上传的文件原名称:"+fileName);
            InputStream inputStream = file.getInputStream();
            //获取相对的路径
            String realPath = request.getServletContext().getRealPath("/");
            String filePath = FileUtil.copyFile(inputStream, fileName, realPath + SystemConstant.UPLOAD_FILE_PATH);
            map.put("filePath", SystemConstant.UPLOAD_FILE_PATH+"/"+filePath);
            map.put("fileName", fileName);
        }
        return map;

    }


    @RequestMapping( "/photoUploadByFtp")
    @ResponseBody
    public  Map photoUploadByFtp(MultipartFile file, HttpServletRequest request) throws Exception {
        Map map = new HashMap();
        if (file!=null) {// 判断上传的文件是否为空
            String fileName=file.getOriginalFilename();// 文件原名称
            //System.out.println("上传的文件原名称:"+fileName);
            InputStream inputStream = file.getInputStream();
            FTPUtils ftpUtil = new FTPUtils();
            String filePath = ftpUtil.uploadFile("upload", fileName, inputStream);
            // String filePath = FileUtil.copyFile(inputStream, fileName, realPath + SystemConstant.UPLOAD_FILE_PATH);
            map.put("filePath", "upload/"+filePath);
            map.put("fileName", fileName);
        }
        return map;

    }


}
