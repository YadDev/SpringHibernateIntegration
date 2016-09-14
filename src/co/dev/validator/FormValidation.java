package co.dev.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import co.dev.beans.RegisterUser;
import co.dev.beans.User;

@Component
public class FormValidation implements Validator {

	private Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	String ID_PATTERN = "[0-9]+";
	String STRING_PATTERN = "[a-zA-Z]+";
	String MOBILE_PATTERN = "[0-9]{10}";

	@Override
	public boolean supports(Class arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {

		RegisterUser user = (RegisterUser) target;

		ValidationUtils.rejectIfEmpty(errors, "firstName",
				"required.firstName", "First Name is required.");
		ValidationUtils.rejectIfEmpty(errors, "lastName",
				"required.lastName", "Last Name is required.");

		// input string conatains characters only
		if (!(user.getFirstName() != null && user.getFirstName().isEmpty())) {
			pattern = Pattern.compile(STRING_PATTERN);
			matcher = pattern.matcher(user.getFirstName());
			if (!matcher.matches()) {
				errors.rejectValue("firstName", "firstName.containNonChar",
						"Enter a valid First Name");
			}
		}

		// radio buttons validation
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender",
				"required.gender", "Select your gender");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
				"required.email", "Email is required.");

		// email validation in spring
		if (!(user.getEmail() != null && user.getEmail().isEmpty())) {
			pattern = Pattern.compile(EMAIL_PATTERN);
			matcher = pattern.matcher(user.getEmail());
			if (!matcher.matches()) {
				errors.rejectValue("email", "email.incorrect",
						"Enter a correct email");
			}
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone",
				"required.phone", "Phone is required.");

		// phone number validation
		if (!(user.getPhone() != null && user.getPhone().isEmpty())) {
			pattern = Pattern.compile(MOBILE_PATTERN);
			matcher = pattern.matcher(user.getPhone());
			if (!matcher.matches()) {
				errors.rejectValue("phone", "phone.incorrect",
						"Enter a correct phone number");
			}
		}

		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
		 "required.password", "Password is required.");
		//
		// // password matching validation
		// if (!user.getPassword().equals(user.getConfirmPassword())) {
		// errors.rejectValue("confirmPassword", "password.mismatch",
		// "Password does not match");
		// }

		// drop down list validation
		// if (user.getCity().equals("select")) {
		// errors.rejectValue("city", "city.select", "select a city");
		// }

		// text area validation
		// ValidationUtils.rejectIfEmpty(errors, "overview",
		// "required.overview",
		// "Overview is required.");
		//
		// // checkbox validation
		// if (user.getInterest().length <= 0) {
		// errors.rejectValue("interest", "noselect.interest",
		// "Select atleast one interest");
		// }
	}

	// Add New User Validation
	public void validateUser(Object target, Errors errors) {

		User user = (User) target;

		ValidationUtils.rejectIfEmpty(errors, "firstName",
				"required.firstName", "First Name is required.");
		ValidationUtils.rejectIfEmpty(errors, "lastName",
				"required.lastName", "Last Name is required.");


		// input string contains characters only
		if (!(user.getFirstName() != null && user.getFirstName().isEmpty())) {
			pattern = Pattern.compile(STRING_PATTERN);
			matcher = pattern.matcher(user.getFirstName());
			if (!matcher.matches()) {
				errors.rejectValue("firstName", "firstName.containNonChar",
						"Enter a valid First Name");
			}
		}

		// radio buttons validation
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender",
				"required.gender", "Select your gender");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
				"required.email", "Email is required.");

		// email validation in spring
		if (!(user.getEmail() != null && user.getEmail().isEmpty())) {
			pattern = Pattern.compile(EMAIL_PATTERN);
			matcher = pattern.matcher(user.getEmail());
			if (!matcher.matches()) {
				errors.rejectValue("email", "email.incorrect",
						"Enter a correct email");
			}
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone",
				"required.phone", "Phone is required.");

		// phone number validation
		if (!(user.getPhone() != null && user.getPhone().isEmpty())) {
			pattern = Pattern.compile(MOBILE_PATTERN);
			matcher = pattern.matcher(user.getPhone());
			if (!matcher.matches()) {
				errors.rejectValue("phone", "phone.incorrect",
						"Enter a correct phone number");
			}
		}

//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
//				"required.password", "Password is required.");
		//
		// // password matching validation
		// if (!user.getPassword().equals(user.getConfirmPassword())) {
		// errors.rejectValue("confirmPassword", "password.mismatch",
		// "Password does not match");
		// }

		// drop down list validation
		if (user.getCity().equals("select")) {
			errors.rejectValue("city", "city.select", "select a city");
		}

		// text area validation
		// ValidationUtils.rejectIfEmpty(errors, "overview",
		// "required.overview",
		// "Overview is required.");
		//
		// // checkbox validation
		// if (user.getInterest().length <= 0) {
		// errors.rejectValue("interest", "noselect.interest",
		// "Select atleast one interest");
		// }
	}
}
