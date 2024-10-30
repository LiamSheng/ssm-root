package linzi.ssm.springmvc.controller;

import linzi.ssm.springmvc.bean.Person;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
public class ResponseTestController {

    @ResponseBody // 把返回的内容写进响应体里.
    @RequestMapping("/resp01")
    public Person respJSON() {
        Person person = new Person();
        person.setUsername("Linzi");
        person.setPassword("examplePassword");
        person.setCellphone("123456789");
        person.setAgreement(true);
        person.setSex("female");
        person.setHobby(new String[]{"reading", "coding", "hiking"});
        person.setGrade("A");

        return person; // Spring 会自动将对象转为 JSON.
    }

    /**
     * 文件下载
     * RequestEntity: 拿到整个请求数据.
     * ResponseEntity: 拿到整个响应数据.
     */
    @ResponseBody
    @RequestMapping("/download")
    public ResponseEntity<InputStreamResource> download() {
        String path = "C:\\Users\\L\\OneDrive\\桌面\\test\\hi.png";
        File file = new File(path);

        // 检查文件是否存在且不是目录：确保提供的路径指向的是一个存在的文件而不是目录。
        // 如果文件不存在或路径指向的是目录，返回404状态码。
        if (!file.exists() || file.isDirectory()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        try {
            // 创建FileInputStream对象：通过文件路径创建文件输入流。
            FileInputStream fileInputStream = new FileInputStream(file);
            // 创建InputStreamResource对象：将文件输入流封装成InputStreamResource对象，以便作为响应体返回。
            InputStreamResource inputStreamResource = new InputStreamResource(fileInputStream);
            // 设置HTTP头部：添加Content-Disposition头部以指示文件下载，并设置响应的媒体类型和内容长度。
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=" + file.getName());

            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(file.length())
                    .headers(headers)
                    .body(inputStreamResource);
        } catch (FileNotFoundException e) {
            // 异常处理：捕获FileNotFoundException，返回404状态码。
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
