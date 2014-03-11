package id.co.hans.sample.server.dao.impl;

import id.co.hans.sample.server.dao.TransaksiDao;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.jdbc.OracleTypes;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


// belum ditambahkan implements TransaksiDao

@Repository
public abstract class TransaksiDaoImpl {

    public static final Log log = LogFactory.getLog(TransaksiDaoImpl.class);

    @Autowired
    private JdbcTemplate  jdbcTemplate;
}
