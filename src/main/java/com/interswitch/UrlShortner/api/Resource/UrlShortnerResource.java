package com.interswitch.UrlShortner.api.Resource;

import com.interswitch.UrlShortner.model.Response;
import com.interswitch.UrlShortner.model.UrlModel;
import com.interswitch.UrlShortner.model.UrlShortnerResponse;
import org.apache.commons.validator.routines.UrlValidator;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.common.hash.Hashing;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;


@RestController
@RequestMapping("/api/url")
public class UrlShortnerResource {


    StringRedisTemplate redisTemplate;

    public UrlShortnerResource(StringRedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @RequestMapping(value="/{Id}", method = RequestMethod.GET)
    public ResponseEntity getUrl(@PathVariable String Id, HttpServletResponse resp) throws IOException {
        Response response = null;
            String Longurl = redisTemplate.opsForValue().get(Id);
            if (Longurl == null) {
                response = new UrlShortnerResponse("404", "Invalid Url", null, Longurl);

            }
            else{
                response= new UrlShortnerResponse("200", "Successfully Retrieved Url", null, Longurl);
            }
            System.out.println("URL Retrieved: " + Longurl);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(Longurl));
        System.out.println(Longurl);
        return new ResponseEntity<Response>(headers, HttpStatus.MOVED_PERMANENTLY);

//        return response;
    }

    @PostMapping
    public Response create(@RequestBody UrlModel url){
        Response response = null;
        String status = "Url Shortened";
        UrlValidator urlValidator = new UrlValidator(
                new String[]{"http", "https"}
        );
        try {
            if (urlValidator.isValid(url.getUrl())) {
                String Id = Hashing.murmur3_32().hashString(url.getUrl(), StandardCharsets.UTF_8).toString();
                System.out.println("Generated Id: " + Id);
                redisTemplate.opsForValue().set(Id, url.getUrl());
                response = new UrlShortnerResponse("200", "Successfull", null, "http://localhost:8080/api/url/"+Id);
            }
        }catch (Exception e){
            status = e.getMessage();
        }
        return response;
    }
}
