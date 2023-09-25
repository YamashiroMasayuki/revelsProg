package com.example.demo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.example.demo.*;

public class CommonWorkerService {

	//取得データのデータテーブル詰め込み時使用テーブル
	String[][] getData;
	private JdbcTemplate jdbc;
	
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

	//勤怠時間一覧の表示用
	public void tukiKeisan(int year, int month) {
		String[] calender3kagetu;
		String[] calender1kagetu;
		List<DataModel.Date> calendarDate = new ArrayList<DataModel.Date>();
		int henshuYear = Calendar.YEAR - 1;
		int henshuMonth = Calendar.MONTH - 1;
		int henshuDay = Calendar.DATE;
		int maxDate;

		//最初だけ1月の場合0になってしまう為12を入れる。
		if(henshuMonth == 0) {
			henshuMonth = 12;
		}
		for(int i=0; i < 3; i++) {
			switch(henshuMonth) {
				case 2:
					maxDate = 28;
					break;
				case 4,6,9,11:
					maxDate = 30;
					break;
				default:
					maxDate = 31;
					break;
			}

			for(int k=0; k < maxDate; k++) {
				DataModel.Date
				calendarDate[k] = henshuYear;
				
				
			}
			
			//月を一月分足す。
			if(henshuMonth == 12) {
				henshuMonth = 1;
				henshuYear = henshuYear + 1;
			}
			else {
				henshuMonth = henshuMonth + 1;
			}
			
			
			
		}
		
		
			
		
		
		
		
	}
	
	///////////////////////////////
	//SQL処理の記述
	///////////////////////////////

	//ログインするお客様の情報を取得する。
	public String getLoginCustomerData(String userID, String userPass) {

        String userIDKekka = "";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        sql = "select * ";
        sql += "from m_user ";
        sql += "where USER_ID = '" + userID + "' ";
        sql += "and USER_PASS = '" + userPass + "' " ;
 
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
                	userIDKekka = rs.getString("USER_ID");
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
    	return userIDKekka;
	}

	//システム利用者情報を取得する。
	public ResultSet getMUserData(String userID) {

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        sql = "select * ";
        sql += "from m_user ";
        sql += "where USER_ID = '" + userID + "' ";
 
        try {
            // 接続
            con = DriverManager.getConnection(conUrl, conUser, conPassword);
            // パラメータ付きSQL文をDBに送るためのオブジェクト生成
            pstmt = con.prepareStatement(sql);
            // SQL文の実行(データ取得)
            rs = pstmt.executeQuery();
 
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
    	return rs;
	}
	
	//勤怠情報の取得を行う。
	public int getKintaiDate(String userID) {

        int getFlg = 0;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        sql = "select * ";
        sql += "from m_dakoku ";
        sql += "where USER_ID = '" + userID + "' ";
        sql += "and DAKOKU_DATE = '" + getSystemDate() + "' " ;
 
        try {
            // 接続
            con = DriverManager.getConnection(conUrl, conUser, conPassword);
            // パラメータ付きSQL文をDBに送るためのオブジェクト生成
            pstmt = con.prepareStatement(sql);
            // SQL文の実行(データ取得)
            rs = pstmt.executeQuery();
 
            // データ取得したレコードの表示
            while (rs.next()) {
                if(rs.getString("USER_ID") != "") {
                	//データが取得でき、既にDBに存在する場合
                	getFlg = 1;
                }
                else {
                	//データが取得でき、DBには存在しない場合
                	getFlg = 2;
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
            	getFlg = 0;
                e.printStackTrace();
            }
 
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
            	getFlg = 0;
                e.printStackTrace();
            }
 
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
            	getFlg = 0;
                e.printStackTrace();
            }
        }
    	return getFlg;
	}

	//勤怠情報の更新を行う。
	public void insertKintaiDate(String userID) {

        Connection con = null;
        PreparedStatement pstmt = null;
        sql = "insert into m_dakoku ( USER_ID, DAKOKU_DATE )";
        sql += "value( '" + userID + "',' ";
        sql += "where USER_ID = '" + userID + "' " + getSystemDate() + "' " ;

        try {
            // 接続
            con = DriverManager.getConnection(conUrl, conUser, conPassword);
            // パラメータ付きSQL文をDBに送るためのオブジェクト生成
            pstmt = con.prepareStatement(sql);
            // SQL文の実行(データ更新)
            pstmt.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
	}
	
	//勤怠情報の更新を行う。
	//screenSFFlagは0:出勤ボタン、1:退勤ボタン
	public void setKintaiDate(String userID, String screenTime, int screenSFFlag) {

        Connection con = null;
        PreparedStatement pstmt = null;
        sql = "update m_dakoku ";
        sql += "set ";
        if(screenSFFlag == 0) {
            sql += "STARTWORK_TIME = '" + screenTime + "' ";
        }
        else {
            sql += "FINISHWORK_TIME = '" + screenTime + "' ";
        }
        sql += "where USER_ID = '" + userID + "' ";
        sql += "and DAKOKU_DATE = '" + getSystemDate() + "' ";
 
        try {
            // 接続
            con = DriverManager.getConnection(conUrl, conUser, conPassword);
            // パラメータ付きSQL文をDBに送るためのオブジェクト生成
            pstmt = con.prepareStatement(sql);
            // SQL文の実行(データ更新)
            pstmt.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
