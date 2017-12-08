package com.mybatis.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@Builder
@Alias("card")
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    private Integer id;
    private String code;
}
