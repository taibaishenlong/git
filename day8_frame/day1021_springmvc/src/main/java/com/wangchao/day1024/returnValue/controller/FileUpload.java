package com.wangchao.day1024.returnValue.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/day1024/user")
public class FileUpload {
    //普通上传文件
    @RequestMapping(path = "/common_fileUpload")
    public String commonFileUploat(HttpServletRequest request) throws Exception {
        //先获取要上传的文件目录
        String path = request.getSession().getServletContext().getRealPath("/upload");
        System.out.println("path : "+path);
        //创建File对象，一会向该路径下上传文件
        File file = new File(path);
        System.out.println("file : "+file);
        //判断路径是否存在，如果不存在，创建该路径
        if (!file.exists()){
            file.mkdirs();
        }
        //创建磁盘文件项工厂
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
        //解析request对象
        List<FileItem> list = fileUpload.parseRequest(request);
        //遍历
        for (FileItem fileItem:list){
            //判断文件项是普通字段，还是上传的文件
            if(fileItem.isFormField()){

            }else{
                //上传文件
                //获取上传文件的名称
                String name = fileItem.getName();
                System.out.println("name : "+name);
                //上传文件
                fileItem.write(new File(file,name));
                //删除临时文件
                fileItem.delete();
                System.out.println("name : "+name);
            }
        }
        return "success";
    }

    //使用springmvc中
    @RequestMapping(path = "/sprinvmvc_fileUpload")
    public String fileUpload(HttpServletRequest request , MultipartFile upload) throws IOException {
        System.out.println("springmvc上传文件.........");
        //先获取上传文件的目录
        String realPath = request.getSession().getServletContext().getRealPath("/uoload");
        //创建File对象，一会向该路径下上传文件
        File file = new File(realPath);
        //判断路径是否存在，如果不存在，创建该路径
        if(!file.exists()){
            file.mkdirs();
        }
        //获取到上传文件的名称
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        //将文件的名称唯一化
        filename = uuid + "-"+filename;
        //上传文件
        upload.transferTo(new File(file,filename));
        return "success";
    }

    //springmvc跨服务器上传文件
    @RequestMapping(path = "/fileupload_twoServer")
    public String fileupload_twoServer(MultipartFile upload) throws IOException {
        System.out.println("springmvc跨服务器上传文件");
        //定义图片服务器请求路径
        String path = "http://localhost:9090/fileupload_server/uploads/";
        //获取到上传文件的名称
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        //把文件的名称唯一化
        filename = uuid+"_"+filename;
        System.out.println("文件的名称是 ： "+filename);
        //向图片服务器上传文件
        //创建客户端对象
        Client client = Client.create();
        System.out.println("client : "+client);
        //连接图片服务器
        WebResource resource = client.resource(path + filename);
        System.out.println("resource : "+resource);
        //上传文件
        resource.put(upload.getBytes());
        return "success";
    }
}
