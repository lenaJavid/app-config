package org.rbc.document.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.rbc.document.model.Configuration;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by lena on 2017-04-04.
 */
public interface ConfigurationService {
    //Get methods
    JSONObject getJsonDocumentByAppCodeAndVersion(String appCode, String version);
    JSONArray getAvailableVersions(String appCode);

    //Insert Or Update Method
    ResponseEntity<String> insertOrUpdateConfiguration(String appCode, String version, String jsonConfig);
}
