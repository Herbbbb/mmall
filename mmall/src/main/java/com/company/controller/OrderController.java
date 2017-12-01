package com.company.controller;

import com.company.common.Const;
import com.company.common.ServerResponse;
import com.company.pojo.User;
import com.company.service.OrderService;
import com.company.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/11/29.
 */
@Controller
@RequestMapping("/order/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "create.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<OrderVo> createOrder(HttpSession session,Integer shippingId){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        Integer userId = user.getId();
        ServerResponse serverResponse = orderService.createOrder(userId,shippingId);
        return serverResponse;
    }

    @RequestMapping(value = "get_order_cart_product.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getOrderProductInfo(HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        Integer userId = user.getId();
        ServerResponse serverResponse = orderService.getOrderProduct(userId);
        return serverResponse;
    }

    @RequestMapping(value = "list.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getList(HttpSession session, @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,@RequestParam(value = "pageNum",defaultValue = "1") int pageNum){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        Integer userId = user.getId();
        ServerResponse serverResponse = orderService.getOrderList(userId,pageSize,pageNum);
        return serverResponse;
    }

    @RequestMapping(value = "detail.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getOrderDetailByUser(HttpSession session, Long orderNo){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        Integer userId = user.getId();
        ServerResponse serverResponse = orderService.getOrderDetail(userId,orderNo);
        return serverResponse;
    }

    @RequestMapping(value = "cancel.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse cancelOrder(HttpSession session, Long orderNo){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        Integer userId = user.getId();
        ServerResponse serverResponse = orderService.cancelOrder(userId,orderNo);
        return serverResponse;
    }

}
