package com.techelevator.dao;

import com.techelevator.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcUserDaoTests extends FinalCapstoneDaoTests {

    private JdbcUserDao sut;

    @Before
    public void setup() {
        DataSource dataSource = this.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcUserDao(jdbcTemplate);
    }

    @Test
    public void createNewUser() {
        User userCreated = sut.createUser("TEST_USER","test_password",
                "user", "firstname", "lastname","email", "phonenumber");
        Assert.assertTrue(true);
        User user = sut.findByUsername("TEST_USER");
        Assert.assertEquals("TEST_USER", user.getUsername());
    }

}
