package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final String nickName;
  private final String title;
  private final String company;
  private final String address;
  private final String home;
  private final String mobile;
  private final String work;
  private final String fax;
  private final String email;
  private final String email2;
  private final String email3;
  private final String homepage;
  private final String address2;
  private final String notes;
  private final String phone2;
  private int id;
  private String group;


  public ContactData(String firstName, String middleName, String lastName, String nickName, String title, String company, String address, String home, String mobile, String work, String fax, String email, String email2, String email3, String homepage, String address2, String notes, String phone2, String group) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nickName = nickName;
    this.title = title;
    this.company = company;
    this.address = address;
    this.home = home;
    this.mobile = mobile;
    this.work = work;
    this.fax = fax;
    this.email = email;
    this.email2 = email2;
    this.email3 = email3;
    this.homepage = homepage;
    this.address2 = address2;
    this.notes = notes;
    this.phone2 = phone2;
    this.group = group;
  }

  public ContactData(int id, String firstName, String lastName, String address) {
    this.id = id;
    this.firstName = firstName;
    this.middleName = null;
    this.lastName = lastName;
    this.nickName = null;
    this.title = null;
    this.company = null;
    this.address = address;
    this.home = null;
    this.mobile = null;
    this.work = null;
    this.fax = null;
    this.email = null;
    this.email2 = null;
    this.email3 = null;
    this.homepage = null;
    this.address2 = null;
    this.notes = null;
    this.phone2 = null;
    this.group = null;
  }
  @Override
  public String toString() {
    return "ContactData{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", id=" + id +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(middleName, that.middleName) &&
            Objects.equals(lastName, that.lastName) &&
            Objects.equals(nickName, that.nickName) &&
            Objects.equals(title, that.title) &&
            Objects.equals(company, that.company) &&
            Objects.equals(address, that.address) &&
            Objects.equals(home, that.home) &&
            Objects.equals(mobile, that.mobile) &&
            Objects.equals(work, that.work) &&
            Objects.equals(fax, that.fax) &&
            Objects.equals(email, that.email) &&
            Objects.equals(email2, that.email2) &&
            Objects.equals(email3, that.email3) &&
            Objects.equals(homepage, that.homepage) &&
            Objects.equals(address2, that.address2) &&
            Objects.equals(notes, that.notes) &&
            Objects.equals(phone2, that.phone2) &&
            Objects.equals(group, that.group);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, middleName, lastName, nickName, title, company, address, home, mobile, work, fax, email, email2, email3, homepage, address2, notes, phone2, id, group);
  }


  public int getId() {
  return id;
}

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickName() {
    return nickName;
  }
  public String getTitle() {
    return title;
  }
  public String getCompany() {
    return company;
  }
  public String getAddress() {
    return address;
  }
  public String getHome() {
    return home;
  }
  public String getMobile() {
    return mobile;
  }
  public String getWork() {
    return work;
  }
  public String getFax() {
    return fax;
  }
  public String getEmail() {
    return email;
  }
  public String getEmail2() {
    return email2;
  }
  public String getEmail3() {
    return email3;
  }
  public String getHomepage() {
    return homepage;
  }
  public String getAddress2() {
    return address2;
  }
  public String getNotes() {
    return notes;
  }
  public String getPhone2() {
    return phone2;
  }

  public String getGroup() {
    return group;
  }
}

