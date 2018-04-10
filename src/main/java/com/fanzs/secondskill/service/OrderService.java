package com.fanzs.secondskill.service;

import com.fanzs.secondskill.dao.OrderDao;
import com.fanzs.secondskill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fzs on 2018/4/10.
 */
@Service
public class OrderService {

    @Autowired
    GoodsService goodsService;
    @Autowired
    OrderDao orderDao;


}
