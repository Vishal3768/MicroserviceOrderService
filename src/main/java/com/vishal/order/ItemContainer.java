package com.vishal.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ItemContainer {

    private RestTemplate restTemplate=new RestTemplate();

    public Set<String> allItems(){
        String[] items=restTemplate.getForObject("http://localhost:8081/v1/cart/allItems",String[].class);
        return Arrays.stream(items).collect(Collectors.toSet());
    }

    public String addToCart(String name) {
        String response=restTemplate.getForObject("http://localhost:8081/v1/cart/addToCart/"+name,String.class);
        return response;
    }

    public String deleteFromCart(String name) {
        return restTemplate.getForObject("http://localhost:8081/v1/cart/deleteItem/"+name,String.class);
    }
}
