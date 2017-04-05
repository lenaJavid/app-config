package org.rbc.document.service;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.rbc.document.exception.BadJsonFormatException;
import org.rbc.document.exception.NotFoundException;
import org.rbc.document.model.Builder.ConfigurationBuilder;
import org.rbc.document.model.Configuration;
import org.rbc.document.repository.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lena on 2017-04-04.
 */

@Service
public class ConfigurationServiceImpl implements ConfigurationService {

    @Autowired
    ConfigurationRepository configurationRepository;

    @Override
    public JSONObject getJsonDocumentByAppCodeAndVersion(String appCode, String version) {

        Configuration configuration = configurationRepository.findByAppCodeAndVersion(appCode, version);
        if(configuration != null) {
            try {
                return (JSONObject) new JSONParser().parse(configuration.getConfigDoc());
            } catch (ParseException e) {
                throw  new BadJsonFormatException("The configuration is not saved in a right json format!");
            }
        } else {
            throw new NotFoundException("Can not find the specified configuration");
        }
    }

    @Override
    public JSONArray getAvailableVersions(String appCode) {
        List<String> versionList = configurationRepository.findAvailableVersions(appCode);
        JSONArray jsonArray = new JSONArray();
        jsonArray.addAll(versionList);
        return jsonArray;
    }

    @Transactional
    @Override
    public ResponseEntity<String> insertOrUpdateConfiguration(String appCode, String version, String jsonConfig) {

        try {
            ConfigurationBuilder configBuilder = new ConfigurationBuilder();
            Configuration config = configBuilder.withAppCode(appCode).withVersion(version).withConfigDoc(jsonConfig).build();
            configurationRepository.saveAndFlush(config);
            return new ResponseEntity<String>(HttpStatus.OK);

        } catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
