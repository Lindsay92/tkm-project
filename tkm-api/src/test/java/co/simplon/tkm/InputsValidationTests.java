package co.simplon.tkm;

import static org.hamcrest.CoreMatchers.not;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@DisplayName("Tests inputs against validation") 
class InputsValidationTests extends BaseMvcTests {

	@DisplayName("Should inputs be valid")
	@ParameterizedTest
	@CsvFileSource(
			resources = { "/csv/validation/account-create-valid.csv"},
			numLinesToSkip = 1, delimiter = DELIMITER,
			maxCharsPerColumn = MAX_CHARS_PER_COLUMN)
	void shouldBeValid(String method, String path, String tokenName,
			String json) throws Exception {
		perform(method, path, tokenName, json).andExpect(status().is(not(400)));
	}
}
