package com.upraiselabs.models;

public enum ProofOfAccountEnum {
  CANCELLED_CHEQUE_OR_COPY("Cancelled Cheque or Copy"),
  BANK_PASSBOOK("Bank Passbook"),
  BANK_STATEMENT("Bank Statement"),
  BANK_LETTER_CONFIRMING_ACCOUNT("Letter from bank confirming the account");

  private String proofOfAccountEnum;

  ProofOfAccountEnum(String proofOfAccountEnum) {
    this.proofOfAccountEnum = proofOfAccountEnum;
  }

  public String getProofOfAccountEnum() {
    return this.proofOfAccountEnum;
  }

}
