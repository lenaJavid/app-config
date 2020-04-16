package org.rbc.document.controller;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.rbc.document.model.Builder.ConfigurationBuilder;
import org.rbc.document.model.Configuration;
import org.rbc.document.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.json.simple.JSONObject;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by lena on 2017-04-04.
 */
@RestController
public class ConfigurationController {
    @Autowired
    ConfigurationService configService;

    /////jhgjhgjhgjhgjhgghfhgfhgfhfghs
    @RequestMapping(value = "/app/{appCode}/config/{version}", method = RequestMethod.GET)
    public JSONObject getJsonDocument(@PathVariable(name = "appCode") String appCode,
                                  @PathVariable(name = "version") String version){

        return configService.getJsonDocumentByAppCodeAndVersion(appCode, version);
    }

    @RequestMapping(value = "/app/{appCode}/config", method = RequestMethod.GET)
    public JSONArray getAvailableVersions(@PathVariable(name = "appCode") String appCode){

        return configService.getAvailableVersions(appCode);
    }

    @RequestMapping(value = "/app/{appCode}/config/{version}", method = RequestMethod.POST)
    public ResponseEntity<String> insertOrUpdateAppConfiguration(@PathVariable(name = "appCode", required = true) String appCode,
                                                         @PathVariable(name = "version", required = true) String version,
                                                         @Valid @RequestBody JSONObject jsonConfig){

        return configService.insertOrUpdateConfiguration(appCode, version, jsonConfig.toJSONString());
    }

}
