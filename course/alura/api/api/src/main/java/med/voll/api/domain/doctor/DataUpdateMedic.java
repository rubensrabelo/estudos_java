package med.voll.api.domain.doctor;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.address.AddressData;

public record DataUpdateMedic(
		@NotNull Long id,
		String name,
		String phoneNumber,
		AddressData address
		) {
}
