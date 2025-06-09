package com.satware.finflow.common.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Utility class for common FinFlow operations.
 */
public class FinFlowUtils {

    /**
     * Checks if a given string is null, empty, or contains only whitespace.
     * @param str The string to check.
     * @return true if the string is null, empty, or blank; false otherwise.
     */
    public static boolean isBlank(String str) {
        return StringUtils.isBlank(str);
    }

    /**
     * Generates a unique ID based on current timestamp and a random UUID.
     * @return A unique ID string.
     */
    public static String generateUniqueId() {
        return System.currentTimeMillis() + "-" + java.util.UUID.randomUUID().toString();
    }

    /**
     * Formats a given amount to a standard currency string.
     * @param amount The amount to format.
     * @param currencyCode The currency code (e.g., "USD", "EUR").
     * @return Formatted currency string.
     */
    public static String formatCurrency(java.math.BigDecimal amount, String currencyCode) {
        if (amount == null || isBlank(currencyCode)) {
            return "";
        }
        java.text.NumberFormat format = java.text.NumberFormat.getCurrencyInstance(
            java.util.Currency.getInstance(currencyCode).getAvailableLocales()[0]
        );
        format.setCurrency(java.util.Currency.getInstance(currencyCode));
        return format.format(amount);
    }
}
