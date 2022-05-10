package ru.agentgregory.parser.loader;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.security.auth.login.LoginException;

public class Loader {

    private RestTemplate restTemplate = new RestTemplate();

    public String load(String url){
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        if (response.getStatusCode().isError()){
            throw new ru.agentgregory.parser.loader.exception.LoadEx("bad status code"); //extends Exception

        }
    return response.getBody();
    }

}
