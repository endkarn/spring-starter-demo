package com.example.demo.takecaredemo.democustomer;

import com.example.demo.takecaredemo.ApplicationConstant;
import com.example.demo.takecaredemo.DemoCustomerDto;
import javafx.scene.control.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DemoCustomerRepositoryImpl implements DemoCustomerRepository {

    private static final Logger logger = LoggerFactory.getLogger(DemoCustomerRepositoryImpl.class);

    @Override
    public List<DemoCustomerDto> searchCustomer(Connection conn, Object criteria, Pagination pagination, Object orderBy) throws Exception {
        return null;
    }

    @Override
    public Long insertCustomer(Connection conn, DemoCustomerDto dto) throws Exception {
        PreparedStatement ps = null;
        String columnNames[] = new String[] { "id" };
        Long insertID = 0L;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO tb_customer ( customer_code, firstname, lastname, nickname, gender, mobile, email, organization_id, recorder_id, create_date, editor_id, last_update ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) ");

            ps = conn.prepareStatement(sql.toString(), columnNames);
            int index = 1;

            ps.setString(index++, dto.getCustomerCode());
            ps.setString(index++, dto.getFirstname());
            ps.setString(index++, dto.getLastname());
            ps.setString(index++, dto.getNickname());
            ps.setString(index++, dto.getGender());
            ps.setString(index++, dto.getMobile());
            ps.setString(index++, dto.getEmail());
            ps.setLong(index++, dto.getOrganization() != null && dto.getOrganization().getId() != null ? dto.getOrganization().getId() : java.sql.Types.NULL);
            ps.setLong(index++, ApplicationConstant.PERSON_ID);
            ps.setTimestamp(index++, dto.getCreateDate());
            ps.setLong(index++, ApplicationConstant.PERSON_ID);
            ps.setTimestamp(index++, dto.getLastUpdate());


            logger.debug("Check SQL Insert Customer : " + ps.getMetaData());

            if (ps.executeUpdate() > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        insertID = generatedKeys.getLong(1);
                        dto.setId(insertID);

                    } else {
                        throw new SQLException("Creating CustomerID failed, no ID obtained.");
                    }
                }
            } else {
                throw new SQLException("Creating tb_customer failed, no rows affected.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex);
        } finally {
            try {
                if ((conn != null) && !conn.isClosed()) {
                    if (ps != null) {
                        ps.close();
                        ps = null;
                    }
                }
            } catch (Exception ex) {
                throw new Exception();
            }
        }

        return insertID;
    }

    @Override
    public boolean updateCustomer(Connection conn, DemoCustomerDto dto) throws Exception {
        return false;
    }

    @Override
    public boolean deleteCustomer(Connection conn, DemoCustomerDto dto) throws Exception {
        return false;
    }

    @Override
    public boolean clearCustomer(Connection conn, DemoCustomerDto dto) throws Exception {
        return false;
    }

    @Override
    public int countCustomer(Connection conn, Object criteria) throws Exception {
        return 0;
    }
}
