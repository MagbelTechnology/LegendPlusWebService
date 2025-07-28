package com.magbel.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Report extends PersistenceServiceDAO {

	DatetimeFormat format = new DatetimeFormat();

    public String getCompanyName() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = ""; 
        String comp = "";

        try {
            query = "SELECT COMPANY_NAME FROM am_gb_company";
            con = getConnection("legendPlus");
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {

                comp = rs.getString("COMPANY_NAME");

            }


        } catch (Exception e) {
            System.out.println("WARNING: cannot fetch am_gb_company->" +
                    e.getMessage());

        } finally {
            closeConnection(con, ps, rs);
        }

        return comp;

    }



    public ArrayList getReportByColumn(String query, String[] selCol) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        // Approval app = null;
        ArrayList collection = new ArrayList();
        int count = selCol.length;

        for (int i = 0; i < count; i++) {

        // System.out.println("SELECTED COLUMNS IN getReportByColumn : " + i + " " + selCol[i]);

        }

        int rowCount = 0;

        //String[] temp = new String[count];
        ArrayList rows = new ArrayList();


        String FINDER_QUERY = query;
 //       System.out.println("<<<<<<<FINDER_QUERY in getReportByColumn: "+FINDER_QUERY);
        try {
            con = getConnection("legendPlus");
            ps = con.prepareStatement(FINDER_QUERY);

            //ps.setString(1, "Y");
            rs = ps.executeQuery();

            //  String query = "Select +query+ from am_raisentry_post  ";

 //           System.out.println("Report Compilation in Progress.......::: " + selCol.length + "  Columns");


            /*while (rs.next()){
            ArrayList row = new ArrayList();
            for (int i = 1; i <= columnCount ; i++){
            row.add(rs.getString(i));
            }
            rows.add(row);
            }
             */
            while (rs.next()) {
                rowCount++;
                //ArrayList row = new ArrayList();
                String[] temp = new String[count];
                //for(int i = 0; i<count;i++){
                for (int i = 0; i < count; i++) {

                    temp[i] = rs.getString(findColById(selCol[i]));
                 //   System.out.println("SEE the COLUMNS: " + i + " " + temp[i]);
                   // rows.add(temp[i]);

                }

                rows.add(temp);

            }

//System.out.println("TOTAL ROW COUNT<<:::>> " + rowCount);

        } catch (Exception ex) {
            System.out.println("WARNING: cannot fetch the column for the report  <><>>>:  " +
                    ex.getMessage());
        } finally {
            closeConnection(con, ps, rs);
        }
        return rows;
    }


    public ArrayList getTabletById(
            String query, String[] selCol) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        // Approval app = null;
        ArrayList collection = new ArrayList();
        int count = selCol.length;

        String[] temp = new String[count];

        String FINDER_QUERY = query;
//        System.out.println("<<<<<<<FINDER_QUERY in getTabletById: "+FINDER_QUERY);
        try {
            con = getConnection("legendPlus");
            ps =
                    con.prepareStatement(FINDER_QUERY);

            //ps.setString(1, "Y");
            rs =
                    ps.executeQuery();

            //  String query = "Select +query+ from am_raisentry_post  ";

            while (rs.next()) {
                for (int i = 0; i < count;
                        i++) {
                    temp[i] = rs.getString(findTabById(selCol[i]));

                   // System.out.println("SEE the TABLE: " + i + " " + temp[i]);

                }

                collection.add(temp);

            }

        } catch (Exception ex) {
            System.out.println("WARNING: cannot fetch the table by id" +
                    ex.getMessage());
        } finally {
            closeConnection(con, ps, rs);
        }

        return collection;
    }

    public String[] findTabById(String id, int count) {
  //  	  System.out.println("<<<<<<<id in findTabById: "+id);
        String[] col = new String[count];

        for (int i = 0; i < count;
                i++) {
            col[i] = findTabById(id);
        }

        return col;

    }

    public String findTabById(
            String id) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String tab = "";

        String FINDER_QUERY = "SELECT TABLE_NAME from COL_LOOK_UP WHERE ID =?";
