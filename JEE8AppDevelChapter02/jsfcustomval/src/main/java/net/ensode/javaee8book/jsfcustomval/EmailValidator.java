package net.ensode.javaee8book.jsfcustomval;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.apache.commons.lang3.StringUtils;

@FacesValidator(value = "emailValidator")
public class EmailValidator implements Validator {

  @Override
  public void validate(FacesContext facesContext,
      UIComponent uiComponent,
      Object value) throws ValidatorException {
    org.apache.commons.validator.routines.EmailValidator emailValidator =
        org.apache.commons.validator.routines.EmailValidator.getInstance();
    HtmlInputText htmlInputText = (HtmlInputText) uiComponent;

    String email = (String) value;
      System.out.println("value:" + email);
      System.out.println("!StringUtils.isEmpty(email): "  + !StringUtils.isEmpty(email));

    if (!StringUtils.isEmpty(email)) {
      if (!emailValidator.isValid(email)) {
        FacesMessage facesMessage = new FacesMessage(htmlInputText.
            getLabel()
            + ": email format is not valid");
        throw new ValidatorException(facesMessage);
      }
    }
    FacesMessage facesMessage = new FacesMessage(htmlInputText.
            getLabel()
            + ": email is empty");
        throw new ValidatorException(facesMessage);
  }
}
