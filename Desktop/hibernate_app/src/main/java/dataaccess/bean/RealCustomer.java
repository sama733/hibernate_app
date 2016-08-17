package dataaccess.bean;

public class RealCustomer {
    private String firstName;
    private String lastName;
    private String fatherName;
    private String dateOfBirth;
    private String nationalCode;
    private Integer customerId;

    public RealCustomer(String firstName, String lastName, String fatherName, String dateOfBirth, String nationalCode, int customerId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.dateOfBirth = dateOfBirth;
        this.nationalCode = nationalCode;
        this.customerId = customerId;
    }


    public RealCustomer() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}

