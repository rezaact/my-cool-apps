package id.co.hans.sample.server.dao;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContext.xml"})
public class TesKoneksi {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testKoneksiDatabase() {
        System.out.println("hasil testKoneksiDatabase() ----v");
        System.out.println(jdbcTemplate.queryForInt("select count(*) from dual"));
    }


}
