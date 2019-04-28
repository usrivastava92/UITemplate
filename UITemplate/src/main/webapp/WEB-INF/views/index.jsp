<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" class="no-js">

<head>
<spring:url value="/resources/css/organicfoodicons.css"
	var="organicfoodicons" />
<spring:url value="/resources/css/demo.css" var="demo" />
<spring:url value="/resources/css/component.css" var="component" />
<spring:url value="/resources/js/modernizr-custom.js"
	var="modernizrCustom" />
<spring:url value="/resources/js/classie.js" var="classie" />
<spring:url value="/resources/js/dummydata.js" var="dummydata" />
<spring:url value="/resources/js/main.js" var="main" />
<spring:url value="/resources/js/menu.js" var="menu" />
<spring:url value="/resources/favicon.ico" var="favicon" />


<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${indexPage.brandName}</title>
<meta name="description"
	content="Blueprint: A basic template for a responsive multi-level menu" />
<meta name="keywords"
	content="blueprint, template, html, css, menu, responsive, mobile-friendly" />
<meta name="author" content="Codrops" />
<link rel="shortcut icon" href="${favicon}">
<link rel="stylesheet" type="text/css" href="${organicfoodicons}" />
<link rel="stylesheet" type="text/css" href="${demo}" />
<link rel="stylesheet" type="text/css" href="${component}" />
<script src="${modernizrCustom}"></script>
</head>

<body>
	<div class="container">
		<header class="bp-header cf">
			<div class="dummy-logo">
				<div class="dummy-icon foodicon foodicon--coconut"></div>
				<h2 class="dummy-heading">Menu Items</h2>
			</div>
			<div class="bp-header__main">
				<span class="bp-header__present">${indexPage.brandName}<span
					class="bp-tooltip bp-icon bp-icon--about"
					data-content="${indexPage.brandDescription}"></span></span>
				<h1 class="bp-header__title">${indexPage.pageTitle}</h1>
				<nav class="bp-nav">
					<a class="bp-nav__item bp-icon bp-icon--prev" href="#"
						data-info="previous Blueprint"><span>Previous Blueprint</span></a>
					<a class="bp-nav__item bp-icon bp-icon--next" href="#"
						data-info="next Blueprint"><span>Next Blueprint</span></a> <a
						class="bp-nav__item bp-icon bp-icon--drop" href="#"
						data-info="Hyperlink-One"><span>Hyperlink-One</span></a> <a
						class="bp-nav__item bp-icon bp-icon--archive" href="#"
						data-info="Hyperlink-Two"><span>Hyperlink-Two</span></a>
				</nav>
			</div>
		</header>

		<button class="action action--open" aria-label="Open Menu">
			<span class="icon icon--menu"></span>
		</button>
		<nav id="ml-menu" class="menu">
			<button class="action action--close" aria-label="Close Menu">
				<span class="icon icon--cross"></span>
			</button>
			<div class="menu__wrap">

				<ul data-menu="main" class="menu__level" tabindex="-1" role="menu"
					aria-label="All">
					<c:set var="mainCounter" value="1" />
					<c:forEach items="${indexPage.menuItemMap}" var="menuItemMap">
						<li class="menu__item" role="menuitem"><a class="menu__link"
							data-submenu="submenu-${mainCounter}"
							aria-owns="submenu-${mainCounter}" href="#"> <c:out
									value="${menuItemMap.key}" /></a></li>
						<c:set var="mainCounter" value="${mainCounter + 1}" />
					</c:forEach>
				</ul>

				<c:set var="mainCounter" value="1" />
				<c:forEach items="${indexPage.menuItemMap}" var="menuItemMap">
					<ul data-menu="submenu-${mainCounter}" id="submenu-${mainCounter}"
						class="menu__level" tabindex="-1" role="menu"
						aria-label="${menuItemMap.key}">
						<c:forEach items="${menuItemMap.value}" var="menuItem">
							<li class="menu__item" role="menuitem"><a class="menu__link"
								href="#"><c:out value="${menuItem}" /></a></li>
						</c:forEach>
						<c:set var="mainCounter" value="${mainCounter + 1}" />
					</ul>
				</c:forEach>

			</div>
		</nav>
		<div class="content">
			<p class="info">Please choose a category</p>
		</div>
	</div>
</body>
<script src="${classie}"></script>
<script src="${dummydata}"></script>
<script src="${main}"></script>
<script src="${menu}"></script>
</html>
