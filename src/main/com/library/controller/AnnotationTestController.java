package main.com.library.controller;


import main.com.library.bean.UserDao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author wangrq
 */
@Controller
@RequestMapping("/springmvc")
public class AnnotationTestController {

    @RequestMapping(value = "/testParam")
    public String testRequestParam(@RequestParam(value = "nihao", required = false) Integer integer) {
        System.out.println("测试" + integer);
        return "index";
    }

    @RequestMapping(value = "/testBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println("请求参数" + body);
        return "index";
    }

    @RequestMapping(value = "/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id) {
        System.out.println("请求参数" + id);
        return "index";
    }

    @RequestMapping(value = "/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String value) {
        System.out.println("请求参数" + value);
        return "index";
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(UserDao userDao) {
        return "index";
    }

    @ModelAttribute
    public UserDao testModelAttributeBeforeController() {
        UserDao userDao = new UserDao();
        userDao.setName("nihao");
        userDao.setPassword("123");
        System.out.println(userDao.toString());
        return userDao;
    }

    @RequestMapping("/testRequestJson")
    public @ResponseBody
    UserDao testResponseJson(@RequestBody UserDao userDao) {
        return null;
    }

    @RequestMapping("testMultiUpload")
    public @ResponseBody
    String testMultiUpload(HttpServletRequest request) throws Exception {
        System.out.println("file upload");
        /**
         * 1. 判断表单是否支持上传
         * 2. 创建diskFileItemFactory
         * 3. 创建ServletFileUpload对象
         * 4. 解析Request，得到FileItem对象的集合
         * 5. 判断FileItem 是否是文件字段
         * 6. 是，写入文件
         * 7. 释放流
         */

        if (!ServletFileUpload.isMultipartContent(request)) {
            return "error";
        }

        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
//        fileItemFactory.setRepository(new File("D://temp"));
        ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
        List<FileItem> items = servletFileUpload.parseRequest(request);
        for (FileItem item : items) {
            if (item.isFormField()) {
                String filedName = item.getFieldName();
                String fieldValue = item.getString("UTF-8");
            } else {
                //获取文件的保存路径
                String basePath = request.getServletContext().getRealPath("/WEB-INF/uploads");
                File file = new File(basePath);
                if (!file.exists()) {
                    if (!file.mkdirs()) {
                        System.out.println("文件创建失败");
                    }
                }
                String fileName = item.getName();
                String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
                fileName = uuid + "_" + fileName;
                item.write(new File(file, fileName));
                item.delete();
                //获取文件名
            }
        }
        return "index";
    }

    @RequestMapping("testMultiUpload2")
    public @ResponseBody
    String testMultiUpload2(String name, MultipartFile uploadFile, HttpServletRequest request) throws Exception {
        System.out.println("file upload2");
        String basePath = request.getServletContext().getRealPath("/WEB-INF/uploads");
        String datePath = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        File file = new File(basePath, datePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String fileName = uploadFile.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid + "_" + fileName;
        uploadFile.transferTo(new File(file, fileName));
        return "index";
    }
}
