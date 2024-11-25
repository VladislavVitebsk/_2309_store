package by.itclass.model.services;

import by.itclass.model.entities.OrderItem;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import static by.itclass.constants.AppConst.ORDER_ITEMS_ATTR;

public class CartService {
    private static CartService service;
    private CartService(){}
    public static CartService getInstance(){
//        if(service == null){
//            service = new CartService();
        return service == null ? new CartService() : service;
        }
//        return service;
    public List<OrderItem> processCart(HttpSession session, String cartAction, OrderItem item){
        var orderItems = session.getAttribute(ORDER_ITEMS_ATTR);
        List<OrderItem> items = orderItems != null ? (List<OrderItem>) orderItems : new ArrayList<>();
        switch (cartAction) {
            case "add" -> items.add(item);
            case "remove" -> items.remove(item);
        }
        return items;
    }
}
