package br.com.solcode.outsourcing.exceptions;


import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class ValidationFormat {
	public static String formatarErros(BindingResult bindingResult) {
		JSONObject jsonObject = null;
		JSONArray jsonArray = new JSONArray();
		
		List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
		
		for (FieldError erro: fieldErrorList) {
			jsonObject = new JSONObject().put("Field", erro.getField());
			jsonObject.put("message", erro.getDefaultMessage());
			jsonArray.put(jsonObject);
		}
		
		JSONObject json = new JSONObject().put("Errors", jsonArray);
		return json.toString();
	}
}