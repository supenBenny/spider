package me.fb.spider.module.user.repository;

import me.fb.spider.module.user.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    public User getNameById(Long id);
}
