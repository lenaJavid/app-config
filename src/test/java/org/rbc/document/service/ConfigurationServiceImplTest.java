package org.rbc.document.service;

import javafx.beans.binding.When;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.rbc.document.exception.NotFoundException;
import org.rbc.document.model.Configuration;
import org.rbc.document.repository.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by lena on 2017-04-04.
 */
@RunWith(SpringRunner.class)
@TestPropertySource(locations="classpath:application-test.properties")
@SpringBootTest
@Transactional
public class ConfigurationServiceImplTest {

    @Autowired
    ConfigurationService configurationService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void getJsonDocumentByAppCodeAndVersion() throws Exception {

        JSONObject configJson = new JSONObject();
        configJson.put("vendor","cisco");
        configJson.put("model", "firewall");
        configJson.put("ip", "123.255.255.255");
        configurationService.insertOrUpdateConfiguration("123", "001", configJson.toJSONString());

        JSONObject configuration = configurationService.getJsonDocumentByAppCodeAndVersion("123", "001");
        assertEquals(configuration.get("vendor").toString(), "cisco");
        assertEquals(configuration.get("model").toString(), "firewall");
        assertEquals(configuration.get("ip").toString(), "123.255.255.255");

    }

    @Test
    public void getAvailableVersions() throws Exception {

        JSONObject configJson1 = new JSONObject();
        configJson1.put("vendor","cisco");
        configJson1.put("model", "firewall");
        configJson1.put("ip", "123.255.255.255");
        configurationService.insertOrUpdateConfiguration("123", "001", configJson1.toJSONString());

        JSONObject configJson2 = new JSONObject();
        configJson2.put("vendor","cisco");
        configJson2.put("model", "firewall");
        configJson2.put("ip", "147.147.147.147");
        configurationService.insertOrUpdateConfiguration("123", "002", configJson2.toJSONString());

        JSONObject configJson3 = new JSONObject();
        configJson3.put("vendor","cisco");
        configJson3.put("model", "firewall");
        configJson3.put("ip", "333.222.111.123");
        configurationService.insertOrUpdateConfiguration("123", "003", configJson3.toJSONString());


        JSONArray jsonArray = configurationService.getAvailableVersions("123");
        assertEquals(jsonArray.size(), 3);
        assertEquals(jsonArray.get(0).toString(), "001");
        assertEquals(jsonArray.get(1).toString(), "002");
        assertEquals(jsonArray.get(2).toString(), "003");

    }

    @Test(expected = NotFoundException.class)
    public void testInvalidAppCode() throws Exception {

        JSONObject configJson = new JSONObject();
        configJson.put("vendor","cisco");
        configJson.put("model", "firewall");
        configJson.put("ip", "123.255.255.255");
        configurationService.insertOrUpdateConfiguration("123", "001", configJson.toJSONString());

        JSONObject configuration = configurationService.getJsonDocumentByAppCodeAndVersion("123-invalid", "001");
    }

    @Test(expected = NotFoundException.class)
    public void testInvalidVersion() throws Exception {

        JSONObject configJson = new JSONObject();
        configJson.put("vendor","cisco");
        configJson.put("model", "firewall");
        configJson.put("ip", "123.255.255.255");
        configurationService.insertOrUpdateConfiguration("123", "001", configJson.toJSONString());

        JSONObject configuration = configurationService.getJsonDocumentByAppCodeAndVersion("123", "00-invalid");
    }

}