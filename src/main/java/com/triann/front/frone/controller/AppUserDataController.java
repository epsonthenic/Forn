package com.triann.front.frone.controller;

import com.triann.front.frone.service.AppUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appUsers")
public class AppUserDataController {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/searchFandL")
    public String searchFandL(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName){
        return appUserService.searchFandL(firstName,lastName).getBody();
    }

    @GetMapping("/searchfirstName")
    public String searchfirstName(@RequestParam("firstName") String firstName) {
        LOGGER.info("firstName : {}",firstName);
        LOGGER.info("ServicefirName : {}",appUserService.searchfirstName(firstName).getBody());
        return appUserService.searchfirstName(firstName).getBody();
    }

    @GetMapping("/searchlastName")
    public String searchlastName(@RequestParam("lastName") String lastName) {
        return appUserService.searchlastName(lastName).getBody();
    }

    @GetMapping("/deseription")
    public String searchDeseription(@RequestParam("deseription") String deseription) {
        return appUserService.searchDeseription(deseription).getBody();
    }

    @PostMapping("/savebyjson")
    public String appby(@RequestBody String json) {
        return appUserService.appby(json).getBody();
    }
    @PostMapping("/Repository")
    public String savrByRepository(@RequestBody String json) {
        return appUserService.savrByRepository(json).getBody();
    }

    @DeleteMapping("/del/{id}")
    public void deleteData(@PathVariable("id") Long id){
        appUserService.deleteData(id);
    }

    @PutMapping("/Putbyclass/{id}")
    public String Putsavebyclass(@RequestBody String appUserData , @PathVariable("id") Long id){
        return appUserService.Putsavebyclass(appUserData,id).getBody();
    }

}
