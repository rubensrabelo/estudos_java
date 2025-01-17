package med.voll.api.domain.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressData(
		@NotBlank String street,
		@NotBlank String neighborhood,
		@NotBlank @Pattern(regexp = "\\d{8}") String postalCode,
		String number,
		String additionalInfo,
		@NotBlank String city,
		@NotBlank String state) {
}
