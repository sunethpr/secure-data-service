/*
 * Copyright 2012 Shared Learning Collaborative, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.slc.sli.sif.generator;

import java.math.BigDecimal;
import java.util.Calendar;

import junit.framework.Assert;
import openadk.library.ADK;
import openadk.library.ADKException;
import openadk.library.common.Address;
import openadk.library.common.AddressList;
import openadk.library.common.AddressType;
import openadk.library.common.CitizenshipStatus;
import openadk.library.common.CountryCode;
import openadk.library.common.Demographics;
import openadk.library.common.Email;
import openadk.library.common.EmailList;
import openadk.library.common.EmailType;
import openadk.library.common.EntryTypeCode;
import openadk.library.common.ExitTypeCode;
import openadk.library.common.GradeLevel;
import openadk.library.common.GradeLevelCode;
import openadk.library.common.GradeLevels;
import openadk.library.common.MembershipType;
import openadk.library.common.Name;
import openadk.library.common.NameType;
import openadk.library.common.NonResidentAttendRationale;
import openadk.library.common.OrganizationRelationshipType;
import openadk.library.common.PhoneNumber;
import openadk.library.common.PhoneNumberList;
import openadk.library.common.PhoneNumberType;
import openadk.library.common.PublicSchoolResidenceStatus;
import openadk.library.common.StatePrCode;
import openadk.library.common.Street;
import openadk.library.common.StudentLEARelationship;
import openadk.library.common.YesNoUnknown;
import openadk.library.datamodel.SEAInfo;
import openadk.library.student.EducationAgencyTypeCode;
import openadk.library.student.FTPTStatus;
import openadk.library.student.LEAInfo;
import openadk.library.student.OperationalStatus;
import openadk.library.student.SchoolFocus;
import openadk.library.student.SchoolFocusList;
import openadk.library.student.SchoolFocusType;
import openadk.library.student.SchoolInfo;
import openadk.library.student.SchoolLevelType;
import openadk.library.student.StudentAddressList;
import openadk.library.student.StudentPersonal;
import openadk.library.student.StudentSchoolEnrollment;
import openadk.library.student.TimeFrame;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for SifEntityGenerator
 *
 * @author vmcglaughlin
 *
 */
public class SifEntityGeneratorTest {

    @Before
    public void setup() throws ADKException {
        ADK.initialize();
    }

