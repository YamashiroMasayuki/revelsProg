package com.example.demo;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommonWorkerService {

	//取得データのデータテーブル詰め込み時使用テーブル
	String[][] getData;
	
	//DB処理時使用定数
	String conUrl = "jdbc:mysql://localhost/clockdb";
    String conUser = "root";
    String conPassword = "mysql1masa2";
    String sql;
	
	//ログアウト時セッション情報を初期化
	public void SessionClear() {

		//Session[""] = null;
	}
	
	//システム年月日の取得(yyyyMMdd型)
	public String getSystemDate() {

		Calendar cl = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		sdf.format(cl.getTime());
		return sdf.toString();
	}

	//ログインするお客様の情報を取得する。
	public String getLoginCustomerData(String userID, String userPass) {

        String adminFlg = "";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        sql = "select * ";
        sql += "from user";
        sql += "where USER_ID = " + userID ;
        sql += " and USER_PASS = " + userPass ;
 
        try {
            // 接続
            con = DriverManager.getConnection(conUrl, conUser, conPassword);
            // パラメータ付きSQL文をDBに送るためのオブジェクト生成
            pstmt = con.prepareStatement(sql);
            // SQL文の実行(データ取得)
            rs = pstmt.executeQuery();
 
            // データ取得したレコードの表示
            while (rs.next()) {
                if(rs.getString("USER_FIRSTNAME") != "") {
                	adminFlg = rs.getString("IS_ADMINISTRATOR");
                }
            }
 
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
 
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
 
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
 
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    	return adminFlg;
	}
	
	//画面表示用のお客様の情報を取得する。
	public String[][] getUserData(String userID, String userFName, String userLName) {

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        sql = "select * ";
        sql += "from user";
        sql += "where 1 = 1" ;
        if(userID.trim() != "") {
            sql += " and USER_ID Like %" + userID + "%";
        }
        if(userFName.trim() != "") {
            sql += " and USER_FIRSTNAME Like %" + userFName + "%";
        }
        if(userLName.trim() != "") {
            sql += " and USER_LASTNAME Like %" + userLName + "%";
        }
 
        try {
            // 接続
            con = DriverManager.getConnection(conUrl, conUser, conPassword);
            // パラメータ付きSQL文をDBに送るためのオブジェクト生成
            pstmt = con.prepareStatement(sql);
            // SQL文の実行(データ取得)
            rs = pstmt.executeQuery();
 
            //取得データ代入配列を宣言。
            getData = new String[rs.getRow()][9];
            int i = 0;
            
            // データ取得したレコードの表示
            while (rs.next()) {
            	getData[i][0] = rs.getString("USER_ID");
            	getData[i][1] = rs.getString("USER_PASS");
            	getData[i][2] = rs.getString("USER_FIRSTNAME");
            	getData[i][3] = rs.getString("USER_LASTNAME");
            	getData[i][4] = rs.getString("USER_YUKYUBI");
            	getData[i][5] = rs.getString("UPDATE_DAY");
            	getData[i][6] = rs.getString("CREATE_DAY");
            	getData[i][7] = rs.getString("IS_DLTFLG");
            	getData[i][8] = rs.getString("IS_ADMINISTRATOR");
            	i++;
            }
 
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {rs.close();}
            } catch (SQLException e) {e.printStackTrace();}
 
            try {
                if (pstmt != null) {pstmt.close();}
            } catch (SQLException e) {e.printStackTrace();}
 
            try {
                if (con != null) {con.close();}
            } catch (SQLException e) {e.printStackTrace();}
            
        }
        return getData;
	}
	
}
