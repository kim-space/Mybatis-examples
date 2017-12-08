package com.mybatis.mapper;

import com.mybatis.po.Card;

public interface CardMapper {

    int insertCard(Card card);

    Card getCard(Integer id);
}
