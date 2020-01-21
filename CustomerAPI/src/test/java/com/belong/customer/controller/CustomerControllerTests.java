package com.belong.customer.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.belong.customer.controller.CustomerController;
import com.belong.customer.dto.CustomerDTO;
import com.belong.customer.entity.Customer;
import com.belong.customer.entity.Phones;
import com.belong.customer.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTests {

	@Autowired
	private transient MockMvc mvc;

	@MockBean
	private transient CustomerService service;

	@InjectMocks
	private CustomerController controller;

	private Customer customer;

	//static List<Customer> customersList;


	
	@Test
	public void activateCustomerTest() throws Exception {
		List<Phones> phoneList = new ArrayList<Phones>();
		CustomerDTO dto = new CustomerDTO();
		dto.setCustomerName("Karuna Joshi");
		dto.setCustomerId("1");
		
		Phones phone = new Phones();
		phone.setPhoneNo("0478944834");
		phoneList.add(phone);
		dto.setPhoneDtls(phoneList);

		when(service.activateUser(dto)).thenReturn(Mockito.anyString());
		mvc.perform(post("/api/v1/customer/activate").contentType(MediaType.APPLICATION_JSON)
				.content(jsonToString(dto))).andExpect(status().isOk());
	}
	
	@Test
	public void getCustomerInfoTest() throws Exception {
		List<Phones> phoneList = new ArrayList<Phones>();
		CustomerDTO dto = new CustomerDTO();
		dto.setCustomerName("Karuna Joshi");
		dto.setCustomerId("1");
		
		Phones phone = new Phones();
		phone.setId(new Long("1"));
		phone.setPhoneNo("0478944834");
		phoneList.add(phone);
		dto.setPhoneDtls(phoneList);
		
		List<CustomerDTO> customerList = new ArrayList<>();
		customerList.add(dto);

		when(service.getAllCustomerInfo("all")).thenReturn(customerList);
		mvc.perform(get("/api/v1/customer/all").contentType(MediaType.APPLICATION_JSON)
				.content(jsonToString(customerList))).andExpect(status().isOk());
	}

	private static String jsonToString(final Object obj) {
		String result;
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			result = jsonContent;
		} catch (JsonProcessingException e) {
			result = "JSON Parsing error";
		}
		return result;
	}
}