//        System.out.println("<<<<<<<FINDER_QUERY in findTabById: "+FINDER_QUERY);
        try {
            con = getConnection("legendPlus");
            ps =
                    con.prepareStatement(FINDER_QUERY);

            ps.setString(1, id);
            rs =
                    ps.executeQuery();

            while (rs.next()) {

                tab = rs.getString(1);
            }

        } catch (Exception ex) {
            System.out.println("WARNING: cannot fetch COL_LOOK_UP->" +
                    ex.getMessage());
        } finally {
            closeConnection(con, ps, rs);
        }

        return tab;

    }

    public String[] findByIdQuery(String id, int count, String query) {

        String[] col = new String[count];
//        System.out.println("<<<<<<<query in findByIdQuery: "+query);
        for (int i = 0; i < count;
                i++) {
            col[i] = findByIdQuery(id, query);
        }

        return col;

    }

    public String findByIdQuery(String id, String query) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String tab = "";

        String FINDER_QUERY = query;
//        System.out.println("<<<<<<<FINDER_QUERY in findByIdQuery: "+FINDER_QUERY);
        try {
            con = getConnection("legendPlus");
            ps =
                    con.prepareStatement(FINDER_QUERY);

            ps.setString(1, id);
            rs =
                    ps.executeQuery();

            while (rs.next()) {

                tab = rs.getString(1);
               // System.out.println("Output column by Id Query->" + tab);

            }

        } catch (Exception ex) {
            System.out.println("WARNING: cannot fetch by Id Query->" +
                    ex.getMessage());
        } finally {
            closeConnection(con, ps, rs);
        }

        return tab;

    }


   // tabNameFrom =  rep.findByIdQuery1(aliasIdFrom[i],aliasCountF,tabQuery);

    public ArrayList findByQuery1(String query, String[] sel) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String tab;

        ArrayList list = new ArrayList();
        String FINDER_QUERY = query;
//        System.out.println("<<<<<<<FINDER_QUERY in findByQuery1: "+FINDER_QUERY);
        try {
            con = getConnection("legendPlus");
            ps =
                    con.prepareStatement(FINDER_QUERY);


            rs =
                    ps.executeQuery();

            while (rs.next()) {



                list.add(rs.getString(1));
            }

        } catch (Exception ex) {
            System.out.println("WARNING: cannot fetch by Query->" +
                    ex.getMessage());
        } finally {
            closeConnection(con, ps, rs);
        }

        return list;

    }

    public ArrayList findByQuery(String query) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String tab;

        ArrayList list = new ArrayList();
        String FINDER_QUERY = query;
//        System.out.println("<<<<<<<FINDER_QUERY in findByQuery: "+FINDER_QUERY);
        try {
            con = getConnection("legendPlus");
            ps =
                    con.prepareStatement(FINDER_QUERY);


            rs =
                    ps.executeQuery();

            while (rs.next()) {

                list.add(rs.getString(1));
            }

        } catch (Exception ex) {
            System.out.println("WARNING: cannot fetch by Query->" +
                    ex.getMessage());
        } finally {
            closeConnection(con, ps, rs);
        }

        return list;

    }


    public boolean isNumeric(String id,String op) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String col = "";
        boolean status = false;

        String FINDER_QUERY = "SELECT OPERAND from COL_FILTER WHERE ID =? AND OPERAND =?";
 //       System.out.println("<<<<<<<FINDER_QUERY in findByQuery: "+FINDER_QUERY+"   ID: "+id+"    OP: "+op);
        try {
            con = getConnection("legendPlus");
            ps = con.prepareStatement(FINDER_QUERY);

            ps.setString(1, id);
             ps.setString(2, op);
            rs = ps.executeQuery();

            while (rs.next()) {

               status = true;
            }

        } catch (Exception ex) {
            System.out.println("WARNING: cannot get isNumeric->" +
                    ex.getMessage());
        } finally {
            closeConnection(con, ps, rs);
        }

        return status;
    }

    public boolean isNumericColumn(String id,String dType) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String col = "";
        boolean status = false;

        String FINDER_QUERY = "SELECT DATA_TYPE from COL_LOOK_UP WHERE ID =? AND DATA_TYPE =?";
