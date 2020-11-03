package com.biz.controller;

import com.alibaba.fastjson.JSONObject;
import com.biz.dto.AppResult;
import com.biz.entity.FileRecord;
import com.biz.service.FileService;
import com.biz.utils.FastDFSUtil;
import com.biz.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@RestController
@Controller
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @Autowired
    private IdWorker idWorker;


    @RequestMapping("/page")
    public String files() {
        return "file/files";
    }

    @RequestMapping("/toUpload")
    public String toUpload() {
        return "file/upload";
    }

    @PostMapping("/uploadFile")
    @ResponseBody
    public AppResult uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request, Model model) throws IOException {


        System.out.println("文件名: " + file.getOriginalFilename());//获取文件名

        //获取文件对应的字节数组
        byte[] buffFile = file.getBytes();
        //获取文件名
        String fileName = file.getOriginalFilename();
        Long fileSize = file.getSize();
        String fileType = file.getContentType();
        //可能会出现问题因为有些文件可能没有扩展名，因此必要时需要做逻辑控制
        String fileExtName = fileName.substring(fileName.lastIndexOf(".") + 1);
        String[] result = FastDFSUtil.upload(buffFile, fileExtName);

        System.out.println("上传结果：" + JSONObject.toJSONString(result));

        FileRecord record = new FileRecord();

        record.setId(String.valueOf(idWorker.nextId()));
        record.setFileSize(fileSize);
        record.setFileType(fileType);
        record.setOldFileName(fileName);
        record.setGroupName(result[0]);
        record.setFileName(result[1]);

        boolean saveResult = fileService.saveFileRecord(record);

        if(saveResult) {
            return AppResult.SUCCESS;
        }else {
            return AppResult.FAIL;
        }

//        model.addAttribute("message","文件上传成功，点击确定返回列表页面！");
//        model.addAttribute("url","/");

    }


    /**
     * @param files
     * @param request
     * @param model
     * @return
     * @throws IOException
     * @desc 多文件上传 - 批量上传文件
     */
    @PostMapping("/uploadFiles")
    public String uploadFiles (@RequestParam("file") MultipartFile[] files, HttpServletRequest request, Model model) throws IOException {
//        System.out.println(myFile.getBytes());//获取文件对应字节数组
//        System.out.println(myFile.getInputStream());//获取文件对应的输入流
//        System.out.println(myFile.getContentType());//获取文件类型
//        System.out.println(myFile.getName());//获取表单元素名
//        System.out.println(myFile.getOriginalFilename());//获取文件名
//        System.out.println(myFile.getSize());//获取文件大小
//        System.out.println(myFile.isEmpty());//判断文件是否为空 如果没有上传文件或文件大小为0 这个值都是true

        System.out.println(files[0].getOriginalFilename());//获取文件名


        String finalResult = null;


        for (MultipartFile file : files) {

            //获取文件对应的字节数组
            byte[] buffFile = file.getBytes();
            //获取文件名
            String fileName = file.getOriginalFilename();
            Long fileSize = file.getSize();
            String fileType = file.getContentType();
            //可能会出现问题因为有些文件可能没有扩展名，因此必要时需要做逻辑控制
            String fileExtName = fileName.substring(fileName.lastIndexOf(".") + 1);

            String[] result = FastDFSUtil.upload(buffFile, fileExtName);

            assert result != null;
            if (result[0] != null && result[1] != null) {

                // new_group_name, remote_filename
                System.out.println("group_name：" + result[0]);
                System.out.println("remote_filename：" + result[1]);
            }

            finalResult = result[1];

        }
        /**
         * 保存上传成功后返回的文件存储信息
         */
/*
        CreditorInfo creditorInfo = new CreditorInfo();
        creditorInfo.setId(id);
        creditorInfo.setFileSize(fileSize);
        creditorInfo.setFileType(fileType);
        creditorInfo.setOldFilename(fileName);
        creditorInfo.setGroupName(result[0]);
        creditorInfo.setRemoteFilePath(result[1]);

        creditorService.updateFileInfo(creditorInfo);
        */
        model.addAttribute("message", "文件上传成功[" + finalResult + "]，点击确定返回列表页面！");
        model.addAttribute("url", "/");
        return "success";
    }


}
