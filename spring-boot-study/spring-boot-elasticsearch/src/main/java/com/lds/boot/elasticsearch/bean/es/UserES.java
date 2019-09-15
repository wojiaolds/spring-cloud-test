package com.lds.boot.elasticsearch.bean.es;/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 16:06 2019/9/15
 */

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 16:06 2019/9/15
 */
@Data
@Document(indexName = "test", type = "user", shards = 1, replicas = 0)
public class UserES {
    //主键自增长
    @Id
    private Long id;//主键

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String userName;
    private String userPhone;
}
