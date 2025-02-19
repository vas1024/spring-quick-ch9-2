package ch9.controlers;

import ch9.services.LoggedUserManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
  private final LoggedUserManagementService loggedUserManagementService;
  public MainController( LoggedUserManagementService loggedUserManagementService){
    this.loggedUserManagementService = loggedUserManagementService;
  }


  @GetMapping("/main")
  public String mainGet( Model model ){
    String username = loggedUserManagementService.getUsername();
    if( username != null ){
      model.addAttribute("username", username );
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
