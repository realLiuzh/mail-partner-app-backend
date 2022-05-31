package com.youban.post;

import com.cqupt.query.PostQuery;
import com.cqupt.utils.R;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import javax.annotation.Resource;

//SpringBootTest.WebEnvironment.RANDOM_PORT 随机生成端口
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class YoubanApiPostApplicationTests {

    @Resource
    private TestRestTemplate restTemplate;

    @ParameterizedTest
    @CsvSource({"1,1,1"})
    void testSearchList(Integer isNewest, Integer isByHot, Integer groupId) {
        PostQuery postQuery = new PostQuery(isNewest, isByHot, groupId);
        R r = restTemplate.getForObject("/post/search/list", R.class, postQuery);
        System.out.println(r);
    }

}
