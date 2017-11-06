package com.stackroute.deploymentdashboard.usermanagement.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stackroute.deploymentdashboard.usermanagement.Application;
import com.stackroute.deploymentdashboard.usermanagement.Exceptions.UserNotFoundException;
import com.stackroute.deploymentdashboard.usermanagement.domains.UserModel;
import com.stackroute.deploymentdashboard.usermanagement.repository.UserManagementCRUDRepository;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserManagementServiceImplTest {

	@Mock
	private UserManagementServiceImpl userService;

	@Mock
	private UserManagementCRUDRepository userRepo;


	@Before
	public void setupMock() {
		//MockitoAnnotations.initMocks(this);
		//userService = new UserManagementServiceImpl();
		// userService.setProjectrepository(projectManagementCRUDRepository);
		UserModel user = new UserModel("1", "Devendra", "devendra.baruah@cgi.com","male","active");
	}

	@Test
	public void testMockCreation() {
		assertNotNull(userService);
		assertNotNull(userRepo);
	}

	@Test
	public void testReadByIdMethodOfService() throws UserNotFoundException {
		UserModel user1 = new UserModel("1", "Devendra", "devendra.baruah@cgi.com","male","active");

		when(userService.readById("1")).thenReturn(user1);
		assertThat(user1.getUserName(), is(equalTo("Devendra")));
	}

	@Test
	public void testDeleteByIdMethodOfService() throws UserNotFoundException {
		UserModel b = new UserModel("1", "Devendra", "devendra.baruah@cgi.com","male","active");
		UserModel c=null;
		when(userService.readById("1")).thenReturn(b);
		assertThat(b.getUserName(), is(equalTo("Devendra")));
		userService.deleteById("1");
		when(userService.readById("1")).thenReturn(c);
		assertThat(c, is(equalTo(null)));
	}
	
	@Test
	public void testUpdateMethodOfService() throws UserNotFoundException {
		UserModel b = new UserModel("1", "Devendra", "devendra.baruah@cgi.com","male","active");
		UserModel c=new UserModel("1", "Dharmendra", "devendra.baruah@cgi.com","male","active");
		when(userService.readById("1")).thenReturn(b);
		assertThat(b.getUserName(), is(equalTo("Devendra")));
		userService.update(c);
		when(userService.readById("1")).thenReturn(c);
		assertThat(c.getUserName(), is(equalTo("Dharmendra")));
	}
	
	@Test
	public void testAddUserMethodOfService() throws Exception {
		UserModel b = new UserModel("1", "Devendra", "devendra.baruah@cgi.com","male","active");
		UserModel c= new UserModel("2", "Dharmendra", "devendra.baruah@cgi.com","male","active");
		userService.addUser(c);
		when(userService.readById("2")).thenReturn(c);
		assertThat(c.getUserName(), is(equalTo("Dharmendra")));
	}
	
	/*@Test
	public void testReadMethodOfService() throws Exception {
		UserModel b = new UserModel("1", "Devendra", "devendra.baruah@cgi.com");
		UserModel c=new UserModel("2", "Dharmendra", "devendra.baruah@cgi.com");
		ArrayList<UserModel> userList = new ArrayList<UserModel>();
		userList.add(b);
		userList.add(c);
		
		_Service.addUser(b);
		_Service.addUser(c);
		when(_Service.read()).thenReturn(userList);
		assertThat(userList.get(0).getUsername(), is(equalTo("Devendra")));
	}*/

}