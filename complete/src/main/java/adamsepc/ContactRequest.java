package adamsepc;


public class ContactRequest {

    private String name;
    private String email;
    private String contact;
    private String enquiryType;
    private String enquiry;

    public String getEnquiry() {
        return enquiry;
    }

    public void setEnquiry(final String enquiry) {
        this.enquiry = enquiry;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(final String contact) {
        this.contact = contact;
    }

    public String getEnquiryType() {
        return enquiryType;
    }

    public void setEnquiryType(final String enquiryType) {
        this.enquiryType = enquiryType;
    }
}
