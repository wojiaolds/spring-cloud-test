package com.lds.boot.elasticsearch.repository;/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 16:13 2019/9/15
 */

import com.lds.boot.elasticsearch.bean.es.UserES;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 16:13 2019/9/15
 */
public interface UserESRepository extends ElasticsearchRepository<UserES, Long> {}
