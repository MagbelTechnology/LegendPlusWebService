package com.magbel.model;

import java.util.ArrayList;
import java.util.List;

public class NewAssetRecords {
	
	public ArrayList getNewAssetSqlRecordsForCapitalised(String strintegrifyId,String strDescription,String strRegistrationNo,String strVendorAC,
			String strDatepurchased,String strAssetMake,String strAssetModel,String strAssetSerialNo,
			String strAssetEngineNo,String strSupplierName,String strAssetUser,String strAssetMaintenance,
			double strCostPrice,String strAuthorizedBy,String strWhTax,String strPostingDate,
			String strEffectiveDate,String strPurchaseReason,String strSubjectTOVat,
			String strAssetStatus,String strState,String strDriver, String strUserID,
			String strbranchCode, String strsectionCode,String strdeptCode,String strcategoryCode,
			String strsubcategoryCode,String strbarCode,String strsbuCode,String strlpo,String strinvoiceNo,
			String strsupervisor,String Strposted,String StrassetId,String StrassetCode,String Strerrormessage,
			String Strassettype,String Strtrantype,double StrwhTaxValue,double StrVatValue,
			int Strnoofitems,String Strlocation,String Strspare1,String Strspare2,String Strspare3,
			String Strspare4,String Strspare5,String Strspare6,String Strmultiple,String Strmemo,
			String Strmemovalue,int Strusefullife,String projectCode,String location){
		ArrayList _list = new ArrayList<>();
		newAssetTransaction newTransaction = new newAssetTransaction();
		newTransaction.setIntegrifyId(strintegrifyId);
		newTransaction.setDescription(strDescription);
		newTransaction.setRegistrationNo(strRegistrationNo);
		newTransaction.setVendorAC(strVendorAC);
		newTransaction.setDatepurchased(strDatepurchased);
		newTransaction.setAssetMake(strAssetMake);
		newTransaction.setAssetModel(strAssetModel);
		newTransaction.setAssetSerialNo(strAssetSerialNo);
		newTransaction.setAssetEngineNo(strAssetEngineNo);
		newTransaction.setSupplierName(strSupplierName);
		newTransaction.setAssetUser(strAssetUser);				
		newTransaction.setAssetMaintenance(strAssetMaintenance);
		newTransaction.setCostPrice(strCostPrice);
		newTransaction.setAuthorizedBy(strAuthorizedBy);
		newTransaction.setWhTax(strWhTax);
		newTransaction.setPostingDate(strPostingDate);
		newTransaction.setEffectiveDate(strEffectiveDate);
		newTransaction.setPurchaseReason(strPurchaseReason);
		newTransaction.setSubjectTOVat(strSubjectTOVat);
		newTransaction.setAssetStatus(strAssetStatus);
		newTransaction.setState(strState);
		newTransaction.setDriver(strDriver);				
		newTransaction.setUserID(strUserID);			
		newTransaction.setBranchCode(strbranchCode);
		newTransaction.setSectionCode(strsectionCode);
		newTransaction.setDeptCode(strdeptCode);
		newTransaction.setCategoryCode(strcategoryCode);
		newTransaction.setSubcategoryCode(strsubcategoryCode);
		newTransaction.setBarCode(strbarCode);
		newTransaction.setSbuCode(strsbuCode);
		newTransaction.setLpo(strlpo);
		newTransaction.setInvoiceNo(strinvoiceNo);
		newTransaction.setSupervisor(strsupervisor);
		newTransaction.setPosted(Strposted);
		newTransaction.setAssetId(StrassetId);
		newTransaction.setAssetCode(StrassetCode);
		newTransaction.setErrormessage(Strerrormessage);
		newTransaction.setAssetType(Strassettype);
		newTransaction.setWhTaxValue(StrwhTaxValue);
		newTransaction.setVatValue(StrVatValue);
		newTransaction.setNoofitems(Strnoofitems);
		newTransaction.setLocation(Strlocation);
		newTransaction.setSpare1(Strspare1);
		newTransaction.setSpare2(Strspare2);
		newTransaction.setSpare3(Strspare3);
		newTransaction.setSpare4(Strspare4);
		newTransaction.setSpare5(Strspare5);
		newTransaction.setSpare6(Strspare6);
		newTransaction.setMemo(Strmemo);
		newTransaction.setMemovalue(Strmemovalue);
		newTransaction.setMultiple(Strmultiple);
		newTransaction.setProjectCode(projectCode);
		newTransaction.setLocation(location);

		_list.add(newTransaction);
		return _list;
		
	}
	
