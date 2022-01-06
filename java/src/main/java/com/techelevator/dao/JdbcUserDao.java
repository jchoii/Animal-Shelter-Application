package com.techelevator.dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.techelevator.model.User;

@Service
public class JdbcUserDao implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User findIdByUsername(String username) {
        return jdbcTemplate.queryForObject("select user_id from users where username = ?", User.class, username);
    }

	@Override
	public User getUserById(Long userId) {
		String sql = "SELECT * FROM users WHERE user_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
		if(results.next()) {
			return mapRowToUser(results);
		} else {
			throw new RuntimeException("userId "+userId+" was not found.");
		}
	}

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            User user = mapRowToUser(results);
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findAllApproved() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE is_approved = true;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            User user = mapRowToUser(results);
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findAllPending() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE is_approved = FALSE AND is_Rejected = FALSE;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            User user = mapRowToUser(results);
            users.add(user);
        }
        return users;
    }
    @Override
    public User findByUsername(String username) throws UsernameNotFoundException {
        for (User user : this.findAll()) {
            if( user.getUsername().toLowerCase().equals(username.toLowerCase())) {
                return user;
            }
        }
        throw new UsernameNotFoundException("User " + username + " was not found.");
    }

    @Override
    public User createUser(String username, String password, String role, String firstname, String lastname,
                              String email, String phone) {
        boolean userCreated = false;

        // create user
        String insertUser = "insert into users (username,password_hash,role, first_name, " +
                "last_name, email, phone) values(?,?,?,?,?,?,?)";
        String password_hash = new BCryptPasswordEncoder().encode(password);
        String ssRole = "ROLE_" + role.toUpperCase();

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        String id_column = "user_id";
        userCreated = jdbcTemplate.update(con -> {
                    PreparedStatement ps = con.prepareStatement(insertUser, new String[]{id_column});
                    ps.setString(1, username);
                    ps.setString(2, password_hash);
                    ps.setString(3, ssRole);
                    ps.setString(4, firstname);
                    ps.setString(5, lastname);
                    ps.setString(6, email);
                    ps.setString(7, phone);
                    return ps;
                }
                , keyHolder) == 1;
        Long newUserId = Long.parseLong(keyHolder.getKeys().get(id_column).toString());
        User user = new User();

        return getUserById(newUserId);
    }

    @Override
    public User updateIsApproved(Long id) {
        String sql = "UPDATE users SET is_approved = true WHERE user_id = ?";
        int newId = jdbcTemplate.update(sql, id);
        return getUserById(id);
    }

    @Override
    public User updateIsRejected(Long id) {
        String sql = "UPDATE users SET is_rejected = true WHERE user_id = ?";
        int newId = jdbcTemplate.update(sql, id);
        return getUserById(id);
    }

    @Override
    public User updateNewUser(Long id){
        String sql = "UPDATE users SET new_user = FALSE WHERE user_id = ?";
        int newId = jdbcTemplate.update(sql, id);
        return getUserById(id);
    }

    private User mapRowToUser(SqlRowSet rs) {
        User user = new User();
        user.setId(rs.getLong("user_id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password_hash"));
        user.setAuthorities(rs.getString("role"));
        user.setActivated(true);
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setEmail(rs.getString("email"));
        user.setPhone(rs.getString("phone"));
        user.setApproved(rs.getBoolean("is_approved"));
        user.setRejected(rs.getBoolean("is_rejected"));
        user.setNewUser(rs.getBoolean("new_user"));
        return user;
    }
}