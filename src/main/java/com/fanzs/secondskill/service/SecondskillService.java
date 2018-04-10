package com.fanzs.secondskill.service;

import com.fanzs.secondskill.dao.GoodsDao;
import com.fanzs.secondskill.entity.OrderInfo;
import com.fanzs.secondskill.entity.SecondsKillUser;
import com.fanzs.secondskill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fzs on 2018/4/10.
 */
@Service
public class SecondskillService {

    @Autowired
    GoodsService goodsService;


    public OrderInfo secondskill(SecondsKillUser secondsKillUser, GoodsVo goodsVo) {


        return null;
    }
}
