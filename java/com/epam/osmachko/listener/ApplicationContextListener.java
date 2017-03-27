package com.epam.osmachko.listener;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.epam.osmachko.DBConnection.TransactionManager;
import com.epam.osmachko.Dao.Impl.CategoryDaoImpl;
import com.epam.osmachko.Dao.Impl.ManufacturerDaoOImpl;
import com.epam.osmachko.Dao.Impl.MySQLDaoImpl;
import com.epam.osmachko.Dao.Impl.OrderDaoImpl;
import com.epam.osmachko.Dao.Impl.PriceDaoImpl;
import com.epam.osmachko.Dao.Impl.ProductDaoimpl;
import com.epam.osmachko.bean.Captcha;
import com.epam.osmachko.bean.SequrityBean;
import com.epam.osmachko.capture_manager.CaptchaManager;
import com.epam.osmachko.constant.Constant;
import com.epam.osmachko.factory.StrategyFactory;
import com.epam.osmachko.sequrity.SequrityBeanContainer;
import com.epam.osmachko.service.CategoryService;
import com.epam.osmachko.service.FilterService;
import com.epam.osmachko.service.ManufacturerService;
import com.epam.osmachko.service.MySQLUserService;
import com.epam.osmachko.service.OrderService;
import com.epam.osmachko.service.PriceSevice;
import com.epam.osmachko.service.ProductService;
import com.epam.osmachko.thread.CaptchaCleaner;
import com.epam.osmachko.xml_parser.XmlParser;

public class ApplicationContextListener implements ServletContextListener {

	private Map<String, Captcha> captchaContainer;
	
	private static final Logger LOGGER = Logger.getLogger(ApplicationContextListener.class);
	

	private void initCapthcaContainer() {
		captchaContainer = new ConcurrentHashMap<String, Captcha>();
	}

	public void contextInitialized(ServletContextEvent sce) {
		BasicConfigurator.configure();
		initCapthcaContainer();
		ServletContext ctx = sce.getServletContext();
		Map<String, String> map = new HashMap<String, String>();
		ctx.setAttribute("CaptchaContainer", map);
		ctx.setAttribute("CapthcaCont", captchaContainer);
		CaptchaManager manager = StrategyFactory.strategyCreator(ctx);
		ctx.setAttribute("manager", manager);
		Thread thread = new Thread(new CaptchaCleaner(manager));
		thread.setDaemon(true);
		thread.start();
		try {
			getDataSource(ctx);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			LOGGER.error(e);
		}
	}

	public void contextDestroyed(ServletContextEvent sce) {

	}
	
	
	public void getDataSource(ServletContext ctx) throws ParserConfigurationException, SAXException, IOException {
		TransactionManager transactionManager = null;
		Context context = null;
		DataSource ds = null;
		try {
			context = new InitialContext();
			ds = (DataSource) context.lookup(Constant.LOOK_UP_NAME);
			transactionManager = new TransactionManager(ds);	
		} catch (NamingException e) {
			LOGGER.error(e);
		} 
		MySQLDaoImpl userDao = new MySQLDaoImpl();
		MySQLUserService userService = new MySQLUserService(userDao,transactionManager);
		ProductDaoimpl productDao = new ProductDaoimpl();
		ProductService productService = new ProductService(productDao, transactionManager);
		CategoryDaoImpl categoryDao = new CategoryDaoImpl();
		CategoryService categoryService = new CategoryService(categoryDao, transactionManager);
		ManufacturerDaoOImpl manufacturerDao = new ManufacturerDaoOImpl();
		ManufacturerService manufacturerService = new ManufacturerService(manufacturerDao, transactionManager);
		PriceDaoImpl priceDao = new PriceDaoImpl();
		PriceSevice priceService = new PriceSevice(priceDao, transactionManager);
		FilterService filterServise = new FilterService(productDao, transactionManager);
		OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
		OrderService orderService = new OrderService(orderDaoImpl, transactionManager);
		ctx.setAttribute(Constant.USER_SERVICE, userService);
		ctx.setAttribute(Constant.PRODUCT_SERVICE, productService);
		ctx.setAttribute(Constant.CATEGORY_SERVICE, categoryService);
		ctx.setAttribute(Constant.MANUFACTURER_SERVICE, manufacturerService);
		ctx.setAttribute(Constant.PRICE_SERVICE, priceService);
		ctx.setAttribute(Constant.FILTER_SERVICE, filterServise);
		ctx.setAttribute(Constant.ORDER_SERVICE, orderService);
		XmlParser parser = new XmlParser();
		SequrityBeanContainer container = parser.parseXMLWithXStream();
		ctx.setAttribute(Constant.LIST_SEQURITY_BEANS, container);
	}
	
	
}
