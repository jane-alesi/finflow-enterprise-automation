package com.satware.finflow.common.util;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.regex.Pattern;
import java.util.Currency;
import java.util.Set;

/**
 * Validation Utilities
 * 
 * Common validation methods for financial data and
 * business rules across the FinFlow platform.
 * 
 * @author satware AG - FinFlow Team
 */
public final class ValidationUtils {
    
    // IBAN validation pattern (simplified)
    private static final Pattern IBAN_PATTERN = Pattern.compile("^[A-Z]{2}[0-9]{2}[A-Z0-9]{4}[0-9]{7}([A-Z0-9]?){0,16}$");
    
    // BIC/SWIFT code pattern
    private static final Pattern BIC_PATTERN = Pattern.compile("^[A-Z]{6}[A-Z0-9]{2}([A-Z0-9]{3})?$");
    
    // Supported currencies for financial transactions
    private static final Set<String> SUPPORTED_CURRENCIES = Set.of("EUR", "USD", "GBP", "CHF", "JPY", "CAD", "AUD");
    
    private ValidationUtils() {
        // Utility class - prevent instantiation
    }
    
    /**
     * Validate IBAN (International Bank Account Number)
     * 
     * @param iban IBAN to validate
     * @return true if IBAN is valid
     */
    public static boolean isValidIBAN(String iban) {
        if (StringUtils.isBlank(iban)) {
            return false;
        }
        
        String cleanIban = iban.replaceAll("\\s+", "").toUpperCase();
        
        // Basic format check
        if (!IBAN_PATTERN.matcher(cleanIban).matches()) {
            return false;
        }
        
        // TODO: Implement full IBAN checksum validation
        // This is a simplified validation - full implementation would
        // include the mod-97 checksum calculation
        
        return cleanIban.length() >= 15 && cleanIban.length() <= 34;
    }
    
    /**
     * Validate BIC/SWIFT code
     * 
     * @param bic BIC code to validate
     * @return true if BIC is valid
     */
    public static boolean isValidBIC(String bic) {
        if (StringUtils.isBlank(bic)) {
            return false;
        }
        
        String cleanBic = bic.replaceAll("\\s+", "").toUpperCase();
        return BIC_PATTERN.matcher(cleanBic).matches();
    }
    
    /**
     * Validate currency code
     * 
     * @param currencyCode Currency code to validate
     * @return true if currency is supported
     */
    public static boolean isValidCurrency(String currencyCode) {
        if (StringUtils.isBlank(currencyCode)) {
            return false;
        }
        
        try {
            Currency currency = Currency.getInstance(currencyCode.toUpperCase());
            return SUPPORTED_CURRENCIES.contains(currency.getCurrencyCode());
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
    
    /**
     * Validate monetary amount
     * 
     * @param amount Amount to validate
     * @param minAmount Minimum allowed amount (inclusive)
     * @param maxAmount Maximum allowed amount (inclusive)
     * @return true if amount is within valid range
     */
    public static boolean isValidAmount(BigDecimal amount, BigDecimal minAmount, BigDecimal maxAmount) {
        if (amount == null) {
            return false;
        }
        
        // Check for negative amounts (generally not allowed in financial transactions)
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            return false;
        }
        
        // Check minimum amount
        if (minAmount != null && amount.compareTo(minAmount) < 0) {
            return false;
        }
        
        // Check maximum amount
        if (maxAmount != null && amount.compareTo(maxAmount) > 0) {
            return false;
        }
        
        // Check for reasonable decimal places (max 2 for most currencies)
        return amount.scale() <= 2;
    }
    
    /**
     * Validate account number format
     * 
     * @param accountNumber Account number to validate
     * @return true if account number format is valid
     */
    public static boolean isValidAccountNumber(String accountNumber) {
        if (StringUtils.isBlank(accountNumber)) {
            return false;
        }
        
        String cleanAccount = accountNumber.replaceAll("\\s+", "");
        
        // Basic validation - alphanumeric, reasonable length
        return cleanAccount.matches("^[A-Z0-9]{8,34}$");
    }
    
    /**
     * Validate transaction reference
     * 
     * @param reference Transaction reference to validate
     * @return true if reference format is valid
     */
    public static boolean isValidTransactionReference(String reference) {
        if (StringUtils.isBlank(reference)) {
            return false;
        }
        
        // Transaction reference should be alphanumeric with reasonable length
        return reference.matches("^[A-Z0-9-_]{6,35}$");
    }
    
    /**
     * Validate workflow ID format
     * 
     * @param workflowId Workflow ID to validate
     * @return true if workflow ID format is valid
     */
    public static boolean isValidWorkflowId(String workflowId) {
        if (StringUtils.isBlank(workflowId)) {
            return false;
        }
        
        // Workflow ID should follow specific naming convention
        return workflowId.matches("^[a-z][a-z0-9-]*[a-z0-9]$") && workflowId.length() >= 3 && workflowId.length() <= 50;
    }
    
    /**
     * Get supported currencies
     * 
     * @return set of supported currency codes
     */
    public static Set<String> getSupportedCurrencies() {
        return Set.copyOf(SUPPORTED_CURRENCIES);
    }
}