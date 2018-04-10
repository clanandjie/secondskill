package com.fanzs.secondskill.controller;

import com.fanzs.secondskill.entity.SecondsKillUser;
import com.fanzs.secondskill.redis.RedisService;
import com.fanzs.secondskill.service.GoodsService;
import com.fanzs.secondskill.service.SecondskillUserService;
import com.fanzs.secondskill.vo.GoodsVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private SecondskillUserService secondskillUserService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private GoodsService goodsService;

    private static Logger log = LoggerFactory.getLogger(GoodsController.class);

    @RequestMapping("/to_list")
    public String getGoodsList(Model model,SecondsKillUser secondsKillUser){
        model.addAttribute("user", secondsKillUser);
        List<GoodsVo> goodsVoList=goodsService.getGoodsVoList();
        model.addAttribute("goodsVoList",goodsVoList);
        return "goods_list";
    }

    @RequestMapping("/to_detail/{goodsId}")
    public String getGoodsDetail(Model model,SecondsKillUser secondsKillUser,
    @PathVariable("goodsId")long goodsId){
        model.addAttribute("user", secondsKillUser);
        GoodsVo goodsVo = goodsService.getGoodsVoByGoodsId(goodsId);
        model.addAttribute("goodsVo",goodsVo);

        long nowTime=System.currentTimeMillis();
        long startime=goodsVo.getStartDate().getTime();
        long endTime=goodsVo.getEndDate().getTime();

        int secondskillStatus=0;
        long retSecond=-1;
        if(nowTime<startime){
            secondskillStatus=0;
            retSecond=(startime-nowTime)/1000;
        }else if(nowTime>endTime){
            secondskillStatus=1;
            retSecond=-1;
        }else{
            retSecond=0;
            secondskillStatus=2;
        }
        model.addAttribute("secondskillStatus",secondskillStatus);
        model.addAttribute("retSecond",retSecond);

        return "goods_detail";
    }
}
