package com.kkazo.mongo.web.test.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="test")
public class Test {

	private int count;
	private String testId;
	private String testSubject;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public String getTestSubject() {
		return testSubject;
	}
	public void setTestSubject(String testSubject) {
		this.testSubject = testSubject;
	}
	
	
}
