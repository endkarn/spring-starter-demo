package com.example.demo.service.customer;

import com.example.demo.common.ApplicationConstant;
import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.OrganizationDataDto;
import com.example.demo.dto.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public CustomerDto findCustomerById(Connection conn, Long customerId) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        CustomerDto customerDto = new CustomerDto();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM tb_customer WHERE id = ?");
        ps = conn.prepareStatement(sql.toString());
        ps.setLong(1, customerId);
        rs = ps.executeQuery();

        while (rs.next()) {
            customerDto = populateToDto(rs);
        }
        return customerDto;
    }


    @Override
    public List<CustomerDto> searchCustomer(Connection conn, Object criteria) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<CustomerDto> customerDtoList = new ArrayList<>();
        HashMap<String, Object> criteriaHmap = new ObjectMapper().convertValue(criteria, HashMap.class);

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM tb_customer WHERE is_deleted <> 1 ");
        if (criteriaHmap.containsKey("id")) {
            sql.append("AND id = ? ");
        }
        if (criteriaHmap.containsKey("firstname")) {
            sql.append("AND firstname LIKE '%" + criteriaHmap.get("firstname").toString() + "%' ");
        }
        if (criteriaHmap.containsKey("lastname")) {
            sql.append("AND lastname LIKE '%" + criteriaHmap.get("lastname").toString() + "%' ");
        }
        if (criteriaHmap.containsKey("nickname")) {
            sql.append("AND nickname LIKE '%" + criteriaHmap.get("nickname").toString() + "%' ");
        }

        ps = conn.prepareStatement(sql.toString());
        int index = 1;
        if (criteriaHmap.containsKey("id")) {
            ps.setLong(index++, Long.valueOf(criteriaHmap.get("id").toString()));
        }

        rs = ps.executeQuery();
        while (rs.next()) {
            CustomerDto customerDto = new CustomerDto();
            customerDto = populateToDto(rs);
            customerDtoList.add(customerDto);
        }
        return customerDtoList;
    }

    @Override
    public Long insertCustomer(Connection conn, CustomerDto customerDto) {
        PreparedStatement ps = null;
        String columnNames[] = new String[]{"id"};
        Long insertID = 0L;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO tb_customer (");
            sql.append("customer_code,");
            sql.append("firstname,");
            sql.append("lastname,");
            sql.append("nickname,");
            sql.append("gender,");
            sql.append("mobile,");
            sql.append("email,");
            sql.append("organization_id,");

            sql.append("recorder_id,");
            sql.append("editor_id)");

            sql.append(" VALUES (?,?,?,?,?,?,?,?,?,?)");

            ps = conn.prepareStatement(sql.toString(), columnNames);
            int index = 1;

            ps.setString(index++, customerDto.getCustomerCode());
            ps.setString(index++, customerDto.getFirstname());
            ps.setString(index++, customerDto.getLastname());
            ps.setString(index++, customerDto.getNickname());
            ps.setString(index++, customerDto.getGender());
            ps.setString(index++, customerDto.getMobile());
            ps.setString(index++, customerDto.getEmail());
            ps.setLong(index++, customerDto.getOrganization() != null ? customerDto.getOrganization().getId() : Types.NULL);

            ps.setLong(index++, ApplicationConstant.PERSON_ID);
            ps.setLong(index++, ApplicationConstant.PERSON_ID);

            if (ps.executeUpdate() > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        insertID = generatedKeys.getLong(1);
                        customerDto.setId(insertID);

                    } else {
                        throw new SQLException("Creating Customer failed, no ID obtained.");
                    }
                }
            } else {
                throw new SQLException("Creating tb_customer failed, no rows affected.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insertID;
    }

    @Override
    public boolean updateCustomer(Connection conn, CustomerDto customerDto) throws SQLException {

        boolean addResult = false;
        CustomerDto customerDto1 = customerDto;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE tb_customer SET customer_code = ?,");
        sql.append("firstname = ?,");
        sql.append("lastname = ?,");
        sql.append("nickname = ?,");
        sql.append("gender = ?,");
        sql.append("mobile = ?,");
        sql.append("email = ?,");
        sql.append("organization_id = ?,");

        sql.append("recorder_id = ?,");
        sql.append("editor_id = ? ");
        sql.append("WHERE id = ? ");

        System.out.println(customerDto1.getId());
        System.out.println(customerDto1.getFirstname());
        System.out.println(customerDto1.getLastname());
        System.out.println(customerDto1.getNickname());
        System.out.println(customerDto1.getEmail());

        String sqlt = "UPDATE tb_customer SET customer_code = ?,firstname = ?,lastname = ?,nickname = ?,gender = ?," +
                "mobile = ?,email = ?,organization_id = ?,recorder_id = ?,editor_id = ? WHERE id = ? ";

        PreparedStatement preparedStatement = conn.prepareStatement(sqlt);

        int index = 1;

        preparedStatement.setString(index++, customerDto1.getCustomerCode());
        preparedStatement.setString(index++, customerDto1.getFirstname());
        preparedStatement.setString(index++, customerDto1.getLastname());
        preparedStatement.setString(index++, customerDto1.getNickname());
        preparedStatement.setString(index++, customerDto1.getGender());
        preparedStatement.setString(index++, customerDto1.getMobile());
        preparedStatement.setString(index++, customerDto1.getEmail());
        preparedStatement.setLong(index++, customerDto1.getOrganization() != null ? customerDto1.getOrganization().getId() : Types.NULL);

        preparedStatement.setLong(index++, ApplicationConstant.PERSON_ID);
        preparedStatement.setLong(index++, ApplicationConstant.PERSON_ID);
        preparedStatement.setLong(index++, customerDto1.getId());


        if (preparedStatement.executeUpdate() == 1){
            addResult = true;
        }

        preparedStatement.close();
        return addResult;
    }

    private CustomerDto populateToDto(ResultSet rs) throws SQLException {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(rs.getLong("id"));
        customerDto.setCustomerCode(rs.getString("customer_code"));
        customerDto.setFirstname(rs.getString("firstname"));
        customerDto.setLastname(rs.getString("lastname"));
        customerDto.setNickname(rs.getString("nickname"));
        customerDto.setGender(rs.getString("gender"));
        customerDto.setMobile(rs.getString("mobile"));
        customerDto.setEmail(rs.getString("email"));

        customerDto.setOrganization(new OrganizationDataDto());
        customerDto.getOrganization().setId(rs.getLong("organization_id"));

        customerDto.setActive(rs.getBoolean("is_active"));
        customerDto.setDeleted(rs.getBoolean("is_deleted"));

        customerDto.setCreateDate(rs.getTimestamp("create_date"));
        customerDto.setLastUpdate(rs.getTimestamp("last_update"));


        UserDto recorder = new UserDto();
        recorder.setId(rs.getLong("recorder_id"));
        customerDto.setRecorder(recorder);


        UserDto editor = new UserDto();
        editor.setId(rs.getLong("editor_id"));
        customerDto.setEditor(editor);


        return customerDto;
    }
}
