package ru.agentgregory.parser.service.loader;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.security.auth.login.LoginException;
@Component
@RequiredArgsConstructor
public class Loader {

    private RestTemplate restTemplate;

    public String load(String url){
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
    /*    if (response.getStatusCode().isError()){
            throw new ru.agentgregory.parser.loader.exception.LoadEx("bad status code"); //extends Exception

        }
*/    return response.getBody();
    }

}
