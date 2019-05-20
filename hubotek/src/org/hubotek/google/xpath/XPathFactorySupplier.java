package org.hubotek.google.xpath;

import javax.xml.xpath.XPathFactory;

import com.google.common.base.Supplier;

public class XPathFactorySupplier implements Supplier<XPathFactory> {

	@Override
	public XPathFactory get() {
		return XPathFactory.newInstance();
	}

}
