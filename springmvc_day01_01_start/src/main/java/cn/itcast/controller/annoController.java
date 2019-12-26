package cn.itcast.controller;

import cn.itcast.domain.User;
import cn.itcast.utils.StringToDateConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

/**
 * @description:常用注解
 * @author: wll
 * @create: 2019-12-25 10:21
 **/
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"}) //把msg=美美存入到session域对象中
public class annoController {

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username){
        System.out.println("执行了...");
        System.out.println(username);
        return "success";
    }

    /**获取请求体内容
     * @param
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("执行了...");
        System.out.println(body);
        return "success";
    }

    /**PathVariable注解
     * @param
     * @return
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable(name = "id") String id){
        System.out.println("执行了...");
        System.out.println(id);
        return "success";
    }

    /**获取请求头的值
     * @param
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header){
        System.out.println("执行了...");
        System.out.println(header);
        return "success";
    }

    /**获取Cookie值
     * @param
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue){
        System.out.println("执行了...");
        System.out.println(cookieValue);
        return "success";
    }

    /**ModelAttribute注解
     * @param
     * @return
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user){
        System.out.println("testModelAttribute执行了...");
        System.out.println(user);
        return "success";
    }

    @ModelAttribute
    public void showUser(String uname, Map<String, User> map){
        System.out.println("showUser执行了....");
        //通过用户查询数据库
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        map.put("abc", user);
    }
//    /**
//     * 该方法会先执行
//     */
//    @ModelAttribute
//    public User showUser(String uname){
//        System.out.println("showUser执行了....");
//        //通过用户查询数据库
//        User user = new User();
//        user.setUname(uname);
//        user.setAge(20);
//        user.setDate(new Date());
//        return user;
//    }

    /**SessionAttributes注解
     * @param model
     * @return
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("testSessionAttributes执行了...");
        //底层会存储到request域对象中
        model.addAttribute("msg", "美美");
        return "success";
    }

    /**获取值
     * @param modelMap
     * @return
     */
    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
        System.out.println("getSessionAttributes执行了...");
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    /**清除session
     * @param sessionStatus
     * @return
     */
    @RequestMapping("/delSessionAttributes")
    public String delSessionAttributes(SessionStatus sessionStatus){
        System.out.println("delSessionAttributes执行了...");
        sessionStatus.setComplete();
        return "success";
    }
}
