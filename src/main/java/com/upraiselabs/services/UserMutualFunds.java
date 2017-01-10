package com.upraiselabs.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.upraiselabs.constants.DBQueriesEnum;
import com.upraiselabs.dbservices.ConnectToDB;
import com.upraiselabs.oldmodels.MUTUAL_FUND_NAV;
import com.upraiselabs.oldmodels.USER_HOLDINGS;

public abstract class UserMutualFunds {

  public static List<Map<String, Object>> getMutualFundList(String userId)
      throws SQLException {
    Connection dbConnection = ConnectToDB.connectToDB();
    Statement stmt = dbConnection.createStatement(
        ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    stmt.executeQuery(DBQueriesEnum.USE_UPRAISE_LABS_DB.toString());

    ResultSet resultSet = stmt
        .executeQuery("SELECT * FROM USER_HOLDINGS WHERE user_id='"
            .concat(userId).concat("';"));

    BeanListHandler<USER_HOLDINGS> userHoldingsHandler = new BeanListHandler<USER_HOLDINGS>(
        USER_HOLDINGS.class);
    List<USER_HOLDINGS> userHoldingsList = userHoldingsHandler
        .handle(resultSet);

    List<Map<String, Object>> mutualFundList = new ArrayList<Map<String, Object>>();
    for (USER_HOLDINGS userHoldings : userHoldingsList) {
      String mutualFundId = userHoldings.getMutual_fund_id();

      resultSet = stmt
          .executeQuery("SELECT * FROM MUTUAL_FUND_NAV WHERE fund_id='"
              .concat(mutualFundId).concat("';"));

      BeanHandler<MUTUAL_FUND_NAV> mutualFundHandler = new BeanHandler<MUTUAL_FUND_NAV>(
          MUTUAL_FUND_NAV.class);
      MUTUAL_FUND_NAV mutualFund = mutualFundHandler.handle(resultSet);

      Map<String, Object> mutualFundMap = new HashMap<String, Object>();
      float units = Float.parseFloat(userHoldings.getMutual_fund_units());
      float valuePerUnit = Float.parseFloat(mutualFund.getCurrent_day_value());
      float totalValue = units * valuePerUnit;

      mutualFundMap.put("name", mutualFund.getFund_name());
      mutualFundMap.put("units", userHoldings.getMutual_fund_units());
      mutualFundMap.put("valuePerUnit", mutualFund.getCurrent_day_value());
      mutualFundMap.put("totalValue", totalValue);
      mutualFundMap.put("dateOfPurchase", userHoldings.getCreation_time());

      mutualFundList.add(mutualFundMap);
    }
    if (dbConnection != null) {
      dbConnection.close();
      dbConnection = null;
    }
    return mutualFundList;
  }
}