//        System.out.println("<<<<<<<FINDER_QUERY in isNumericColumn: "+FINDER_QUERY+"    ID: "+id+"   dType: "+dType);
        try {
            con = getConnection("legendPlus");
            ps =
                    con.prepareStatement(FINDER_QUERY);

            ps.setString(1, id);
             ps.setString(2, dType);
            rs = ps.executeQuery();

            while (rs.next()) {

               status = true;
            }

        } catch (Exception ex) {
            System.out.println("WARNING: cannot get isNumeric->" +
                    ex.getMessage());
        } finally {
            closeConnection(con, ps, rs);
        }

        return status;
    }



    public String[] findColById(String id, int count) {
        String[] col = new String[count];

        for (int i = 0; i < count;
                i++) {
            col[i] = findColById(id);
        }

        return col;

    }

    public String findColById(String id) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String col = "";

        String FINDER_QUERY = "SELECT COLUMN_NAME from COL_LOOK_UP WHERE ID =?";
//        System.out.println("<<<<<<<FINDER_QUERY in findColById: "+FINDER_QUERY+"  ID: "+id);
        try {
            con = getConnection("legendPlus");
            ps =
                    con.prepareStatement(FINDER_QUERY);

            ps.setString(1, id);
            rs =
                    ps.executeQuery();

            while (rs.next()) {

                col = rs.getString(1);
            }

        } catch (Exception ex) {
            System.out.println("WARNING: cannot fetch COL_LOOK_UP->" +
                    ex.getMessage());
        } finally {
            closeConnection(con, ps, rs);
        }

        return col;
    }

    public String findColDescById(
            String id) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String col = "";

        String FINDER_QUERY = "SELECT DESCRIPTION from COL_LOOK_UP WHERE ID =?";
//        System.out.println("<<<<<<<FINDER_QUERY in findColDescById: "+FINDER_QUERY+"   ID: "+id);
        try {
            con = getConnection("legendPlus");
            ps =
                    con.prepareStatement(FINDER_QUERY);

            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {

                col = rs.getString(1);
            }

        } catch (Exception ex) {
            System.out.println("WARNING: cannot fetch COL_LOOK_UP->" +
                    ex.getMessage());
        } finally {
            closeConnection(con, ps, rs);
        }

        return col;
    }

    public ArrayList findApprovalByColumn(
            String query, String[] selCol, String para) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        // Approval app = null;
        ArrayList collection = new ArrayList();
        int count = selCol.length;

        String[] temp = new String[count];



        String FINDER_QUERY = "SELECT " + query + " from am_raisentry_post";

        try {
            con = getConnection("legendPlus");
            ps =
                    con.prepareStatement(FINDER_QUERY);

            //ps.setString(1, "Y");
            rs =
                    ps.executeQuery();

            //  String query = "Select +query+ from am_raisentry_post  ";

            while (rs.next()) {
                for (int i = 0; i < count;
                        i++) {
                    temp[i] = rs.getString(selCol[i]);
                }

                collection.add(temp);

            }

        } catch (Exception ex) {
            System.out.println("WARNING: cannot fetch [am_raisentry_post]->" +
                    ex.getMessage());
        } finally {
            closeConnection(con, ps, rs);
        }

        return collection;
    }

    public String findAssetWorkbookColDescById(
            String id) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String col = "";

        String FINDER_QUERY = "SELECT DESCRIPTION from ASSETWORKBOOK_EXPCOL WHERE ID =?";
 //       System.out.println("<<<<<<<FINDER_QUERY in findAssetWorkbookColDescById: "+FINDER_QUERY+"   ID: "+id);
        try {
            con = getConnection("legendPlus");
            ps =
                    con.prepareStatement(FINDER_QUERY);

            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {

                col = rs.getString(1);
            }

        } catch (Exception ex) {
            System.out.println("WARNING: cannot fetch ASSETWORKBOOK_EXPCOL->" +
                    ex.getMessage());
        } finally {
            closeConnection(con, ps, rs);
        }

        return col;
    }

    public String findAssetWorkbookColById(String id) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String col = "";

        String FINDER_QUERY = "SELECT COLUMN_NAME from ASSETWORKBOOK_EXPCOL WHERE ID =?";
