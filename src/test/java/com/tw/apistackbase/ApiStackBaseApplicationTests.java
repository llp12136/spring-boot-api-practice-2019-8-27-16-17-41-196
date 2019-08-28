package com.tw.apistackbase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApiStackBaseApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	//post
	@Test
	public void should_return_201_status_when_create_employee() throws Exception {
		//Given
		MockHttpServletRequestBuilder input = post("/employees").content("{\"username\":\"xiaoming\"}").contentType(MediaType.APPLICATION_JSON);
		//When
		ResultActions result = mockMvc.perform(input);
		//Then
		result
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isCreated());
	}
	//GET
	@Test
	public void should_return_ok_and_content_when_query_all_user() throws Exception {
		//Given
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user");
		//When
		ResultActions performResult = mockMvc.perform(requestBuilder);
		//Then
		performResult
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("[{\"id\":\"001\",\"name\":\"xiaoming\"}]"));
	}
	//put
	@Test
	public void should_return_201_status_when_update_user() throws Exception {
		//Given
		MockHttpServletRequestBuilder input = put("/user").content("{\"username\":\"xiaohong\"}").contentType(MediaType.APPLICATION_JSON);
		//When
		ResultActions result = mockMvc.perform(input);
		//Then
		result
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isCreated());
	}
	//delete
	@Test
	public void should_return_ok_and_content_when_delete_all_user() throws Exception {
		//Given
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/user/001").contentType(MediaType.APPLICATION_JSON);
		//When
		ResultActions performResult = mockMvc.perform(requestBuilder);
		//Then
		performResult
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("[{\"id\":\"002\",\"name\":\"xiaohong\"}]"));
	}

}
