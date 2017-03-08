package com.domain.controller;

import static org.apache.commons.lang3.StringUtils.trimToNull;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;

import com.domain.config.JsonMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public abstract class AbstractControllerTest {
    protected static final String JPATH_STATUS = "$.status";
    protected static final String JPATH_PAYLOAD = "$.payload";
    protected static final String JPATH_MESSAGE = "$.message";
    protected static final String EXPECTED_CONTENT_TYPE = "application/json;charset=UTF-8";

    private MockMvc mockMvc;

    @Autowired
    private JsonMapper objectMapper;

    private TypeFactory typeFactory;

    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup() throws Exception {
        // checks that all required dependencies are provided.
        assertNotNull("WebApplicationContext isn't provided.", wac);
        assertNotNull("ObjectMapper isn't provided.", objectMapper);

        typeFactory = TypeFactory.defaultInstance();
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    protected final MockMvc mvc() {
        return mockMvc;
    }

    protected final JsonMapper getObjectMapper() {
        return objectMapper;
    }

    protected final TypeFactory getTypeFactory() {
        return typeFactory;
    }

}
