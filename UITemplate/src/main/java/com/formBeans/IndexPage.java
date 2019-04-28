package com.formBeans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

@Named("menuList")
public class IndexPage {
	private Map<String, List<String>> menuItemMap = new HashMap<>();
	private String brandName = "";
	private String brandDescription = "";
	private String pageTitle = "";

	public Map<String, List<String>> getMenuItemMap() {
		return menuItemMap;
	}

	public void setMenuItemMap(Map<String, List<String>> menuItemMap) {
		this.menuItemMap = menuItemMap;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandDescription(String brandDescription) {
		this.brandDescription = brandDescription;
	}

	public String getBrandDescription() {
		return brandDescription;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

}
