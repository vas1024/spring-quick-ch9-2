package ch9.services;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class LoggedUserManagementService {
  private String username;

//  public LoggedUserManagementService( String username ){ this.username = username; }
  public String getUsername() { return username; }
  public void setUsername( String username ) { this.username = username; }

}
