package com.dtb.springdatabase.config.constants;

public class Database {
	public static final String[] ENTITIES_PACKAGES = new String[]{"com.dtb.springdatabase.model.entities", "com.dtb.springdatabase.security.model.entities"};
	public static final String REPOSITORIES_PACKAGES = "com.dtb.springdatabase.model.repositories";
	
	/*
	 * Constants for primary datasource
	 * */
	public static final String DATASOURCE_NAME_ONE = "dataSourceOne";
	public static final String DATASOURCE_PREFIX_ONE = "dbone.datasource";
	public static final String DATASOURCE_ENTITY_MANAGER_ONE = "entityManagerFactoryOne";
	public static final String DATASOURCE_PU_ONE = "dbOne";
	public static final String DATASOURCE_TRANSACTION_MANAGER_ONE = "transactionManagerOne";
	
	public static final String DATASOURCE_NAME_TWO = "dataSourceTwo";
	public static final String DATASOURCE_PREFIX_TWO = "dbtwo.datasource";
	public static final String DATASOURCE_ENTITY_MANAGER_TWO = "entityManagerFactoryTwo";
	public static final String DATASOURCE_PU_TWO = "dbTwo";
	public static final String DATASOURCE_TRANSACTION_MANAGER_TWO = "transactionManagerTwo";	
}
