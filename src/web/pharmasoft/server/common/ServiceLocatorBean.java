package web.pharmasoft.server.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.stereotype.Component;

import web.pharmasoft.server.common.bd.BaseBD;


@Component("serviceLocatorBean")
public class ServiceLocatorBean implements Serializable, BeanPostProcessor, BeanNameGenerator{	
	
	private static final long serialVersionUID = 8601595434690918462L;
	
	private static Map<String, Object> serviceList = new HashMap<String, Object>();
	
	@SuppressWarnings("rawtypes")
	public static BaseBD findBean(String beanName) {
		Map<String, Object> serviceImplList = getServiceList();
		BaseBD baseService = (BaseBD) serviceImplList.get(beanName);
		return baseService;
	}
	
	public static Object findCommonBean(String beanName) {
		Map<String, Object> serviceImplList = getServiceList();
		Object baseService =  serviceImplList.get(beanName);
		return baseService;
	}

	public static Map<String, Object> getServiceList() {
		return serviceList;
	}

	public static void setServiceList(Map<String, Object> serviceListData) {
		serviceList = serviceListData;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {		
		serviceList.put(beanName, bean);
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {		
		return bean;
	}

	/**
	 *  Method will register bean with it's interface if exist for example UserBDImpl will be register as UserBD
	 */
	@Override
	public String generateBeanName(BeanDefinition definition,
			BeanDefinitionRegistry registry) {
		ScannedGenericBeanDefinition scannedDef = (ScannedGenericBeanDefinition) definition;
		
		String[] interfaceNames = scannedDef.getMetadata().getInterfaceNames();
		String beanName;
		if (interfaceNames.length > 0) {
			beanName = interfaceNames[0];
		} else {
			beanName = scannedDef.getBeanClassName();
		}		
		beanName = beanName.substring(beanName.lastIndexOf('.') + 1);
		beanName = beanName.substring(0, 1).toLowerCase() + beanName.substring(1);
		return beanName;
	}
}
