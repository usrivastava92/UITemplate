package com.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.formBeans.IndexPage;

@Controller
@RequestMapping(value = "/")
public class MasterController {

	@Value("#{'${topMenuList}'.split(',')}")
	List<String> topMenuList;
	@Value("#{'${menuItemList}'.split(',')}")
	List<String> menuItemList;
	@Value("${brandName}")
	String brandName;
	@Value("${brandDescription}")
	String brandDescription;
	@Value("${pageTitle}")
	String pageTitle;

	private static final Logger BaseLogger = LoggerFactory.getLogger(MasterController.class);

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView toIndex() {
		
		IndexPage indexPage = new IndexPage();
		indexPage.setBrandName(brandName);
		indexPage.setBrandDescription(brandDescription);
		indexPage.setPageTitle(pageTitle);
		int i =0;
		List<String> tempMenuItemList = new ArrayList<>();
		for(String menuItem : menuItemList) {
			if("<br>".equals(menuItem)) {
				indexPage.getMenuItemMap().put(topMenuList.get(i), tempMenuItemList);
				tempMenuItemList = new ArrayList<>();
				i++;
			}
			else {
				tempMenuItemList.add(menuItem);
			}
		}
		for(Entry<String,List<String>> entry : indexPage.getMenuItemMap().entrySet()) {
			System.out.println(entry.getKey());
			for(String val : entry.getValue()) {
				System.out.println("item : "+val);
			}
		}
		BaseLogger.info("in controller ");
		return new ModelAndView("index", "indexPage", indexPage);
	}

}