//        System.out.println("<<<<<<<FINDER_QUERY in findAssetWorkbookColById: "+FINDER_QUERY+"  ID: "+id);
        try {
            con = getConnection("legendPlus");
            ps =
                    con.prepareStatement(FINDER_QUERY);

            ps.setString(1, id);
            rs =
                    ps.executeQuery();

            while (rs.next()) {

                col = rs.getString(1);
            }

        } catch (Exception ex) {
            System.out.println("WARNING: cannot fetch ASSETWORKBOOK_EXPCOL->" +
                    ex.getMessage());
        } finally {
            closeConnection(con, ps, rs);
        }
  //      System.out.println("<<<<<======Column in findAssetWorkbookColById: "+col);
        return col;
    }

    public boolean AssetWorkbookColumn(String id,String dType) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String col = "";
        boolean status = false;

        String FINDER_QUERY = "SELECT DATA_TYPE from ASSETWORKBOOK_EXPCOL WHERE ID =? AND DATA_TYPE =?";
//        System.out.println("<<<<<<<FINDER_QUERY in isNumericColumn: "+FINDER_QUERY+"    ID: "+id+"   dType: "+dType);
        try {
            con = getConnection("legendPlus");
            ps =
                    con.prepareStatement(FINDER_QUERY);

            ps.setString(1, id);
             ps.setString(2, dType);
            rs = ps.executeQuery();

            while (rs.next()) {

               status = true;
            }

        } catch (Exception ex) {
            System.out.println("WARNING: cannot get isNumeric->" +
                    ex.getMessage());
        } finally {
            closeConnection(con, ps, rs);
        }
 //       System.out.println("<<<<<======Column in findAssetWorkbookColById: "+col);
        return status;
    }

