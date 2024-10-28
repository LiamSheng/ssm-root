package linzi.ssm.springmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController // 一个顶俩
public class RequestMappingLimitController {

    /**
     * 限定请求方式.
     * GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE;
     */
    @RequestMapping(value = "/limit-method",
            method = {RequestMethod.POST, RequestMethod.GET})
    public String limitMethod() {
        // 浏览器表单页面只能发送 GET 请求, 会报错.
        return "POST ONLY!";
    }

    /**
     * 限定请求参数.
     * 必须有参数 username, age. 且 age 的值一定为 18.
     */
    @RequestMapping(value = "/limit-params",
            params = {"username", "age=18", "gender!=male"})
    public String limitParams() {
        return "VALID PARAMS ONLY!";
    }

    /**
     * 限定请求头.
     */
    @RequestMapping(value = "/limit-headers",
            headers = {"valid-headers"})
    public String limitHeaders() {
        return "VALID HEADERS ONLY!";
    }

    /**
     * 请求时必须携带 JSON 格式的数据.
     * application/json - 传输JSON格式的数据
     * application/xml - 传输XML格式的数据
     * multipart/form-data - 传输表单文件数据
     * application/x-www-form-urlencoded - 传输普通表单数据
     * application/octet-stream - 传输二进制数据流
     * text/plain - 传输纯文本数据
     * text/html - 传输HTML文本数据
     * application/pdf - 传输PDF文件
     */
    @RequestMapping(value = "/limit-consumes",
            consumes = "application/json")
    public String limitConsumes() {
        return "MUST BE JSON STRING!";
    }

    /**
     * 规定服务器回传的数据类型.
     * application/json - 生成JSON格式的数据
     * application/xml - 生成XML格式的数据
     * multipart/form-data - 生成表单文件数据
     * application/x-www-form-urlencoded - 生成普通表单数据
     * application/octet-stream - 生成二进制数据流
     * text/plain - 生成纯文本数据
     * text/html - 生成HTML文本数据
     * application/pdf - 生成PDF文件
     */
    @RequestMapping(value = "/limit-produces",
            produces = "text/html")
    public String limitProduces() {
        return "<h1>HTML</h1>";
    }

}
