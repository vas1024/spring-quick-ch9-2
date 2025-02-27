package ch9.model;

import ch9.services.LoggedUserManagementService;
import ch9.services.LoginCountService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Component
@RequestScope
public class LoginProcessor {
  private final LoggedUserManagementService loggedUserManagementService;
  private final LoginCountService loginCountService;
  private String username;
  private String password;
  public LoginProcessor(
          LoggedUserManagementService loggedUserManagementService,
          LoginCountService loginCountService ){
    this.loggedUserManagementService = loggedUserManagementService;
    this.loginCountService = loginCountService;
  }

  public boolean login() {
    String username = this.getUsername();
    String password = this.getPassword();
    boolean result = false;
    if( "aaa".equals( username ) && "bbb".equals( password )) {
      result = true;
      loggedUserManagementService.setUsername( username );
      loginCountService.increment();
    }
    return result;
  }

  public String getUsername(){ return username; }
  public String getPassword(){ return password; }
  public void setUsername( String username ){ this.username = username; }
  public void setPassword( String password ){ this.password = password; }

}
