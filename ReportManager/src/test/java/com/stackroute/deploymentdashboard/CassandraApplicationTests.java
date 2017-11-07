//package com.stackroute.deploymentdashboard;
//
//import java.io.IOException;
//import java.util.HashMap;
//
//import org.apache.cassandra.config.ConfigurationException;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.apache.thrift.transport.TTransportException;
//import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
//import org.junit.AfterClass;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cassandra.core.cql.CqlIdentifier;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.datastax.driver.core.Cluster;
//import com.datastax.driver.core.Session;
//import com.stackroute.deploymentdashboard.configuration.CassandraConfiguration;
//import com.stackroute.deploymentdashboard.model.UserCredentials;
//import com.stackroute.deploymentdashboard.repository.UserCredentialsCRUDRepository;
//import com.stackroute.deploymentdashboard.service.CassandraDatabaseServiceImpl;
//
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = CassandraConfiguration.class)
//public class CassandraApplicationTests {
//	
////	private static final Log LOGGER = LogFactory.getLog(CassandraApplicationTests.class);
////
////    public static final String KEYSPACE_CREATION_QUERY = "CREATE KEYSPACE IF NOT EXISTS tutorialspoint " + "WITH replication = { 'class': 'SimpleStrategy', 'replication_factor': '3' };";
////
////    public static final String KEYSPACE_ACTIVATE_QUERY = "USE tutorialspoint;";
////
////    public static final String DATA_TABLE_NAME = "UserCredentials";
//
//
//	@Autowired
//	private UserCredentialsCRUDRepository userCredentialsCRUDRepository;
//	
////	@Autowired
////	private CassandraDatabaseServiceImpl cassandraDatabaseServiceImpl;
////	
////	@BeforeClass
////	public static void startCassandraEmbedded() throws TTransportException, IOException, InterruptedException, ConfigurationException { 
////	   EmbeddedCassandraServerHelper.startEmbeddedCassandra();
////	   LOGGER.info("before class started.");
////	    Cluster cluster = Cluster.builder()
////	      .addContactPoints("127.0.0.1").withPort(9042).build();
////	    final Session session = cluster.connect(); 
////	    session.execute(KEYSPACE_CREATION_QUERY);
////        session.execute(KEYSPACE_ACTIVATE_QUERY);
////        LOGGER.info("KeySpace created and activated.");
////        Thread.sleep(5000);
////	}
//	
////	@Before
////    public void createTable() throws InterruptedException, TTransportException, ConfigurationException, IOException {
////        adminTemplate.createTable(true, CqlIdentifier.cqlId(DATA_TABLE_NAME), UserCredentials.class, new HashMap<String, Object>());
////    }
//	
//	
//	
//	@Test
//    public void saveOneTest() {
//       
//		UserCredentials userCredentials  = new UserCredentials();
//		userCredentials.setProjectId("project1");
//		userCredentials.setBuildStatus("error");
//		userCredentials = userCredentialsCRUDRepository.save(userCredentials);
//        UserCredentials retrieveduserCredentials = (UserCredentials) userCredentialsCRUDRepository.findByProjectid("project1");
//        Assert.assertEquals("error", retrieveduserCredentials.getBuildStatus());
//    }
//
////	@AfterClass
////	public static void stopCassandraEmbedded() {
////	    EmbeddedCassandraServerHelper.cleanEmbeddedCassandra();
////	}
//	
//
//}
