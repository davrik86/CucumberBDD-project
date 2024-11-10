package stepdefinitions;

import io.cucumber.java.en.And;
import org.junit.Assert;
import utilities.DBUtils;

public class AddInvoice_And_Verify_DB_Stepdef {

    @And("the invoice should added to the database")
    public void the_invoice_should_added_to_the_database() {
        String query="select * from CraterDBS.invoices order by invoice_date desc;";
        String invoiceNumber= DBUtils.selectRecord(query, "invoice_number");
        System.out.println("The new invoice number "+invoiceNumber);

        Assert.assertTrue(invoiceNumber.startsWith("INV-"));
    }
}