public java.util.ArrayList getWorkBookSqlRecords(String query)
{
	java.util.ArrayList _list = new java.util.ArrayList();
	String date = String.valueOf(dateConvert(new java.util.Date()));
	//System.out.println("====eschool Server Date-----> "+date);
	date = date.substring(0, 10);
	String finacleTransId= null;
	//	String query = " SELECT * FROM am_gb_workbookupdate ";
//	Transaction transaction = null;
     System.out.println("====query in getWorkBookSqlRecords-----> "+query);
	Connection c = null;
	ResultSet rs = null;
	Statement s = null; 

	try {
		    c = getConnection("legendPlusService");
			s = c.createStatement();
			rs = s.executeQuery(query);
			while (rs.next())
			   {				
				String strDescription = rs.getString("Description");
				String strAssetUser = rs.getString("Asset_User");
				String strbarCode = rs.getString("BAR_CODE");
				String StrassetId = rs.getString("ASSET_ID");
				String StroldassetId = rs.getString("OLD_ASSET_ID");
				String StrassetCode = rs.getString("ASSET_CODE");
				String branchId = rs.getString("BRANCH_ID"); 
				String categoryId = rs.getString("CATEGORY_ID"); 
				String batchId = rs.getString("BATCH_ID");
				String comments = rs.getString("COMMENTS"); 
				String sighted = rs.getString("ASSETSIGHTED");
				String function = rs.getString("ASSETFUNCTION"); 
				double costPrice = rs.getDouble("COST_PRICE");
				double monthlyDepr = rs.getDouble("Monthly_Dep");
				double accumDepr = rs.getDouble("Accum_Dep");
				double nbv = rs.getDouble("NBV");
				double improvcostPrice = rs.getDouble("IMPROV_COST");
				double improvmonthldepr = rs.getDouble("IMPROV_MONTHLYDEP");
				double improvaccumDep = rs.getDouble("IMPROV_ACCUMDEP");
				double improvnbv = rs.getDouble("IMPROV_NBV");
				double totalnbv = rs.getDouble("TOTAL_NBV");
                String sbuCode = rs.getString("SBU_CODE");
                String spare1 = rs.getString("Spare_1");
                String spare2 = rs.getString("Spare_2");
                String spare3 = rs.getString("Spare_3");
                String spare4 = rs.getString("Spare_4");
                String spare5 = rs.getString("Spare_5");
                String spare6 = rs.getString("Spare_6");                
                String assetModel = rs.getString("Asset_Model");
                String AssetSerialNo = rs.getString("Asset_Serial_No");
                String AssetEngineNo = rs.getString("Asset_Engine_No");
                String purchaseDate = rs.getString("Date_purchased");
                String assetMake = rs.getString("Asset_Make");
                String registrationNo = rs.getString("Registration_No");
                
				newAssetTransaction newTransaction = new newAssetTransaction();
				newTransaction.setDescription(strDescription);
				newTransaction.setAssetUser(strAssetUser);				
				newTransaction.setBarCode(strbarCode);
				newTransaction.setAssetId(StrassetId);
				newTransaction.setOldassetId(StroldassetId);
				newTransaction.setAssetCode(StrassetCode);
				newTransaction.setIntegrifyId(batchId);
				newTransaction.setBranchCode(branchId);
				newTransaction.setCategoryCode(categoryId);
//				System.out.println("<<<<<<strDescription: "+strDescription+"   strAssetUser: "+strAssetUser+"   strbarCode: "+strbarCode+"  StrassetId: "+StrassetId);
				newTransaction.setAssetMake(sighted);
				newTransaction.setAssetModel(function);
				newTransaction.setAssetMaintenance(comments);
				newTransaction.setAssetMake(assetMake);
				newTransaction.setAssetModel(assetModel);
//				System.out.println("<<<<<<sighted: "+sighted+"  function: "+function+"   comments: "+comments+"  assetMake: "+assetMake+"   assetModel: "+assetModel);
				newTransaction.setCostPrice(costPrice);
				newTransaction.setMonthlyDep(monthlyDepr);
				newTransaction.setAccumDep(accumDepr);
				newTransaction.setNbv(nbv);
				newTransaction.setImprovcostPrice(improvcostPrice);
				newTransaction.setImprovmonthlyDep(improvmonthldepr);
				newTransaction.setImprovaccumDep(improvaccumDep);
				newTransaction.setImprovnbv(improvnbv);
				newTransaction.setTotalnbv(totalnbv);
				newTransaction.setDatepurchased(purchaseDate);
				newTransaction.setEngineNo(AssetEngineNo);
				newTransaction.setSerialNo(AssetSerialNo);
				newTransaction.setSpare1(spare1);
				newTransaction.setSpare2(spare2);
				newTransaction.setSpare1(spare3);
				newTransaction.setSpare2(spare4);
				newTransaction.setSpare1(spare5);
				newTransaction.setSpare2(spare6);				
				newTransaction.setSbuCode(sbuCode);
				newTransaction.setRegistrationNo(registrationNo);
				_list.add(newTransaction);
//				System.out.println("<<<<<<_list.size(): "+_list.size());
			   }
	 }   
				 catch (Exception e)
					{
						e.printStackTrace();
					}
					finally
					{
						closeConnection(c, s, rs);
					}
	return _list;
}

