
package com.jin.mock;

import com.jin.service.TSysMenuService;
import com.jin.service.TSysRoleService;
import com.jin.service.TSysUserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author jinpeng
 * @date 2019/3/14.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockTest {

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext wac;
    @Autowired
    MockHttpSession session;
    @Autowired
    MockHttpServletRequest request;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }


    @Autowired
    private TSysUserService userService;
    @Autowired
    private TSysRoleService roleService;
    @Autowired
    private TSysMenuService menuService;

    @Test
    public void getMXData() throws Exception {
        String url = "/v1/open/test";
        String responseString = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(""))//入参
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(responseString);//返回值
    }


}

