package com.spring.boot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mvc;
	
	@Before
	public void setUp() throws Exception {
		this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	/************************主库控制层接口测试-start******************************/
	@Test
	public void testInsertMaster() throws Exception {
		ResultActions action = mvc.perform(MockMvcRequestBuilders
				.post("/user/insertMaster")
				.param("userName", "testName")
				.param("password", "password")
				.param("phone", "13578236975")
				.content(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());	
		String userId = action.andReturn().getResponse().getContentAsString();
		
		System.out.println("userId:" + userId);
	}
	
	@Test
	public void testGetAllMaster() throws Exception {
		
		// 先保存，确保有数据
		mvc.perform(MockMvcRequestBuilders
				.post("/user/insertMaster")
				.param("userName", "testName")
				.param("password", "password")
				.param("phone", "13578236975")
				.content(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());	
		
		mvc.perform(MockMvcRequestBuilders
				.get("/user/getAllMaster")
				.content(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());	
	}
	
	@Test
	public void testGetMaster() throws Exception {
		// 先保存，确保有数据
		ResultActions action = mvc.perform(MockMvcRequestBuilders
				.post("/user/insertMaster")
				.param("userName", "testName1")
				.param("password", "password1")
				.param("phone", "13578236975")
				.content(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
		
		String userId = action.andReturn().getResponse().getContentAsString();
		System.out.println("userId:" + userId);
		
		mvc.perform(MockMvcRequestBuilders
				.get("/user/getMaster")
				.param("userId", userId)
				.content(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());	
	}
	
	@Test
	public void testUpdateMaster() throws Exception {
		// 先保存，确保有数据
		ResultActions action = mvc.perform(MockMvcRequestBuilders
				.post("/user/insertMaster")
				.param("userName", "testName1")
				.param("password", "password1")
				.param("phone", "13578236975")
				.content(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());	
		
		String userId = action.andReturn().getResponse().getContentAsString();
		System.out.println("userId:" + userId);
		
		mvc.perform(MockMvcRequestBuilders
				.post("/user/updateMaster")
				.param("userName", "修改")
				.param("password", "password")
				.param("phone", "13578236975")
				.param("userId", userId)
				.content(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());	
	}
	
	@Test
	public void testDeleteMaster() throws Exception {
		
		// 先保存，确保有数据
		ResultActions action = mvc.perform(MockMvcRequestBuilders
				.post("/user/insertMaster")
				.param("userName", "testName1")
				.param("password", "password1")
				.param("phone", "13578236975")
				.content(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());	
		
		String userId = action.andReturn().getResponse().getContentAsString();
		System.out.println("userId:" + userId);
		
		mvc.perform(MockMvcRequestBuilders
				.delete("/user/deleteMaster")
				.param("userId", userId)
				.content(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());	
	}
	/************************主库控制层接口测试-end******************************/
	
	/************************从库控制层接口测试-start******************************/
	
	@Test
	public void testInsertCluster() throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.post("/user/insertCluster")
				.param("userName", "testName")
				.param("password", "password")
				.param("phone", "13578236975")
				.content(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());	
	}
	
	@Test
	public void testGetAllCluster() throws Exception {
		// 先保存，确保有数据
		ResultActions action = mvc.perform(MockMvcRequestBuilders
				.post("/user/insertCluster")
				.param("userName", "testName1")
				.param("password", "password1")
				.param("phone", "13578236975")
				.content(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());	
		
		String userId = action.andReturn().getResponse().getContentAsString();
		System.out.println("userId:" + userId);
		
		mvc.perform(MockMvcRequestBuilders
				.get("/user/getAllCluster")
				.content(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());	
	}
	
	@Test
	public void testGetCluster() throws Exception {
		// 先保存，确保有数据
		ResultActions action = mvc.perform(MockMvcRequestBuilders
				.post("/user/insertCluster")
				.param("userName", "testName1")
				.param("password", "password1")
				.param("phone", "13578236975")
				.content(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());	
		
		String userId = action.andReturn().getResponse().getContentAsString();
		System.out.println("userId:" + userId);
		
		mvc.perform(MockMvcRequestBuilders
				.get("/user/getCluster")
				.param("userId", userId)
				.content(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());	
	}
	
	@Test
	public void testUpdateCluster() throws Exception {
		// 先保存，确保有数据
		ResultActions action = mvc.perform(MockMvcRequestBuilders
				.post("/user/insertCluster")
				.param("userName", "testName1")
				.param("password", "password1")
				.param("phone", "13578236975")
				.content(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());	
		
		String userId = action.andReturn().getResponse().getContentAsString();
		System.out.println("userId:" + userId);
		
		mvc.perform(MockMvcRequestBuilders
				.post("/user/updateCluster")
				.param("userName", "testName修改")
				.param("password", "password")
				.param("phone", "13578236975")
				.param("userId", userId)
				.content(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());	
	}
	
	@Test
	public void testDeleteCluster() throws Exception {
		
		// 先保存，确保有数据
		ResultActions action = mvc.perform(MockMvcRequestBuilders
				.post("/user/insertCluster")
				.param("userName", "testName1")
				.param("password", "password1")
				.param("phone", "13578236975")
				.content(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());	
		
		String userId = action.andReturn().getResponse().getContentAsString();
		System.out.println("userId:" + userId);
		
		mvc.perform(MockMvcRequestBuilders
				.delete("/user/deleteCluster")
				.param("userId", userId)
				.content(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());	
	}
	/************************从库控制层接口测试-end******************************/
}
