package ${package}.web;

import java.util.Objects;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
/**
 * 控制器测试用例基类
 * date: 2020-05-27 15:34:20
 * 
 * @author Liuweiyao
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes=${moduleName}Application.class)
public abstract class AbstractControllerTest{
	protected MockMvc mvc;
	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void setupMockMvc(){
		mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	public static RequestBuilder get(String url) {
		return get(url, null);
	}
	
	public static RequestBuilder post(String url) {
		return post(url, null);
	}
	
	public static RequestBuilder put(String url) {
		return put(url, null);
	}
	
	public static RequestBuilder delete(String url) {
		return delete(url, null);
	}

	public static RequestBuilder get(String url,String json) {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url)
		.contentType(MediaType.APPLICATION_JSON_UTF8)
		.accept(MediaType.APPLICATION_JSON_UTF8);
		if(Objects.nonNull(json)){
			((MockHttpServletRequestBuilder) requestBuilder).content(json.getBytes());
		}
		return requestBuilder;
	}
	
	public static RequestBuilder post(String url,String json) {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(url)
		.contentType(MediaType.APPLICATION_JSON_UTF8)
		.accept(MediaType.APPLICATION_JSON_UTF8);
		if(Objects.nonNull(json)){
			((MockHttpServletRequestBuilder) requestBuilder).content(json.getBytes());
		}
		return requestBuilder;
	}
	
	public static RequestBuilder put(String url,String json) {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put(url)
		.contentType(MediaType.APPLICATION_JSON_UTF8)
		.accept(MediaType.APPLICATION_JSON_UTF8);
		if(Objects.nonNull(json)){
			((MockHttpServletRequestBuilder) requestBuilder).content(json.getBytes());
		}
		return requestBuilder;
	}
	
	public static RequestBuilder delete(String url,String json) {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(url)
		.contentType(MediaType.APPLICATION_JSON_UTF8)
		.accept(MediaType.APPLICATION_JSON_UTF8);
		if(Objects.nonNull(json)){
			((MockHttpServletRequestBuilder) requestBuilder).content(json.getBytes());
		}
		return requestBuilder;
	}
}