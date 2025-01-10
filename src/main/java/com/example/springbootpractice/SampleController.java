package com.example.springbootpractice;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;

@RestController
@RequestMapping(path = "/api")
public class SampleController {

    //user Client modifier
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, "firstName", new FirstNameEditor());
        binder.registerCustomEditor(String.class, "assetId", new AssetIdEditor());
    }


    //Get request with PathVariable
    @GetMapping(path = "/firstUser/{assetId}")
    public String getFirstNameId(@PathVariable(name = "assetId") String assetId) {
        System.out.println(Integer.valueOf(assetId));
        return "First Name Id: " + assetId;
    }

   /* In @RestController simple string return is enough, it return as HTTP response.
      In this case of @Controller , we can't return simply string alone

        public ResponseEntity<String> firstApi(@RequestParam(name = "firstname") String firstName, @RequestParam(name = "lastname", required = false) String lastName) {
            String output = "Hello World " + firstName + " " + lastName;
            return ResponseEntity.ok(output);
    }*/

    //Get request with RequestParam
    @GetMapping(path = "/firstUser")
    public String firstApi(@RequestParam(name = "firstname") String firstName, @RequestParam(name = "lastname", required = false) String lastName) {
        return "Hello World " + firstName + " " + lastName;
    }

    //Post request with body
    @PostMapping(path = "/firstUser")
    public String PostFirstName(@RequestBody User user) {
        System.out.println(user);
        return "user created successfully "+ user.userName + " : "+ user.email;
    }

}


class FirstNameEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(text.trim().toLowerCase());
    }
}

class AssetIdEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(text.substring(3));
    }
}

class User {

    @JsonProperty("user_name")
    String userName;
    String email;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
