package com.triann.front.frone.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
public class AppUserServiceImpl implements AppUserService {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Value("${engine.url}")
    private String ENGINE_URL;

    @Override
    public ResponseEntity<String> searchfirstName(String firstName) {
        RestTemplate restTemplate = new RestTemplate();
        String url = ENGINE_URL.concat("/appUserDataCustom/firstName");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("firstName", firstName);
                //.encode(UTF_8);
        HttpEntity<String> entity = new HttpEntity<String>("", headers);
        LOGGER.info("request :{}", url);
        try {
            return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
        } catch (Exception e) {
            LOGGER.error("{}", e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity<String> searchlastName(String lastName) {
        RestTemplate restTemplate = new RestTemplate();
        String url = ENGINE_URL.concat("/appUserDataCustom/lastName");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).queryParam("lastName", lastName);
        HttpEntity<String> entity = new HttpEntity<String>("", headers);
        LOGGER.info("request :{}", url);
        try {
            return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
        } catch (Exception e) {
            LOGGER.error("{}", e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity<String> searchDeseription(String deseription) {
        RestTemplate restTemplate = new RestTemplate();
        String url = ENGINE_URL.concat("/appUserDataCustom/deseription");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).queryParam("deseription", deseription);
        HttpEntity<String> entity = new HttpEntity<String>("", headers);
        LOGGER.info("request :{}", url);
        try {
            return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
        } catch (Exception e) {
            LOGGER.error("{}", e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity<String> appby(String json) {
        LOGGER.info("{}",json);
        RestTemplate restTemplate = new RestTemplate();
        String url = ENGINE_URL.concat("/appUserDataCustom/savebyjson");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<String>(json, headers);
        LOGGER.info("request :{}", url);
        try {
            return restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        } catch (Exception e) {
            LOGGER.error("{}", e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity<String> savrByRepository(String json) {
        LOGGER.info("{}",json);
        RestTemplate restTemplate = new RestTemplate();
        String url = ENGINE_URL.concat("/appUserDatas");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<String>(json, headers);
        LOGGER.info("request :{}", url);
        try {
            return restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        } catch (Exception e) {
            LOGGER.error("{}", e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity<String> deleteData(Long id) {
        LOGGER.info("{}",id);
        RestTemplate restTemplate = new RestTemplate();
        String url = ENGINE_URL.concat("/appUserDataCustom/del/"+ id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<String>("id", headers);
        LOGGER.info("request :{}", url);
        try {
            return restTemplate.exchange(url, HttpMethod.DELETE, entity, String.class);
        } catch (Exception e) {
            LOGGER.error("{}", e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity<String> searchFandL(String firstName, String lastName) {
        RestTemplate restTemplate = new RestTemplate();
        String url = ENGINE_URL.concat("/appUserDataCustom/fandl");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("firstName", firstName)
                .queryParam("lastName", lastName);
        HttpEntity<String> entity = new HttpEntity<String>("", headers);
        LOGGER.info("request :{}", url);
        try {
            return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
        } catch (Exception e) {
            LOGGER.error("{}", e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity<String> Putsavebyclass(String appUserData, Long id) {
        LOGGER.info("{}",id);
        RestTemplate restTemplate = new RestTemplate();
        String url = ENGINE_URL.concat("/appUserDataCustom/Putbyclass/"+ id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<String>(appUserData, headers);
        LOGGER.info("request :{}", url);
        try {
            return restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
        } catch (Exception e) {
            LOGGER.error("{}", e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}