package stepdefinitions;

import io.cucumber.java.en.And;
import org.junit.Assert;
import utilities.DBUtils;

public class Add_Item_validate_DB {

    @And("validate data is in DB")
    public void validate_data_is_in_db() {
        String query="select * from CraterDBS.items order by created_at desc;";
        String name= DBUtils.selectRecord(query, "name");
        System.out.println(name);
        Assert.assertTrue(!name.isEmpty());

    }
}
