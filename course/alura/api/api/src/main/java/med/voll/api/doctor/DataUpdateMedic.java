package med.voll.api.doctor;

import jakarta.validation.constraints.NotNull;
import med.voll.api.address.AddressData;

public record DataUpdateMedic(
		@NotNull Long id,
		String name,
		String phoneNumber,
		AddressData address
		) {
}