	public ArrayList<newAssetTransaction> getNewAssetSqlRecordsForCapitalised(NewAssetRequest request) {
	    ArrayList<newAssetTransaction> list = new ArrayList<>();
	    newAssetTransaction newTransaction = new newAssetTransaction();

	    newTransaction.setIntegrifyId(request.INTEGRIFY_ID);
	    newTransaction.setDescription(request.Description);
	    newTransaction.setRegistrationNo(request.Registration_No);
	    newTransaction.setVendorAC(request.Vendor_AC);
	    newTransaction.setDatepurchased(request.Date_purchased);
	    newTransaction.setAssetMake(String.valueOf(request.Asset_Make));
	    newTransaction.setAssetModel(request.Asset_Model);
	    newTransaction.setAssetSerialNo(request.Asset_Serial_No);
	    newTransaction.setAssetEngineNo(request.Asset_Engine_No);
	    newTransaction.setSupplierName(request.Supplier_Name);
	    newTransaction.setAssetUser(request.Asset_User);
	    newTransaction.setAssetMaintenance(String.valueOf(request.Asset_Maintenance));
	    newTransaction.setCostPrice(request.Cost_Price);
	    newTransaction.setAuthorizedBy(request.Authorized_By);
	    newTransaction.setWhTax(request.Wh_Tax);
	    newTransaction.setPostingDate(request.Posting_Date);
	    newTransaction.setEffectiveDate(request.Effective_Date);
	    newTransaction.setPurchaseReason(request.Purchase_Reason);
	    newTransaction.setSubjectTOVat(request.Subject_TO_Vat);
	    newTransaction.setAssetStatus(request.Asset_Status);
	    newTransaction.setState(String.valueOf(request.State));
	    newTransaction.setDriver(request.Driver);
	    newTransaction.setUserID(request.User_ID);
	    newTransaction.setBranchCode(request.BRANCH_CODE);
	    newTransaction.setSectionCode(request.SECTION_CODE);
	    newTransaction.setDeptCode(request.DEPT_CODE);
	    newTransaction.setCategoryCode(request.CATEGORY_CODE);
	    newTransaction.setSubcategoryCode(request.SUB_CATEGORY_CODE);
	    newTransaction.setBarCode(request.BAR_CODE);
	    newTransaction.setSbuCode(request.SBU_CODE);
	    newTransaction.setLpo(request.LPO);
	    newTransaction.setInvoiceNo(request.INVOICE_NO);
	    newTransaction.setSupervisor(request.supervisor);
	    newTransaction.setPosted(request.POSTED);
	    newTransaction.setAssetId(request.ASSET_ID);
	    newTransaction.setAssetCode(request.ASSET_CODE);
	    newTransaction.setErrormessage(request.ERROR_MESSAGE);
	    newTransaction.setAssetType(request.ASSET_TYPE);
	    newTransaction.setTranType(request.TRAN_TYPE);
	    newTransaction.setWhTaxValue(request.Wh_Tax_Value);
	    newTransaction.setVatValue(request.Vat_Value);
	    newTransaction.setNoofitems(request.QUANTITY);
	    newTransaction.setLocation(String.valueOf(request.Location));
	    newTransaction.setSpare1(request.Spare_1);
	    newTransaction.setSpare2(request.Spare_2);
	    newTransaction.setSpare3(request.Spare_3);
	    newTransaction.setSpare4(request.Spare_4);
	    newTransaction.setSpare5(request.Spare_5);
	    newTransaction.setSpare6(request.Spare_6);
	    newTransaction.setMultiple(request.Multiple);
	    newTransaction.setMemo(request.Memo);
	    newTransaction.setMemovalue(request.MemoValue);
	    newTransaction.setUsefullife(request.IMPROV_USEFULLIFE);
	    newTransaction.setProjectCode(request.PROJECT_CODE);
	    newTransaction.setNoofitems(request.NoOfItem);
	   // newTransaction.setSystemIP(request.System_IP);

	    list.add(newTransaction);
	    return list;
	}

	
	public ArrayList<groupAssetTransaction> getGroupAssetSqlRecords(List<GroupAssetRequest> requests) {
	    ArrayList<groupAssetTransaction> list = new ArrayList<>();

	    for (GroupAssetRequest request : requests) {
	    	groupAssetTransaction newTransaction = new groupAssetTransaction();

	        newTransaction.setIntegrifyId(request.INTEGRIFY_ID);
	        newTransaction.setDescription(request.Description);
	        newTransaction.setRegistrationNo(request.Registration_No);
	        newTransaction.setVendorAC(request.Vendor_AC);
	        newTransaction.setDatepurchased(request.Date_purchased);
	        newTransaction.setAssetMake(String.valueOf(request.Asset_Make));
	        newTransaction.setAssetModel(request.Asset_Model);
	        newTransaction.setAssetSerialNo(request.Asset_Serial_No);
	        newTransaction.setAssetEngineNo(request.Asset_Engine_No);
	        newTransaction.setSupplierName(request.Supplier_Name);
	        newTransaction.setAssetUser(request.Asset_User);
	        newTransaction.setAssetMaintenance(String.valueOf(request.Asset_Maintenance));
	        newTransaction.setCostPrice(request.Cost_Price);
	        newTransaction.setAuthorizedBy(request.Authorized_By);
	        newTransaction.setWhTax(request.Wh_Tax);
	        newTransaction.setPostingDate(request.Posting_Date);
	        newTransaction.setEffectiveDate(request.Effective_Date);
	        newTransaction.setPurchaseReason(request.Purchase_Reason);
	        newTransaction.setSubjectTOVat(request.Subject_TO_Vat);
	        newTransaction.setAssetStatus(request.Asset_Status);
	        newTransaction.setState(String.valueOf(request.State));
	        newTransaction.setDriver(request.Driver);
	        newTransaction.setUserID(request.User_ID);
	        newTransaction.setBranchCode(request.BRANCH_CODE);
	        newTransaction.setSectionCode(request.SECTION_CODE);
	        newTransaction.setDeptCode(request.DEPT_CODE);
	        newTransaction.setCategoryCode(request.CATEGORY_CODE);
	        newTransaction.setSubcategoryCode(request.SUB_CATEGORY_CODE);
	        newTransaction.setBarCode(request.BAR_CODE);
	        newTransaction.setSbuCode(request.SBU_CODE);
	        newTransaction.setLpo(request.LPO);
	        newTransaction.setInvoiceNo(request.INVOICE_NO);
	        newTransaction.setSupervisor(request.supervisor);
	        newTransaction.setPosted(request.POSTED);
	        newTransaction.setAssetId(request.ASSET_ID);
	        newTransaction.setAssetCode(request.ASSET_CODE);
	        newTransaction.setErrormessage(request.ERROR_MESSAGE);
	        newTransaction.setAssetType(request.ASSET_TYPE);
	        newTransaction.setTranType(request.TRAN_TYPE);
	        newTransaction.setWhTaxValue(request.Wh_Tax_Value);
	        newTransaction.setVatValue(request.Vat_Value);
	        newTransaction.setNoofitems(request.NoOfItem); // Make sure to choose the correct one if both exist
	        newTransaction.setLocation(String.valueOf(request.Location));
	        newTransaction.setSpare1(request.Spare_1);
	        newTransaction.setSpare2(request.Spare_2);
	        newTransaction.setSpare3(request.Spare_3);
	        newTransaction.setSpare4(request.Spare_4);
	        newTransaction.setSpare5(request.Spare_5);
	        newTransaction.setSpare6(request.Spare_6);
	        newTransaction.setMultiple(request.Multiple);
	        newTransaction.setMemo(request.Memo);
	        newTransaction.setMemovalue(request.MemoValue);
	        newTransaction.setUsefullife(request.IMPROV_USEFULLIFE);
	        newTransaction.setProjectCode(request.PROJECT_CODE);
	        // newTransaction.setSystemIP(request.System_IP); // uncomment if applicable

	        list.add(newTransaction);
	    }

	    return list;
	}

	

