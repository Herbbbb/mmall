package com.company.controller;

import com.company.common.Const;
import com.company.common.ResponseCode;
import com.company.common.ServerResponse;
import com.company.pojo.User;
import com.company.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/11/30.
 */
@Controller
@RequestMapping("/manage/order/")
public class ManageOrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "list.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse managerOrderList(HttpSession session, @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,@RequestParam(value = "pageNum",defaultValue = "1")int pageNum){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createErrorCodeMsg(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录");
        }
        if(user.getRole() != Const.UserRole.MANAGER.getCode()){
            return ServerResponse.createByErrorMessage("没有权限");
        }
        ServerResponse serverResponse = orderService.manageOrderList(pageSize,pageNum);
        return serverResponse;
    }

    @RequestMapping(value = "search.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse managerSearchByOrderNo(HttpSession session,Long orderNo, @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,@RequestParam(value = "pageNum",defaultValue = "1")int pageNum){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createErrorCodeMsg(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录");
        }
        if(user.getRole() != Const.UserRole.MANAGER.getCode()){
            return ServerResponse.createByErrorMessage("没有权限");
        }
        ServerResponse serverResponse = orderService.manageSearchByOrderNo(pageSize,pageNum,orderNo);
        return serverResponse;
    }

    @RequestMapping(value = "detail.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse managerOrderDetail(HttpSession session,Long orderNo){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createErrorCodeMsg(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录");
        }
        if(user.getRole() != Const.UserRole.MANAGER.getCode()){
            return ServerResponse.createByErrorMessage("没有权限");
        }
        ServerResponse serverResponse = orderService.manageOrderDetail(orderNo);
        return serverResponse;
    }

    @RequestMapping(value = "send_goods.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse managerSendGood(HttpSession session,Long orderNo){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createErrorCodeMsg(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录");
        }
        if(user.getRole() != Const.UserRole.MANAGER.getCode()){
            return ServerResponse.createByErrorMessage("没有权限");
        }
        ServerResponse serverResponse = orderService.managerOrderSendGood(orderNo);
        return serverResponse;
    }
}