    @Test
    public void testGenerateTestSchoolInfo() {
        SchoolInfo schoolInfo = SifEntityGenerator.generateTestSchoolInfo();
        Assert.assertEquals(SifEntityGenerator.TEST_SCHOOLINFO_REFID, schoolInfo.getRefId());
        Assert.assertEquals("Daybreak West High", schoolInfo.getStateProvinceId());
        Assert.assertEquals("421575003045", schoolInfo.getNCESId());
        Assert.assertEquals("Daybreak West High", schoolInfo.getSchoolName());
        Assert.assertEquals(SifEntityGenerator.TEST_LEAINFO_REFID, schoolInfo.getLEAInfoRefId());
        Assert.assertEquals("http://IL-DAYBREAK.edu", schoolInfo.getSchoolURL());
        Assert.assertEquals(OperationalStatus.SCHOOL_CLOSED.getValue(), schoolInfo.getOperationalStatus());
        Assert.assertEquals(SchoolLevelType._0031_2402_HIGH_SCHOOL.getValue(), schoolInfo.getSchoolType());

        SchoolFocusList schoolFocusList = schoolInfo.getSchoolFocusList();
        Assert.assertEquals(1, schoolFocusList.size());

        SchoolFocus schoolFocus = schoolFocusList.get(0);
        Assert.assertEquals(SchoolFocusType.REGULAR.getValue(), schoolFocus.getValue());

        GradeLevels gradeLevels = schoolInfo.getGradeLevels();
        Assert.assertEquals(4,  gradeLevels.size());

        GradeLevel gradeLevel1 = gradeLevels.get(0);
        Assert.assertEquals(GradeLevelCode._09.getValue(), gradeLevel1.getCode());

        GradeLevel gradeLevel2 = gradeLevels.get(1);
        Assert.assertEquals(GradeLevelCode._10.getValue(), gradeLevel2.getCode());

        GradeLevel gradeLevel3 = gradeLevels.get(2);
        Assert.assertEquals(GradeLevelCode._11.getValue(), gradeLevel3.getCode());

        GradeLevel gradeLevel4 = gradeLevels.get(3);
        Assert.assertEquals(GradeLevelCode._12.getValue(), gradeLevel4.getCode());

        AddressList addressList = schoolInfo.getAddressList();
        Assert.assertEquals(1, addressList.size());

        Address address = addressList.get(0);
        Assert.assertEquals("Salt Lake City", address.getCity());
        Assert.assertEquals(StatePrCode.IL.getValue(), address.getStateProvince());
        Assert.assertEquals(CountryCode.US.getValue(), address.getCountry());
        Assert.assertEquals("84102", address.getPostalCode());
        Assert.assertEquals(AddressType.MAILING.getValue(), address.getType());

        Street street = address.getStreet();
        Assert.assertEquals("1 IBM Plaza", street.getLine1());
        Assert.assertEquals("2000", street.getApartmentNumber());
        Assert.assertEquals("Suite 2000", street.getLine2());
        Assert.assertEquals("Salt Lake City, IL 84102", street.getLine3());
        Assert.assertEquals("IBM way", street.getStreetName());
        Assert.assertEquals("1", street.getStreetNumber());
        Assert.assertEquals("Plaza", street.getStreetType());
        Assert.assertEquals("Suite", street.getApartmentType());

        PhoneNumberList phoneNumberList = schoolInfo.getPhoneNumberList();
        Assert.assertEquals(2, phoneNumberList.size());

        PhoneNumber phoneNumber1 = phoneNumberList.get(0);
        Assert.assertEquals(PhoneNumberType.PRIMARY.getValue(), phoneNumber1.getType());
        Assert.assertEquals("(312) 555-1234", phoneNumber1.getNumber());

        PhoneNumber phoneNumber2 = phoneNumberList.get(1);
        Assert.assertEquals(PhoneNumberType.FAX.getValue(), phoneNumber2.getType());
        Assert.assertEquals("(312) 555-2364", phoneNumber2.getNumber());
    }

