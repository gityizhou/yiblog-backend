package com.zhouyi.yiblog.dao;

import com.zhouyi.yiblog.po.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {

    Type findByName(String name);
}
