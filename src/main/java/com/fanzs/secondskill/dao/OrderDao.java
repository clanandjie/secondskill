package com.fanzs.secondskill.dao;

import com.fanzs.secondskill.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by fzs on 2018/4/10.
 */
@Mapper
public interface OrderDao {

    @Select("select goods.*,secondskill_goods.secondskill_stock_count,secondskill_goods.start_date,secondskill_goods.secondskill_price,secondskill_goods.end_date from secondskill_goods left join goods on secondskill_goods.goods_id=goods.goods_id")
    public List<GoodsVo> getGoodsVoList();

    @Select("select goods.*,secondskill_goods.secondskill_stock_count,secondskill_goods.start_date,secondskill_goods.end_date,secondskill_goods.secondskill_price from secondskill_goods left join goods on secondskill_goods.goods_id=goods.goods_id where goods.goods_id=#{goodsId} ")
    GoodsVo getGoodsVoById(@Param("goodsId") long goodsId);
}