    @Test
    public void testGenerateTestLeaInfo() {
        LEAInfo leaInfo = SifEntityGenerator.generateTestLEAInfo();
        Assert.assertEquals(SifEntityGenerator.TEST_LEAINFO_REFID, leaInfo.getRefId());
        Assert.assertEquals("IL-DAYBREAK", leaInfo.getStateProvinceId());
        Assert.assertEquals("4215750", leaInfo.getNCESId());
        Assert.assertEquals("Daybreak School District 4530", leaInfo.getLEAName());
        Assert.assertEquals("http://IL-DAYBREAK.edu", leaInfo.getLEAURL());
        Assert.assertEquals(OperationalStatus.SCHOOL_CLOSED.getValue(), leaInfo.getOperationalStatus());
        Assert.assertEquals(EducationAgencyTypeCode.REG_DISTRICT.getValue(), leaInfo.getEducationAgencyType().getCode());

        GradeLevels gradeLevels = leaInfo.getGradeLevels();
        Assert.assertEquals(4,  gradeLevels.size());

        GradeLevel gradeLevel1 = gradeLevels.get(0);
        Assert.assertEquals(GradeLevelCode._09.getValue(), gradeLevel1.getCode());

        GradeLevel gradeLevel2 = gradeLevels.get(1);
        Assert.assertEquals(GradeLevelCode._10.getValue(), gradeLevel2.getCode());

        GradeLevel gradeLevel3 = gradeLevels.get(2);
        Assert.assertEquals(GradeLevelCode._11.getValue(), gradeLevel3.getCode());

        GradeLevel gradeLevel4 = gradeLevels.get(3);
        Assert.assertEquals(GradeLevelCode._12.getValue(), gradeLevel4.getCode());

        AddressList addressList = leaInfo.getAddressList();
        Assert.assertEquals(1, addressList.size());

        Address address = addressList.get(0);
        Assert.assertEquals("Salt Lake City", address.getCity());
        Assert.assertEquals(StatePrCode.IL.getValue(), address.getStateProvince());
        Assert.assertEquals(CountryCode.US.getValue(), address.getCountry());
        Assert.assertEquals("84102", address.getPostalCode());
        Assert.assertEquals(AddressType.MAILING.getValue(), address.getType());

        Street street = address.getStreet();
        Assert.assertEquals("1 IBM Plaza", street.getLine1());
        Assert.assertEquals("2000", street.getApartmentNumber());
        Assert.assertEquals("Suite 2000", street.getLine2());
        Assert.assertEquals("Salt Lake City, IL 84102", street.getLine3());
        Assert.assertEquals("IBM way", street.getStreetName());
        Assert.assertEquals("1", street.getStreetNumber());
        Assert.assertEquals("Plaza", street.getStreetType());
        Assert.assertEquals("Suite", street.getApartmentType());

        PhoneNumberList phoneNumberList = leaInfo.getPhoneNumberList();
        Assert.assertEquals(2, phoneNumberList.size());

        PhoneNumber phoneNumber1 = phoneNumberList.get(0);
        Assert.assertEquals(PhoneNumberType.PRIMARY.getValue(), phoneNumber1.getType());
        Assert.assertEquals("(312) 555-1234", phoneNumber1.getNumber());

        PhoneNumber phoneNumber2 = phoneNumberList.get(1);
        Assert.assertEquals(PhoneNumberType.FAX.getValue(), phoneNumber2.getType());
        Assert.assertEquals("(312) 555-2364", phoneNumber2.getNumber());
    }

    @Test
    public void testGenerateTestSeaInfo() {
        SEAInfo seaInfo = SifEntityGenerator.generateTestSEAInfo();
        Assert.assertEquals(SifEntityGenerator.TEST_SEAINFO_REFID, seaInfo.getRefId());
        Assert.assertEquals("Illinois State Board of Education", seaInfo.getSEAName());
        Assert.assertEquals("http://IL.edu", seaInfo.getSEAURL());

        AddressList addressList = seaInfo.getAddressList();
        Assert.assertEquals(1, addressList.size());

        Address address = addressList.get(0);
        Assert.assertEquals("Salt Lake City", address.getCity());
        Assert.assertEquals(StatePrCode.IL.getValue(), address.getStateProvince());
        Assert.assertEquals(CountryCode.US.getValue(), address.getCountry());
        Assert.assertEquals("84102", address.getPostalCode());
        Assert.assertEquals(AddressType.MAILING.getValue(), address.getType());

        Street street = address.getStreet();
        Assert.assertEquals("1 IBM Plaza", street.getLine1());
        Assert.assertEquals("2000", street.getApartmentNumber());
        Assert.assertEquals("Suite 2000", street.getLine2());
        Assert.assertEquals("Salt Lake City, IL 84102", street.getLine3());
        Assert.assertEquals("IBM way", street.getStreetName());
        Assert.assertEquals("1", street.getStreetNumber());
        Assert.assertEquals("Plaza", street.getStreetType());
        Assert.assertEquals("Suite", street.getApartmentType());

        PhoneNumberList phoneNumberList = seaInfo.getPhoneNumberList();
        Assert.assertEquals(2, phoneNumberList.size());

        PhoneNumber phoneNumber1 = phoneNumberList.get(0);
        Assert.assertEquals(PhoneNumberType.PRIMARY.getValue(), phoneNumber1.getType());
        Assert.assertEquals("(312) 555-1234", phoneNumber1.getNumber());

        PhoneNumber phoneNumber2 = phoneNumberList.get(1);
        Assert.assertEquals(PhoneNumberType.FAX.getValue(), phoneNumber2.getType());
        Assert.assertEquals("(312) 555-2364", phoneNumber2.getNumber());
    }

