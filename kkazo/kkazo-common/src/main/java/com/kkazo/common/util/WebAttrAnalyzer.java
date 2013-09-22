package com.kkazo.common.util;

import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;

public class WebAttrAnalyzer {
	private static Logger logger = LoggerFactory.getLogger(WebAttrAnalyzer.class);
	
	@SuppressWarnings("unchecked")
	public static void analyze(HttpServletRequest request) {

		int index = 0;
		logger.info("---------------------------------");
		logger.info("   HttpRequest Parameters");
		logger.info("---------------------------------");
		Enumeration<String> enu = (Enumeration<String>) request.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = enu.nextElement();
			logger.info((++index) + ". " + name + "=" + request.getParameter(name));
		}

		logger.info("---------------------------------");
		logger.info("   HttpRequest Attributes");
		logger.info("---------------------------------");
		enu = request.getAttributeNames();
		index = 0;
		while (enu.hasMoreElements()) {
			String name = enu.nextElement();
			Object attribute = request.getAttribute(name);
			logger.info((++index) + ". " + name + "=" + attribute);
			if (attribute instanceof AbstractApplicationContext) {
				analyze((AbstractApplicationContext) attribute);
			}
		}

		HttpSession session = request.getSession(false);
		if (session == null)
			return;
		logger.info("---------------------------------");
		logger.info("   HttpSession Attributes");
		logger.info("---------------------------------");
		enu = session.getAttributeNames();
		index = 0;
		while (enu.hasMoreElements()) {
			String name = enu.nextElement();
			Object attribute = session.getAttribute(name);
			logger.info((++index) + ". " + name + "=" + attribute);
			if (attribute instanceof AbstractApplicationContext) {
				analyze((AbstractApplicationContext) attribute);
			}
		}

		logger.info("---------------------------------");
		logger.info("   ServletContext Attributes");
		logger.info("---------------------------------");
		ServletContext context = session.getServletContext();
		enu = context.getAttributeNames();
		index = 0;
		while (enu.hasMoreElements()) {
			String name = enu.nextElement();
			Object attribute = context.getAttribute(name);
			logger.info((++index) + ". " + name + "=" + attribute);
			if (attribute instanceof AbstractApplicationContext) {
				analyze((AbstractApplicationContext) attribute);
			}
		}
	}

	public static void analyze(Map<String, ?> map) {
		logger.info("---------------------------------");
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			logger.info(key + "=" + map.get(key));
		}
		logger.info("---------------------------------");
	}

	public static void analyze(AbstractApplicationContext context) {
		String names[] = context.getBeanDefinitionNames();
		for (String name : names) {
			Object bean = context.getBean(name);
			logger.info("\t" + name + "> " + bean);
		}
	}
}