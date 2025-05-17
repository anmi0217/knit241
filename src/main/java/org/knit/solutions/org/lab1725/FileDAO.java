package org.knit.solutions.org.lab1725;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface FileDAO {



    void saveFile(File file) throws SQLException, IOException ;
}