    @Test
    public void testGenerateTestStudentSchoolEnrollment() {
        StudentSchoolEnrollment studentSchoolEnrollment = SifEntityGenerator.generateTestStudentSchoolEnrollment();
        Assert.assertEquals(SifEntityGenerator.TEST_STUDENTSCHOOLENROLLMENT_REFID, studentSchoolEnrollment.getRefId());
        Assert.assertEquals(SifEntityGenerator.TEST_SCHOOLINFO_REFID, studentSchoolEnrollment.getSchoolInfoRefId());
        Assert.assertEquals(SifEntityGenerator.TEST_STUDENTPERSONAL_REFID, studentSchoolEnrollment.getStudentPersonalRefId());
        Assert.assertEquals(MembershipType.HOME.getValue(), studentSchoolEnrollment.getMembershipType());
        Assert.assertEquals(TimeFrame.CURRENT.getValue(), studentSchoolEnrollment.getTimeFrame());
        Assert.assertEquals(2012, studentSchoolEnrollment.getSchoolYear().intValue());
        Assert.assertEquals(ExitTypeCode._3502_NOT_ENROLLED_ELIGIBLE_TO.getValue(), studentSchoolEnrollment.getExitType().getCode());
        Assert.assertEquals(EntryTypeCode._0619_1838.getValue(), studentSchoolEnrollment.getEntryType().getCode());
        Assert.assertEquals(GradeLevelCode._10.getValue(), studentSchoolEnrollment.getGradeLevel().getCode());
        Assert.assertEquals(new BigDecimal(1.00), studentSchoolEnrollment.getFTE());
        Assert.assertEquals(FTPTStatus.FULLTIME.getValue(), studentSchoolEnrollment.getFTPTStatus());
        Assert.assertEquals(PublicSchoolResidenceStatus._0598_1653.getValue(), studentSchoolEnrollment.getResidencyStatus().getCode());
        Assert.assertEquals(NonResidentAttendRationale.VOCATIONAL.getValue(), studentSchoolEnrollment.getNonResidentAttendReason());

        Calendar exitDate = studentSchoolEnrollment.getExitDate();
        Assert.assertEquals(2012, exitDate.get(Calendar.YEAR));
        Assert.assertEquals(9, exitDate.get(Calendar.MONTH));
        Assert.assertEquals(17, exitDate.get(Calendar.DATE));

        Calendar entryDate = studentSchoolEnrollment.getEntryDate();
        Assert.assertEquals(2012, entryDate.get(Calendar.YEAR));
        Assert.assertEquals(8, entryDate.get(Calendar.MONTH));
        Assert.assertEquals(16, entryDate.get(Calendar.DATE));
    }

    @Test
    public void testGenerateTestStudentLeaRelationship() {
        StudentLEARelationship studentLeaRelationship = SifEntityGenerator.generateTestStudentLeaRelationship();
        Assert.assertEquals(SifEntityGenerator.TEST_STUDENTLEARELATIONSHIP_REFID, studentLeaRelationship.getRefId());
        Assert.assertEquals(SifEntityGenerator.TEST_LEAINFO_REFID, studentLeaRelationship.getLEAInfoRefId());
        Assert.assertEquals(SifEntityGenerator.TEST_STUDENTPERSONAL_REFID, studentLeaRelationship.getStudentPersonalRefId());
        Assert.assertEquals(2012, studentLeaRelationship.getSchoolYear().intValue());
        Assert.assertEquals(MembershipType.HOME.getValue(), studentLeaRelationship.getMembershipType());
        Assert.assertEquals(EntryTypeCode._0619_1838.getValue(), studentLeaRelationship.getEntryType().getCode());
        Assert.assertEquals(GradeLevelCode._10.getValue(), studentLeaRelationship.getGradeLevel().getCode());

        OrganizationRelationshipType organizationRelationshipType = studentLeaRelationship.getLEARelationshipType();
        Assert.assertEquals(PublicSchoolResidenceStatus.RESIDENT.getValue(), organizationRelationshipType.getResidencyStatus().getCode());
        Assert.assertTrue(organizationRelationshipType.getProvidingInstruction().booleanValue());
        Assert.assertTrue(organizationRelationshipType.getProvidingServices().booleanValue());
        Assert.assertTrue(organizationRelationshipType.getFinanciallyResponsible().booleanValue());

        Calendar entryDate = studentLeaRelationship.getEntryDate();
        Assert.assertEquals(2012, entryDate.get(Calendar.YEAR));
        Assert.assertEquals(8, entryDate.get(Calendar.MONTH));
        Assert.assertEquals(16, entryDate.get(Calendar.DATE));
    }

