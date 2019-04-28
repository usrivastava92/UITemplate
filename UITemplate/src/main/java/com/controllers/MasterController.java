package com.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.formBeans.MenuList;

@Controller
@RequestMapping(value = "/")
public class MasterController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView toIndex() {
		MenuList menuList = new MenuList();
		menuList.setBrandName("BRAND NAME");
		menuList.setBrandDescription("Write description of brand name here..");
		menuList.setPageTitle("Page Title");
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
		System.out.println("in controller");
		return new ModelAndView("index", "menuList", menuList);
	}

}
