package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;

@Repository("Mybatis")
public class AlphaMImpl implements AlphaDao{
    @Override
    public String select() {
        return "Mybatis";
    }
}
