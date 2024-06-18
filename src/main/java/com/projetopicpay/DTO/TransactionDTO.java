package com.projetopicpay.DTO;

import java.math.BigDecimal;

public record TransactionDTO(BigDecimal value, Long senderId, Long receiveriD) {
}