	public ArrayList getNewAssetSqlRecordsForCapitalised(String strintegrifyId, String strDescription,
			String strRegistrationNo, String strVendorAC, String strSupplierName, String strDatepurchased,
			String strAssetMake, String strAssetUser, String strAssetModel, String strAssetEngineNo, String strUserID,
			double strCostPrice, String strEffectiveDate, String strAssetSerialNo, String strAssetMaintenance,
			String strAuthorizedBy, String strWhTax, double strwhTaxValue, double strVatValue, String strPostingDate,
			String strPurchaseReason, String strSubjectTOVat, String strAssetStatus, String strState, String strDriver,
			String strUserID2, String strbranchCode, String strsectionCode, String strdeptCode, String strcategoryCode,
			String strsubcategoryCode, String strbarCode, String strsbuCode, String strlpo, String strinvoiceNo,
			String strposted, String strassetId, String strassetCode, String strsupervisor, String systemIP,
			String strerrormessage, String strassettype, String strtrantype, int strnoofitems, String strlocation,
			String strspare1, String strspare2, String strspare3, String strspare4, String strspare5, String strspare6,
			String strmemo, String strmemovalue, String strmultiple, int strusefullife, String projectCode) {
		ArrayList _list = new ArrayList<>();
		newAssetTransaction newTransaction = new newAssetTransaction();
		newTransaction.setIntegrifyId(strintegrifyId);
		newTransaction.setDescription(strDescription);
		newTransaction.setRegistrationNo(strRegistrationNo);
		newTransaction.setVendorAC(strVendorAC);
		newTransaction.setDatepurchased(strDatepurchased);
		newTransaction.setAssetMake(strAssetMake);
		newTransaction.setAssetModel(strAssetModel);
		newTransaction.setAssetSerialNo(strAssetSerialNo);
		newTransaction.setAssetEngineNo(strAssetEngineNo);
		newTransaction.setSupplierName(strSupplierName);
		newTransaction.setAssetUser(strAssetUser);				
		newTransaction.setAssetMaintenance(strAssetMaintenance);
		newTransaction.setCostPrice(strCostPrice);
		newTransaction.setAuthorizedBy(strAuthorizedBy);
		newTransaction.setWhTax(strWhTax);
		newTransaction.setPostingDate(strPostingDate);
		newTransaction.setEffectiveDate(strEffectiveDate);
		newTransaction.setPurchaseReason(strPurchaseReason);
		newTransaction.setSubjectTOVat(strSubjectTOVat);
		newTransaction.setAssetStatus(strAssetStatus);
		newTransaction.setState(strState);
		newTransaction.setDriver(strDriver);				
		newTransaction.setUserID(strUserID);			
		newTransaction.setBranchCode(strbranchCode);
		newTransaction.setSectionCode(strsectionCode);
		newTransaction.setDeptCode(strdeptCode);
		newTransaction.setCategoryCode(strcategoryCode);
		newTransaction.setSubcategoryCode(strsubcategoryCode);
		newTransaction.setBarCode(strbarCode);
		newTransaction.setSbuCode(strsbuCode);
		newTransaction.setLpo(strlpo);
		newTransaction.setInvoiceNo(strinvoiceNo);
		newTransaction.setSupervisor(strsupervisor);
		newTransaction.setPosted(strposted);
		newTransaction.setAssetId(strassetId);
		newTransaction.setAssetCode(strassetCode);
		newTransaction.setErrormessage(strerrormessage);
		newTransaction.setAssetType(strassettype);
		newTransaction.setTranType(strtrantype);
		newTransaction.setWhTaxValue(strwhTaxValue);
		newTransaction.setVatValue(strVatValue);
		newTransaction.setNoofitems(strnoofitems);
		newTransaction.setLocation(strlocation);
		newTransaction.setSpare1(strspare1);
		newTransaction.setSpare2(strspare2);
		newTransaction.setSpare3(strspare3);
		newTransaction.setSpare4(strspare4);
		newTransaction.setSpare5(strspare5);
		newTransaction.setSpare6(strspare6);
		newTransaction.setMemo(strmemo);
		newTransaction.setMemovalue(strmemovalue);
		newTransaction.setMultiple(strmultiple);
		newTransaction.setProjectCode(projectCode);

		_list.add(newTransaction);
		return _list;
	}

}
