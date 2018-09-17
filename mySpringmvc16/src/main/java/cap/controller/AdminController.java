package cap.controller;

import cap.model.Admin;
import cap.dao.AdminDAO;
import cap.service.AdminService;
import cap.util.PageBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.IdentityHashMap;

@Controller
@RequestMapping("/")
public class AdminController {
    @Resource
    private AdminService adminService;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public ModelAndView list(@RequestParam(value = "pageNo", required = true,defaultValue = "1")Integer pageNo){
        PageBean pageBean=adminService.findByPage(pageNo,5);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("pageBean",pageBean);
        modelAndView.setViewName("list");
        return modelAndView;
    }
   //添加用户信息
    @RequestMapping(value = "add" ,method = RequestMethod.POST)
    public String add(@RequestParam Admin admin){
        adminService.addAdmin(admin);
       return "redirect:/list";
    }
    @RequestMapping(value = "add" ,method = RequestMethod.GET)
    public String add(){
        return "add";
    }




        // 删除用户信息
    @RequestMapping(value = "delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id){
        adminService.deleteById(id);
        return "redirect:/list";
    }
}
