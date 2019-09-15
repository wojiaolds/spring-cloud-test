package com.lds.boot.elasticsearch.controller;/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 16:17 2019/9/15
 */

import com.lds.boot.elasticsearch.bean.es.UserES;
import com.lds.boot.elasticsearch.repository.UserESRepository;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 16:17 2019/9/15
 */
@RestController
public class UserController {

    @Autowired
    private UserESRepository repositoryES;

    @GetMapping("/create")
    public String create(
            @RequestParam("id") Long id,
            @RequestParam("userName") String userName,
            @RequestParam("userPhone") String userPhone) {
        UserES userES = new UserES();
        userES.setId(id);
        userES.setUserName(userName);
        userES.setUserPhone(userPhone);
        return repositoryES.save(userES).toString();
    }

    private String names;

    @GetMapping("/get")
    public String get() {
        names = "";
        Iterable<UserES> userES = repositoryES.findAll();
        userES.forEach(userES1 -> {
            names += userES1.toString() + "\n";
        });
        return names;
    }

    private String searchs = "";

    @GetMapping("/search")
    public String search(@RequestParam("searchKey") String searchKey) {
        searchs = "";
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本分词查询
        queryBuilder.withQuery(QueryBuilders.matchQuery("userName", searchKey));
        // 搜索，获取结果
        Page<UserES> items = repositoryES.search(queryBuilder.build());
        // 总条数
        long total = items.getTotalElements();
        searchs += "总共数据数：" + total + "\n";
        items.forEach(userES -> {
            searchs += userES.toString() + "\n";
        });
        return searchs;
    }
}
