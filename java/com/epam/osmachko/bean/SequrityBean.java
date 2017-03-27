package com.epam.osmachko.bean;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("constraint")
public class SequrityBean {

	public SequrityBean(String URL, List<String> role) {
		this.URL = URL;
		this.role = role;
	}

	 @XStreamAlias("url-pattern")     
	private String URL;
	
	@XStreamImplicit(itemFieldName="role")
	private List<String> role;

	/**
	 * @return the uRL
	 */
	public String getURL() {
		return URL;
	}

	/**
	 * @param uRL the uRL to set
	 */
	public void setURL(String uRL) {
		URL = uRL;
	}

	/**
	 * @return the role
	 */
	public List<String> getRoles() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(List<String> role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "SequrityBean [URL=" + URL + ", role=" + role + "]";
	}
	
	
	
	
}