    @Test
    public void testGenerateTestStudentPersonal() {
        StudentPersonal studentPersonal = SifEntityGenerator.generateTestStudentPersonal();
        Assert.assertEquals(SifEntityGenerator.TEST_STUDENTPERSONAL_REFID, studentPersonal.getRefId());
        Assert.assertEquals("1982", studentPersonal.getGraduationDate().getValue());
        Assert.assertEquals(YesNoUnknown.NO.getValue(), studentPersonal.getMigrant());

        Name name = studentPersonal.getName();
        Assert.assertEquals(NameType.NAME_OF_RECORD.getValue(), name.getType());
        Assert.assertEquals("Smith", name.getLastName());
        Assert.assertEquals("Joe", name.getFirstName());
        Assert.assertEquals("", name.getMiddleName());
        Assert.assertEquals("Joe", name.getPreferredName());

        EmailList emailList = studentPersonal.getEmailList();
        Assert.assertEquals(1, emailList.size());

        Email email = emailList.get(0);
        Assert.assertEquals(EmailType.PRIMARY.getValue(), email.getType());
        Assert.assertEquals("joe.student@anyschool.edu", email.getValue());

        Demographics demographics = studentPersonal.getDemographics();
        Assert.assertEquals(CitizenshipStatus.USCITIZEN.getValue(), demographics.getCitizenshipStatus());
        Assert.assertEquals(CountryCode.US.getValue(), demographics.getCountryOfBirth());
        Assert.assertEquals(StatePrCode.AK.getValue(), demographics.getStateOfBirth());

        Calendar birthDate = demographics.getBirthDate();
        Assert.assertEquals(1981, birthDate.get(Calendar.YEAR));
        Assert.assertEquals(11, birthDate.get(Calendar.MONTH));
        Assert.assertEquals(20, birthDate.get(Calendar.DATE));

        StudentAddressList addressList = studentPersonal.getAddressList();
        Assert.assertEquals(1, addressList.size());

        Address address = addressList.get(0);
        Assert.assertEquals("Salt Lake City", address.getCity());
        Assert.assertEquals(StatePrCode.IL.getValue(), address.getStateProvince());
        Assert.assertEquals(CountryCode.US.getValue(), address.getCountry());
        Assert.assertEquals("84102", address.getPostalCode());
        Assert.assertEquals(AddressType.MAILING.getValue(), address.getType());

        Street street = address.getStreet();
        Assert.assertEquals("1 IBM Plaza", street.getLine1());
        Assert.assertEquals("2000", street.getApartmentNumber());
        Assert.assertEquals("Suite 2000", street.getLine2());
        Assert.assertEquals("Salt Lake City, IL 84102", street.getLine3());
        Assert.assertEquals("IBM way", street.getStreetName());
        Assert.assertEquals("1", street.getStreetNumber());
        Assert.assertEquals("Plaza", street.getStreetType());
        Assert.assertEquals("Suite", street.getApartmentType());

        PhoneNumberList phoneNumberList = studentPersonal.getPhoneNumberList();
        Assert.assertEquals(1, phoneNumberList.size());

        PhoneNumber phoneNumber = phoneNumberList.get(0);
        Assert.assertEquals(PhoneNumberType.PRIMARY.getValue(), phoneNumber.getType());
        Assert.assertEquals("(312) 555-1234", phoneNumber.getNumber());
    }
}
