package com.interswitch.UrlShortner.api.Resource;


import com.interswitch.UrlShortner.model.Response;
import com.interswitch.UrlShortner.model.UrlModel;
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
    UrlShortnerResource urlShortnerResource;

    @Test
    public void getUrl(){
        System.out.println(urlShortnerResource.getUrl("50328aa4"));

    }

    @Test
    public void createUrl(){
        UrlModel url = new UrlModel();
        url.setUrl("https://www.google.com");
        System.out.println(urlShortnerResource.create(url));

    }


}