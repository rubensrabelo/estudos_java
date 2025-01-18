package med.voll.api.web.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginDto(@NotBlank(message = "Login é obrigatório!") String login, @NotBlank(message = "Senha é obrigatória!") String senha) {}