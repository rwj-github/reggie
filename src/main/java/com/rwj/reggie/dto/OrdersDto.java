package com.rwj.reggie.dto;


import com.rwj.reggie.pojo.OrderDetail;
import com.rwj.reggie.pojo.Orders;
import lombok.Data;
import java.util.List;

@Data
public class OrdersDto extends Orders {

    private String userName;

    private String phone;

    private String address;

    private String consignee;

    private List<OrderDetail> orderDetails;

    private int sumNum;
	
}
