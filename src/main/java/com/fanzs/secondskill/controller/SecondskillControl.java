package com.fanzs.secondskill.controller;

import com.fanzs.secondskill.entity.SecondsKillUser;
import com.fanzs.secondskill.redis.RedisService;
import com.fanzs.secondskill.result.CodeMsg;
import com.fanzs.secondskill.service.GoodsService;
import com.fanzs.secondskill.service.OrderService;
import com.fanzs.secondskill.service.SecondskillService;
import com.fanzs.secondskill.service.SecondskillUserService;
import com.fanzs.secondskill.vo.GoodsVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by fzs on 2018/4/11.
 */
@Controller
@RequestMapping("/secondskill")
public class SecondskillControl {
    @Autowired
    private SecondskillUserService secondskillUserService;
    @Autowired
    private SecondskillService secondskillService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private OrderService orderService;
    private static Logger log= LoggerFactory.getLogger(LoginController.class);
    @RequestMapping("/do_secondskill")
    public String list(Model model, SecondsKillUser secondsKillUser,
                       @RequestParam("goodsId")long goodsId){
        model.addAttribute("user",secondsKillUser);
        if(secondsKillUser==null){
            return "login";
        }
        GoodsVo goodsVo = goodsService.getGoodsVoByGoodsId(goodsId);
        if(goodsVo.getSecondskillStockCount()<=0){
            model.addAttribute("errmsg", CodeMsg.BIND_ERROR);
            return "secondskill_fail";
        }

        secondskillService.secondskill(secondsKillUser,goodsVo);
        return "goods_list";
    }
}
