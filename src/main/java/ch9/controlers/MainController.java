package ch9.controlers;

import ch9.services.LoggedUserManagementService;
import ch9.services.LoginCountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
  private final LoggedUserManagementService loggedUserManagementService;
  private final LoginCountService loginCountService;
  public MainController( LoggedUserManagementService loggedUserManagementService,
                         LoginCountService loginCountService ){
    this.loggedUserManagementService = loggedUserManagementService;
    this.loginCountService = loginCountService;
  }


  @GetMapping("/main")
  public String mainGet( HttpSession httpSession, Model model ){
    String username = loggedUserManagementService.getUsername();
    if( username != null ){
      model.addAttribute("username", username );
      model.addAttribute("sessionid", httpSession.getId() );
      model.addAttribute("count", loginCountService.getCount());
      return "main.html";
    }
    else return "redirect:/";
  }

  @PostMapping("/main")
  public String mainPost() {
    loggedUserManagementService.setUsername( null );
    return "redirect:/";
  }
}