public java.util.ArrayList getBulkAssetProofSqlRecords(String query)
{
	java.util.ArrayList _list = new java.util.ArrayList();
	String date = String.valueOf(dateConvert(new java.util.Date()));
	//System.out.println("====eschool Server Date-----> "+date);
	date = date.substring(0, 10);
	String finacleTransId= null;
	//	String query = " SELECT * FROM am_gb_workbookupdate ";
//	Transaction transaction = null;
     System.out.println("====query in getBulkAssetProofSqlRecords-----> "+query);
	Connection c = null;
	ResultSet rs = null;
	Statement s = null; 

	try {
		    c = getConnection("legendPlusService");
			s = c.createStatement();
			rs = s.executeQuery(query);
			while (rs.next())
			   {				
				String strDescription = rs.getString("Description");
				String strAssetUser = rs.getString("Asset_User");
				String strbarCode = rs.getString("BAR_CODE");
				String StrassetId = rs.getString("ASSET_ID");
				String StroldassetId = rs.getString("OLD_ASSET_ID");
				String StrassetCode = rs.getString("ASSET_CODE");
				String branchId = rs.getString("BRANCH_ID"); 
				String categoryId = rs.getString("CATEGORY_ID"); 
				String batchId = rs.getString("BATCH_ID");
				String comments = rs.getString("COMMENTS"); 
				String sighted = rs.getString("ASSETSIGHTED");
				String function = rs.getString("ASSETFUNCTION"); 
				double costPrice = rs.getDouble("COST_PRICE");
				double monthlyDepr = rs.getDouble("Monthly_Dep");
				double accumDepr = rs.getDouble("Accum_Dep");
				double nbv = rs.getDouble("NBV");
				double improvcostPrice = rs.getDouble("IMPROV_COST");
				double improvmonthldepr = rs.getDouble("IMPROV_MONTHLYDEP");
				double improvaccumDep = rs.getDouble("IMPROV_ACCUMDEP");
				double improvnbv = rs.getDouble("IMPROV_NBV");
				double totalnbv = rs.getDouble("TOTAL_NBV");
                String sbuCode = rs.getString("SBU_CODE");
                String spare1 = rs.getString("Spare_1");
                String spare2 = rs.getString("Spare_2");
                String spare3 = rs.getString("Spare_3");
                String spare4 = rs.getString("Spare_4");
                String spare5 = rs.getString("Spare_5");
                String spare6 = rs.getString("Spare_6");                
                String assetModel = rs.getString("Asset_Model");
                String AssetSerialNo = rs.getString("Asset_Serial_No");
                String AssetEngineNo = rs.getString("Asset_Engine_No");
                String purchaseDate = rs.getString("Date_purchased");
                String assetMake = rs.getString("Asset_Make");
                String registrationNo = rs.getString("Registration_No");
                
				newAssetTransaction newTransaction = new newAssetTransaction();
				newTransaction.setDescription(strDescription);
				newTransaction.setAssetUser(strAssetUser);				
				newTransaction.setBarCode(strbarCode);
				newTransaction.setAssetId(StrassetId);
				newTransaction.setOldassetId(StroldassetId);
				newTransaction.setAssetCode(StrassetCode);
				newTransaction.setIntegrifyId(batchId);
				newTransaction.setBranchCode(branchId);
				newTransaction.setCategoryCode(categoryId);
				newTransaction.setAssetsighted(sighted);
				newTransaction.setAssetfunction(function);
				newTransaction.setAssetMaintenance(comments);
				newTransaction.setAssetMake(assetMake);
				newTransaction.setAssetModel(assetModel);
				newTransaction.setCostPrice(costPrice);
				newTransaction.setMonthlyDep(monthlyDepr);
				newTransaction.setAccumDep(accumDepr);
				newTransaction.setNbv(nbv);
				newTransaction.setImprovcostPrice(improvcostPrice);
				newTransaction.setImprovmonthlyDep(improvmonthldepr);
				newTransaction.setImprovaccumDep(improvaccumDep);
				newTransaction.setImprovnbv(improvnbv);
				newTransaction.setTotalnbv(totalnbv);
				newTransaction.setDatepurchased(purchaseDate);
				newTransaction.setEngineNo(AssetEngineNo);
				newTransaction.setSerialNo(AssetSerialNo);
				newTransaction.setSpare1(spare1);
				newTransaction.setSpare2(spare2);
				newTransaction.setSpare1(spare3);
				newTransaction.setSpare2(spare4);
				newTransaction.setSpare1(spare5);
				newTransaction.setSpare2(spare6);				
				newTransaction.setSbuCode(sbuCode);
				newTransaction.setRegistrationNo(registrationNo);
				_list.add(newTransaction);
			   }
	 }   
				 catch (Exception e)
					{
						e.printStackTrace();
					}
					finally
					{
						closeConnection(c, s, rs);
					}
	return _list;
}

