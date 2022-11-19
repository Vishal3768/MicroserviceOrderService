package com.vishal.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping(value = "/v1/order")
public class OrderItem {

    @Autowired
    private ItemContainer itemContainer;

    @PostMapping(value = "/orderItem")
    public String orderItem(@RequestBody Item item){
        Set<String> items=itemContainer.allItems();
        if(items.contains(item.getName()))
            return "Order Successfull";
        return "Order Unsuccessfull";
    }

    @PostMapping(value = "/addToCart")
    public String addToCart(@RequestBody Item item){
        System.out.println("------------------"+item.getName());
        String response=itemContainer.addToCart(item.getName());
        return response;
    }

    @PostMapping(value = "/deleteItemFromCart")
    public String delete(@RequestBody Item item){
        System.out.println("------------------"+item.getName());
        String response=itemContainer.deleteFromCart(item.getName());
        return response;
    }
}
