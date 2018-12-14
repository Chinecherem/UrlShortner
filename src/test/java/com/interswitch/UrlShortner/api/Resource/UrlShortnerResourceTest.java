package com.interswitch.UrlShortner.api.Resource;


import com.interswitch.UrlShortner.model.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UrlShortnerResourceTest {

    @Autowired
    private ResponseEntity responseEntity;

    @Test
    public void getUrl(){

    }

}