public java.util.ArrayList getBulkAssetProofforFinconSqlRecords(String query)
{
	java.util.ArrayList _list = new java.util.ArrayList();
	String date = String.valueOf(dateConvert(new java.util.Date()));
	//System.out.println("====eschool Server Date-----> "+date);
	date = date.substring(0, 10);
	String finacleTransId= null;
	//	String query = " SELECT * FROM am_gb_workbookupdate ";
//	Transaction transaction = null;
     System.out.println("====query in getBulkAssetProofforFinconSqlRecords-----> "+query);
	Connection c = null;
	ResultSet rs = null;
	Statement s = null; 

	try {
		    c = getConnection("legendPlusService");
			s = c.createStatement();
			rs = s.executeQuery(query);
			while (rs.next())
			   {				
				String strDescription = rs.getString("Description");
				String strAssetUser = rs.getString("Asset_User");
				String strbarCode = rs.getString("BAR_CODE");
				String StrassetId = rs.getString("ASSET_ID");
				String branchId = rs.getString("BRANCH_ID"); 
				String categoryId = rs.getString("CATEGORY_ID"); 
                String newsbuCode = rs.getString("NEW_SBUCODE");
                String oldsbuCode = rs.getString("OLD_SBUCODE");
                String spare1 = rs.getString("Spare_1");
                String spare2 = rs.getString("Spare_2");
                String spare3 = rs.getString("Spare_3");
                String spare4 = rs.getString("Spare_4");
                String spare5 = rs.getString("Spare_5");
                String spare6 = rs.getString("Spare_6");                
                String assetModel = rs.getString("Asset_Model");
                String AssetSerialNo = rs.getString("Asset_Serial_No");
                String AssetEngineNo = rs.getString("Asset_Engine_No");
                String assetMake = rs.getString("Asset_Make");
                String registrationNo = rs.getString("Registration_No");
				String deptId = rs.getString("Dept_ID"); 
				String subcatId = rs.getString("SUB_CATEGORY_ID");
				String location = rs.getString("Location");
				String sectionId = rs.getString("Section_id");
				String state = rs.getString("State");
                
				newAssetTransaction newTransaction = new newAssetTransaction();
				newTransaction.setDescription(strDescription);
				newTransaction.setAssetUser(strAssetUser);				
				newTransaction.setBarCode(strbarCode);
				newTransaction.setAssetId(StrassetId);
				newTransaction.setDeptCode(deptId);
				newTransaction.setSubcategoryCode(subcatId);
				newTransaction.setLocation(location);
				newTransaction.setSectionCode(sectionId);
				newTransaction.setState(state);
				newTransaction.setBranchCode(branchId);
				newTransaction.setCategoryCode(categoryId);
				newTransaction.setAssetMake(assetMake);
				newTransaction.setAssetModel(assetModel);
				newTransaction.setEngineNo(AssetEngineNo);
				newTransaction.setSerialNo(AssetSerialNo);
				newTransaction.setSpare1(spare1);
				newTransaction.setSpare2(spare2);
				newTransaction.setSpare1(spare3);
				newTransaction.setSpare2(spare4);
				newTransaction.setSpare1(spare5);
				newTransaction.setSpare2(spare6);				
				newTransaction.setNewsbuCode(newsbuCode);
				newTransaction.setOldsbuCode(oldsbuCode);
				
				newTransaction.setRegistrationNo(registrationNo);
				_list.add(newTransaction);
			   }
	 }   
				 catch (Exception e)
					{
						e.printStackTrace();
					}
					finally
					{
						closeConnection(c, s, rs);
					}
	return _list;
}


