package com.codechallenge.springboot.cucumber.bdd.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.fail;



import com.codechallenge.springboot.app.transactions.models.entity.Transaction;

import cucumber.api.java8.En;

import io.cucumber.datatable.DataTable;

import io.restassured.response.Response;

import java.util.List;



/**

 * Step Definition Class for Transaction.

 *

 * <p>Uses Java Lambda style step definitions so that we don't need to worry

 * about method naming for each step definition</p>

 */

public class TransactionSteps extends AbstractSteps implements En {



  public TransactionSteps() {



    Given("user wants to create an transactionwith the following attributes", (DataTable transactionDt) -> {

      testContext().reset();

      List<Transaction> transactionList = transactionDt.asList(Transaction.class);



      // First row of DataTable has the transactionattributes hence calling get(0) method.

      super.testContext()

          .setPayload(transactionList.get(0));

    });



//    And("with the following transactions", (DataTable transactionDt) -> {
//
//      List<Transaction> transactionList = transactionDt.asList(Transaction.class);
//
//      super.testContext()
//
//          .getPayload(Transaction.class)
//
//          .setTransactions(transactionList);
//
//    });


    When("user saves the new transaction{string}", (String testContext) -> {

      String createTransactionUrl = "/v1/transaction";



      // AbstractSteps class makes the POST call and stores response in TestContext

      executePost(createTransactionUrl);

    });



    /**

     * This can be moved to a Class named 'CommonSteps.java so that it can be reused.

     */

    Then("the save {string}", (String expectedResult) -> {

      Response response = testContext().getResponse();



      switch (expectedResult) {

        case "IS SUCCESSFUL":

          assertThat(response.statusCode()).isIn(200, 201);

          break;

        case "FAILS":

          assertThat(response.statusCode()).isBetween(400, 504);

          break;

        default:

          fail("Unexpected error");

      }

    });



  }

}