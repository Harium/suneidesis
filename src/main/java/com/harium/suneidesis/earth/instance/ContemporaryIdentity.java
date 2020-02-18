package com.harium.suneidesis.earth.instance;

import com.harium.suneidesis.instance.Identity;

/**
 * Class to represent identity following current Earth's standards
 *
 * Reference:
 * https://en.wikipedia.org/wiki/National_identification_number
 */
public class ContemporaryIdentity extends Identity {

    public static final String FATHERS_NAME = "father_name";
    public static final String MOTHERS_NAME = "mother_name";
    public static final String ADDRESS = "address";
    public static final String EMAIL = "email";
    public static final String ID_NUMBER = "id_number";
    public static final String DRIVER_LICENSE = "driver_license";
    public static final String BANK = "bank";
    public static final String BANK_ACCOUNT = "bank_account";

    public String getAddress() {
        return super.get(ADDRESS);
    }

    public void setAddress(String address) {
        put(ADDRESS, address);
    }

    public String getEmail() {
        return super.get(EMAIL);
    }

    public void setEmail(String email) {
        put(EMAIL, email);
    }

    public String getIdNumber() {
        return super.get(ID_NUMBER);
    }

    public void setIdNumber(String idNumber) {
        put(ID_NUMBER, idNumber);
    }

    public String getFathersName() {
        return super.get(FATHERS_NAME);
    }

    public void setFathersName(String fathersName) {
        put(FATHERS_NAME, fathersName);
    }

    public String getMothersName() {
        return super.get(MOTHERS_NAME);
    }

    public void setMothersName(String mothersName) {
        put(MOTHERS_NAME, mothersName);
    }

    public String getDriverLicense() {
        return super.get(DRIVER_LICENSE);
    }

    public void setDriverLicense(String driverLicense) {
        put(DRIVER_LICENSE, driverLicense);
    }

    public String getBank() {
        return super.get(BANK);
    }

    public void setBank(String bank) {
        put(BANK, bank);
    }

    public String getBankAccount() {
        return super.get(BANK_ACCOUNT);
    }

    public void setBankAccount(String bankAccount) {
        put(BANK_ACCOUNT, bankAccount);
    }
}
