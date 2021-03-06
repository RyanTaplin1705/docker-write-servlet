package server.database;

import org.json.JSONArray;
import org.json.JSONObject;
import server.jetty.servlets.model.probes.Probe;
import server.jetty.servlets.model.probes.TestProbe;
import utils.properties.DatabaseProperties;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDatabase implements Database {

    private DatabaseProperties properties;

    private String status = "OK";
    private JSONArray array = new JSONArray();

    public TestDatabase(DatabaseProperties properties) {
        this.properties = properties;
    }

    public JSONArray query(String sql) throws SQLException {
        return array;
    }

    public void update(String sql) throws SQLException {
        // add to an array list.
    }

    public Connection connection() {
        return null; //Don't care about this implementation, will never be tested vs real connection in ci automation.
    }

    public Probe probe() {
        return new TestProbe(
                status(),
                String.format("[user=%s][url=%s]", properties.databaseUsername(), properties.databaseURL()));
    }

    public String status() {
            return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
