package com.company.inc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Thiago Fontes on 28/08/2018.
 */
public class CriarBanco {
    private String query;
    private Connection conn;

    public CriarBanco (Connection conn) {
        this.conn = conn;
    }

    public void criaDB ( String sql) {
        String url = "jdbc:sqlite:src/com/company/database/local.db";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(query);
            executeDBScripts("G:\\BCK\\UFS\\2018.1\\EDS\\Real-CRM\\src\\com\\company\\database\\criaTabelas.sql",stmt);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean executeDBScripts(String aSQLScriptFilePath, Statement stmt) {
        boolean isScriptExecuted = false;
        try {
            BufferedReader in = new BufferedReader(new FileReader(aSQLScriptFilePath));
            String str;
            StringBuffer sb = new StringBuffer();
            while ((str = in.readLine()) != null) {
                sb.append(str + "\n ");
            }
            in.close();
            stmt.executeUpdate(sb.toString());
            isScriptExecuted = true;
        } catch (Exception e) {
            System.err.println("Failed to Execute" + aSQLScriptFilePath +". The error is"+ e.getMessage());
        }
        return isScriptExecuted;
    }
}
