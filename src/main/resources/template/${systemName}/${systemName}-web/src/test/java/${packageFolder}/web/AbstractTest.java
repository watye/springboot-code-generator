package ${package}.web;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ${package}.web.AbstractTest;

import ${package}.web.${moduleName}Application;
/**
 * 抽象测试用例
 * date: 2019-03-21 10:58:30
 * 
 * @author Liuweiyao
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=${moduleName}Application.class)
public abstract class AbstractTest{
	protected static Logger logger = LoggerFactory.getLogger(AbstractTest.class);
}