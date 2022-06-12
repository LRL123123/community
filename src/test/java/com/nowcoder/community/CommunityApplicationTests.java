package com.nowcoder.community;

import com.nowcoder.community.dao.AlphaDao;
import com.nowcoder.community.servlet.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Test
	public void TestApplicationContext(){
		System.out.println(applicationContext);
		AlphaDao a = applicationContext.getBean("Mybatis",AlphaDao.class);
		AlphaDao b = applicationContext.getBean(AlphaDao.class);

		System.out.println(a.select());
		System.out.println(b.select());
	}

	@Test
	public void TestBeanConfig() {
		SimpleDateFormat s = applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(s.format(new Date()));
	}

	@Autowired
	@Qualifier("Mybatis")
	private AlphaDao alphaDao;

	@Autowired
	private AlphaService alphaService;

	@Autowired
	private SimpleDateFormat simpleDateFormat;
	@Test
	public void TestDI() {
		System.out.println(alphaDao);
	}
}
