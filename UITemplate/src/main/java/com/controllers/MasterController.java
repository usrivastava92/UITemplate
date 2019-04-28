package com.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.formBeans.MenuList;

@Controller
@RequestMapping(value = "/")
public class MasterController {
	
	@Value("${log4j.rootLogger}")
	String string;
	
	private static final Logger BaseLogger = LoggerFactory.getLogger(MasterController.class);

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView toIndex() {
		MenuList menuList = new MenuList();
		menuList.setBrandName("KHUSHI");
		menuList.setBrandDescription("Write description of brand name here..");
		menuList.setPageTitle("HOW ARE YOU!!");
		List<String> vegetableMenuItem = new ArrayList<>();
		vegetableMenuItem.add("Stalk Vegetables");
		vegetableMenuItem.add("Roots & Seeds");
		vegetableMenuItem.add("Cabbages");
		vegetableMenuItem.add("Salad Greens");
		vegetableMenuItem.add("Mushrooms");
		List<String> fruitMenuItem = new ArrayList<>();
		fruitMenuItem.add("Citrus Fruits");
		fruitMenuItem.add("Berries");
		fruitMenuItem.add("Tropical Fruits");
		fruitMenuItem.add("Melons");
		menuList.getMenuItemMap().put("Vegetables", vegetableMenuItem);
		menuList.getMenuItemMap().put("Fruits", fruitMenuItem);
		BaseLogger.info("in controller"+string);
		return new ModelAndView("index", "menuList", menuList);
	}

}
