package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:控制器类
 * @author: wll
 * @create: 2019-12-24 14:30
 *
 *
 * 1.启动服务器，加载一些配置文件
 *      DispatcherServlet对象创建
 *      springnvc.xml被加载了
 *      HelloController创建成对象
 *
 * 2.发送请求，后台处理请求
 *
 **/
@Controller
public class HelloController {

    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("hello StringMVC");
        return "success";
    }

    /**RequestMapping注解
     * @return
     */
    @RequestMapping(path ="/testRequestMapping")
    public String testRequestMapping(){
        System.out.println("测试RequestMapping注解...");
        return "success";
    }
}
