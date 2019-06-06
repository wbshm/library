package main.com.library.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * RequestMapping 注解
 * 作用：
 *      建立请求url和控制器方法对应关系
 *
 * 出现位置：
 *      写在方法：就和请求的url绑定
 *      写在类上：给访问url进行窄化处理
 * 属性：
 *      value: 用于指定访问的url和执行方法之间的对应关系
 *      method :用于限定请求方式
 *      params :用于限定请求url必须的参数要求
 *      headers : 用于限定请求头
 *
 * @author wangrq
 */
@Controller
@RequestMapping("/mvc")
public class MvcController {

    @RequestMapping("/hello")
    public String hello(Integer accountId) {
        //這個東西叫做邏輯到視圖的轉換，你return得是你有 的視圖
        //你這邊webapp下面只有一個index.jsp。你反回hell哦，找不到hello.jsp oho
        return "index";
    }
}
