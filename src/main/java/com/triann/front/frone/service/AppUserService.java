package com.triann.front.frone.service;

import org.springframework.http.ResponseEntity; public interface AppUserService {

    ResponseEntity<String> searchfirstName(String firstName);
    ResponseEntity<String> searchlastName(String lastName);
    ResponseEntity<String> searchDeseription(String deseription);
    ResponseEntity<String> savrByRepository(String json);
    ResponseEntity<String> deleteData(Long id);
    ResponseEntity<String> appby(String json);
    ResponseEntity<String> searchFandL(String firstName,String lastName);
    ResponseEntity<String> Putsavebyclass (String appUserData, Long id);
}