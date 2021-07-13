package com.iflybank.demo.controller;

import com.iflybank.demo.dao.UserinfoMapper;
import com.iflybank.demo.model.User;
import com.iflybank.demo.model.Userinfo;
import com.sun.org.apache.xpath.internal.objects.XString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/demo")
public class TestController {

    @Autowired
    UserinfoMapper userinfoMapper;


    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    @ResponseBody
    public String test1(@RequestParam String name){
        System.out.println("name="+name);
        return name;
    }

    @RequestMapping(value = "/test2", method = RequestMethod.POST)
    @ResponseBody
    public User test1(@RequestBody User user){
        System.out.println("name="+user.getName());
        System.out.println("age="+user.getAge());
        System.out.println("sex="+user.getSex());
        user.setName("lishi");
        return user;
    }


    @RequestMapping(value = "/test3/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Userinfo test3(@PathVariable byte id){
        Userinfo userinfo = userinfoMapper.selectByPrimaryKey(id);
        return userinfo;
    }

    @RequestMapping(value = "/test4/{phoneNum}", method = RequestMethod.GET)
    @ResponseBody
    public boolean test4(@PathVariable String phoneNum){

        String regex = "1[38]\\d{9}";//定义手机好规则
        return phoneNum.matches(regex);
    }

   //往Userinfo插入数据
    @RequestMapping(value = "/testInsert/",method = RequestMethod.POST)
    @ResponseBody
    public  String testInsert(@RequestBody Userinfo userinfo){
        userinfoMapper.insert(userinfo);
        return "插入成功";
    }

    //往Userinfo更新数据
    @RequestMapping(value = "/testUpdate/",method = RequestMethod.POST)
    @ResponseBody
    public String testUpdate(@RequestBody Userinfo userinfo){
        userinfoMapper.updateByPrimaryKey(userinfo);
        return "更新成功";
    }

    //往Userinfo更新数据
    @RequestMapping(value = "/testUpdate2/",method = RequestMethod.POST)
    @ResponseBody
    public int testUpdate2(@RequestBody Userinfo userinfo){
        int n = userinfoMapper.updateByPrimaryKey(userinfo);
        return n;
    }

    //验证邮箱格式是否正确
    @RequestMapping(value = "/test7", method = RequestMethod.GET)
    @ResponseBody
    public boolean test7(@RequestParam String email){

        String regex = "^[a-z0-9A-Z]+[- | a-z0-9A-Z . _]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-z]{2,}$";//定义邮箱规则
        return email.matches(regex);
    }

    //验证邮箱格式是否正确  方式二：但因为在路径中的参数是不能有特殊字符，所以邮箱验证就不能用这个方式
    @RequestMapping(value = "/test8/{email}", method = RequestMethod.GET)
    @ResponseBody
    public boolean test8(@PathVariable String email){

        String regex = "^[a-z0-9A-Z]+[- | a-z0-9A-Z . _]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-z]{2,}$";//定义邮箱规则
        return email.matches(regex);
    }


}
