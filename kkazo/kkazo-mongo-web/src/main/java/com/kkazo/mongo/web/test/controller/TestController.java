package com.kkazo.mongo.web.test.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kkazo.mongo.web.test.model.Test;

@RequestMapping("/test")
@Controller
public class TestController {

	@ResponseBody
	@RequestMapping(value={"/{testId}/{testSubject}/{contentType}"})
    public List<Test> testXML(Test test, 
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@PathVariable("testId") String testId,
    		@PathVariable("testSubject") String testSubject,
    		@PathVariable("contentType") String contentType) {
		
		
		test.setCount(777);
		test.setTestId(testId);
		test.setTestSubject(testSubject);
		
		
        return this.test(test);
    }
	
	@ResponseBody
	@RequestMapping(value={"/{testId}/{testSubject}"})
    public Test testSingle(Test test, 
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@PathVariable("testId") String testId,
    		@PathVariable("testSubject") String testSubject) {
		
		
		test.setCount(777);
		test.setTestId(testId);
		test.setTestSubject(testSubject);
		
		
        return test;
    }
	
	private List<Test> test(Test test) {
		List<Test> resultList = new ArrayList<Test>();
		resultList.add(test);
		resultList.add(test);
		resultList.add(test);
		return resultList;
	}
	
}
