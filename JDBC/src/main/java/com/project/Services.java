package com.project;

import java.io.IOException;
import java.sql.SQLException;

public interface Services {

	void getoneStudent() throws SQLException;
	void getallStudent() throws SQLException;
	void updatestoreStudent() throws SQLException;
	void deleteallStudent() throws SQLException;
	void deleteoneStudent() throws SQLException;
	void storeInfoStudent() throws SQLException;
	void storeImgStudent() throws SQLException, IOException;
	void storefileStudent() throws SQLException, IOException;
	void getImgStudent() throws SQLException, IOException;
	void getFileStudent() throws SQLException, IOException;
}
