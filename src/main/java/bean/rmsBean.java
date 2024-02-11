package bean;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class rmsBean implements Serializable {
    private String username;
    private String password;

    // Getter and setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String result() {
        FacesContext context = FacesContext.getCurrentInstance();
        boolean isValid = false;

        // Perform username validation
        if (username != null && !username.isEmpty()) {
            if (username.length() >= 5 && username.length() <= 20) {
                // Add validation error message for username
                context.addMessage("form:username", new FacesMessage(FacesMessage.SEVERITY_INFO, "Validation Success", "Username must be between 5 and 20 characters"));
                isValid = true;
            } else {
                context.addMessage("form:username", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validation Error1", "Username must be between 5 and 20 characters"));
            }
        } else {
            context.addMessage("form:username", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validation Error2", "Username must be provided"));
        }

        // Perform password validation
        if (password != null && !password.isEmpty()) {
            if (password.length() >= 5 && password.length() <= 10) {
                // Add validation error message for username
                context.addMessage("form:username", new FacesMessage(FacesMessage.SEVERITY_INFO, "Validation Success", "Username must be between 5 and 20 characters"));
                isValid = true;
            } else {
                context.addMessage("form:username", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validation Error1", "Username must be between 5 and 20 characters"));
            }
        } else {
            context.addMessage("form:username", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validation Error2", "Username must be provided"));
        }

        // Return the outcome to navigate to (if any)
        return isValid ? "success" : null; // Navigate to a success page if validation is successful
    }
}