public java.util.ArrayList getUploadUserSqlRecords(String query,String user_Id)
{
	java.util.ArrayList _list = new java.util.ArrayList();
//     System.out.println("====query in getUploadUserSqlRecords-----> "+query);
	Connection c = null;
	ResultSet rs = null;
	Statement s = null; 
	User user = null;
	try {
		    c = getConnection("legendPlusService");
			s = c.createStatement();
			rs = s.executeQuery(query);
			while (rs.next())
			   {				
                String userId = rs.getString("User_Id");
                String userName = rs.getString("User_Name");
                String fullName = rs.getString("Full_Name");
                String legacySysId = rs.getString("Legacy_Sys_Id");
                String Class = rs.getString("Class");
                String branch = rs.getString("Branch");
                String password = rs.getString("Password");
                String phoneNo = rs.getString("Phone_No");
                String isSupervisor = "N";
                String mustChangePwd = "Y";
                String loginStatus = "0";
                String userStatus = "ACTIVE";
                String createDate = rs.getString("Create_Date");
//                String passwordExpiry = rs.getString("Password_Expiry");
//                String loginDate = rs.getString("Login_Date");
//                String loginSystem = rs.getString("Login_System");
                String fleetAdmin = "N";
                String email = rs.getString("email");
                String branchCode = rs.getString("Branch");
                String pwdChanged = "N";
                String regionCode = rs.getString("region_code");
                String zoneCode = rs.getString("zone_code");
                String regionRestrict = "Y";
//                String zoneRestrict = rs.getString("zone_restriction");
//                String facilityAdmin = rs.getString("Facility_Admin");
//                String storeAdmin = rs.getString("Store_Admin");
                
                user = new User();
                user.setUserId(userId);
                user.setUserName(userName);
                user.setUserFullName(fullName);
                user.setLegacySystemId(legacySysId);
                user.setUserClass(Class);
                user.setBranch(branch);
                user.setPassword(password);
                user.setPhoneNo(phoneNo);
                user.setIsSupervisor(isSupervisor);
                user.setMustChangePwd(mustChangePwd);
                user.setLoginStatus(loginStatus);
                user.setCreatedBy(user_Id);
                user.setCreateDate(createDate);
//                user.setPwdExpiry(passwordExpiry);
//                user.setLastLogindate(loginDate);
//                user.setLoginSystem(loginSystem);
                user.setFleetAdmin(fleetAdmin);
                user.setEmail(email);
                user.setBranch(branchCode);
                user.setUserStatus(userStatus);
                user.setPwdChanged(pwdChanged);
                user.setRegionCode(regionCode);
                user.setZoneCode(zoneCode);
                user.setRegionRestrict(regionRestrict);
//                user.setZoneRestrict(zoneRestrict);
//                user.setIsFacilityAdministrator(facilityAdmin);
//                user.setIsStoreAdministrator(storeAdmin);
                _list.add(user);				
			   }
	 }    
				 catch (Exception e)
					{
						e.printStackTrace();
					}
					finally
					{
						closeConnection(c, s, rs);
					}
	return _list;
}

}
