package linzi.ssm.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import linzi.ssm.springmvc.bean.Person;
import linzi.ssm.springmvc.bean.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class RequestTestController {

    /**
     * 获取请求参数, 没有携带的不封装, 不体现在明文地址里.
     * 形参名必须和 url 里的一致.
     *
     * @param username  用户名
     * @param password  密码
     * @param cellphone 手机号
     * @param agreement 是否同意, 包装类默认 null, 基本类型为默认值.
     */
    @RequestMapping(value = "/handle01")
    public String getParams(String username, String password,
                            String cellphone, boolean agreement) {
        System.out.println("username=" + username + ", password=" + password +
                ", cellphone=" + cellphone + ", agreement=" + agreement);

        return "success";
    }

    /**
     * 获取请求参数, 使用 @RequestParam 注解处理请求参数, 参数必须全, 不然会报错.
     * GET, POST 的请求参数均可用.
     *
     * @param usernameAlias  用户名
     * @param passwordAlias  密码
     * @param cellphoneAlias 手机号
     * @param agreementAlias 是否同意
     */
    @RequestMapping(value = "/handle02")
    public String getParamsWithAnnotation(
            @RequestParam("username") String usernameAlias,
            @RequestParam(value = "password", defaultValue = "123") String passwordAlias,
            @RequestParam("cellphone") String cellphoneAlias,
            @RequestParam(value = "agreement", required = false) Boolean agreementAlias) {
        System.out.println("username=" + usernameAlias + ", password=" +
                passwordAlias + ", cellphone=" + cellphoneAlias + ", agreement=" + agreementAlias);

        return "success";
    }

    /**
     * 如果目标方法是一个 POJO, Spring 会自动对应封装.
     * 请求参数遗漏 -> 封装为 null.
     *
     * @param user POJO
     */
    @RequestMapping(value = "/handle03")
    public String getParamsWithPOJO(User user) {
        System.out.println("user=" + user);
        return "success";
    }

    @RequestMapping(value = "/handle04")
    public String getHeaders(@RequestHeader("user-agent") String header) {
        return header;
    }

    @RequestMapping(value = "/handle05")
    public String getCookieValue(@CookieValue("Hi") String cookieValue) {
        // 前后端分离之后用得少了.
        return cookieValue;
    }

    /**
     * POJO 级联封装复杂的属性.
     */
    @RequestMapping(value = "/handle06")
    public String getNestedParamsWithPOJO(Person person) {
        System.out.println("person=" + person);
        return "success";
    }

    /**
     * 使用 @RequestBody 获取请求体中的 JSON.
     * 1. 使用 PostMan 发送 JSON 数据.
     * 2. @RequestBody 获取请求体的 JSON 数据, 反序列化.
     * 拿到请求体中的 JSON 字符串. 并将其反序列化为一个对象.
     */
    @RequestMapping(value = "/handle07")
    public String getJSONWithRequestBody(@RequestBody Person person) {
        System.out.println("person=" + person);
        return "success";
    }

    /**
     * 上传文件, method = POST, enctype = "multipart/form-data".
     * 默认单文件最大 1MB; 整个请求最大 10MB.
     * MultipartFile
     */
    @RequestMapping(value = "/handle08")
    public String upLoad(User user,
                         @RequestParam("headerImg") MultipartFile file,
                         @RequestParam("lifeImg") MultipartFile[] files) throws IOException {
        String fileName = file.getOriginalFilename();
        long fileSize = file.getSize();
        // 获取文件流.
        InputStream inputStream = file.getInputStream();
        // 保存文件.
        file.transferTo(new File("C:\\" + fileName));

        try {
            for (MultipartFile multipartFile : files) {
                multipartFile.transferTo(new File("C:\\" + multipartFile.getOriginalFilename()));
            }
        } catch (IOException | IllegalStateException e) {
            System.out.println("没有上传任何生活照!");
            throw new RuntimeException(e);
        }

        System.out.println("user=" + user);
        return "success";
    }

    /**
     * 一次性获取请求头 + 请求体的封装.
     * 泛型 <String> 请求体的类型.
     */
    @RequestMapping("/handle09")
    public String getEntireHttpEntity(HttpEntity<String> httpEntity) {
        // 所有的请求头
        HttpHeaders headers = httpEntity.getHeaders();
        // 所有的请求体.
        String body = httpEntity.getBody();
        System.out.println("body=" + body + ", headers=" + headers);

        return "success";
    }

    /**
     * 使用原生 servlet API.
     */
    @RequestMapping("/handle10")
    public void originalServlet(HttpServletRequest req,
                                HttpServletResponse resp,
                                HttpMethod method) throws IOException {
        String username = req.getParameter("username");
        System.out.println(username);
        resp.getWriter().write("got username:" + username + ", with method:   " + method);
    }

}
