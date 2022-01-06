package com.ali.amqp.controller;

import com.ali.amqp.pojo.Data;
import com.ali.amqp.service.Dataservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/data")
public class DataController {
    @Autowired
    Dataservice dataservice;
    @RequestMapping("")
    public ModelAndView selectall(){
        List<Data> dataList = dataservice.selectall();
        ModelAndView model=new ModelAndView();
        model.addObject("datalist",dataList);
        model.setViewName("index");
        return model;
    }
    @RequestMapping("/selectbytype")
    public ModelAndView selectbytype(String type,ModelAndView modelAndView){
        Data data = dataservice.selectbytype(type);
        List<Data> dataList1=new ArrayList<>();
        dataList1.add(data);
        System.out.println("**"+dataList1);
        modelAndView.addObject("datalist",dataList1);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
