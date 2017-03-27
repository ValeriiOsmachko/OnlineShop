package com.epam.osmachko.sequrity;

import java.util.List;

import com.epam.osmachko.bean.SequrityBean;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;


@XStreamAlias("security")
public class SequrityBeanContainer {

	@XStreamImplicit(itemFieldName="constraint")
	private List<SequrityBean> list;

	public List<SequrityBean> getList() {
		return list;
	}

	public void setList(List<SequrityBean> list) {
		this.list = list;
	}

	
	@Override
	public String toString() {
		return "SequrityBeanContainer [list=" + list + "]";
	}
	
	
	
	
	
}
