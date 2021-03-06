package logic;

import dataaccess.RealCustomerCRUD;
import dataaccess.bean.RealCustomer;
import logic.exception.DuplicateInformationException;
import logic.exception.FieldRequiredException;
import logic.exception.NationalCodeFormatException;

import java.util.List;

public class RealCustomerLogic {


    public static void validateCustomerInformation(RealCustomer realCustomer) throws FieldRequiredException, NationalCodeFormatException, DuplicateInformationException {

        if (realCustomer.getFirstName() == null || realCustomer.getFirstName().equals("")) {
            throw new FieldRequiredException("وارد کردن نام الزامی است.");
        }
        if (realCustomer.getLastName() == null || realCustomer.getLastName().equals("")) {
            throw new FieldRequiredException("وارد کردن نام خانوادگی الزامی است.");
        }
        if (realCustomer.getFatherName() == null || realCustomer.getFatherName().equals("")) {
            throw new FieldRequiredException("وارد کردن نام پدر الزامی است.");
        }
        if (realCustomer.getDateOfBirth() == null || realCustomer.getDateOfBirth().equals("")) {
            throw new FieldRequiredException("وارد کردن تاریخ تولد الزامی است.");
        }
        if (realCustomer.getNationalCode() == null || realCustomer.getNationalCode().equals("")) {
            throw new FieldRequiredException("وارد کردن کد ملی الزامی است.");
        } else {
            if (realCustomer.getNationalCode().trim().length() != 10) {
                throw new NationalCodeFormatException("کد ملی باید دقیقا ده رقم باشد");
            } else {
                String code = realCustomer.getNationalCode().trim();
                int sum = 0;
                for (int i = 10; i > 1; i--) {
                    sum += Integer.parseInt(code.substring(10 - i, 11 - i)) * i;
                }
                int rightMostNumber = Integer.parseInt(code.substring(9));
                int reminder = sum % 11;
                if (!(reminder == rightMostNumber) && !(reminder == 11 - rightMostNumber)) {
                    throw new NationalCodeFormatException("کد ملی وارد شده صحیح نیست");
                }

            }
        }
        List<RealCustomer> customerByNationalCode = RealCustomerCRUD.findByNationalCode(realCustomer.getNationalCode());
        if (customerByNationalCode.size() > 0) {
            for (RealCustomer realCustomer1 : customerByNationalCode) {
                if (realCustomer.getCustomerId() != realCustomer1.getCustomerId()) {
                    throw new DuplicateInformationException("کد ملی وارد شده تکراری می باشد");
                }
            }
        }
    }


//
//    public static void validateCustomerInformationForUpdate(RealCustomer realCustomer) throws FieldRequiredException, NationalCodeFormatException, DuplicateInformationException {
//
//        if (realCustomer.getFirstName() == null || realCustomer.getFirstName().equals("")) {
//            throw new FieldRequiredException("وارد کردن نام الزامی است.");
//        }
//        if (realCustomer.getLastName() == null || realCustomer.getLastName().equals("")) {
//            throw new FieldRequiredException("وارد کردن نام خانوادگی الزامی است.");
//        }
//        if (realCustomer.getFatherName() == null || realCustomer.getFatherName().equals("")) {
//            throw new FieldRequiredException("وارد کردن نام پدر الزامی است.");
//        }
//        if (realCustomer.getDateOfBirth() == null || realCustomer.getDateOfBirth().equals("")) {
//            throw new FieldRequiredException("وارد کردن تاریخ تولد الزامی است.");
//        }
//        if (realCustomer.getNationalCode() == null || realCustomer.getNationalCode().equals("")) {
//            throw new FieldRequiredException("وارد کردن کد ملی الزامی است.");
//        } else {
//            if (realCustomer.getNationalCode().trim().length() != 10) {
//                throw new NationalCodeFormatException("کد ملی باید دقیقا ده رقم باشد");
//            } else {
//                String code = realCustomer.getNationalCode().trim();
//                int sum = 0;
//                for (int i = 10; i > 1; i--) {
//                    sum += Integer.parseInt(code.substring(10 - i, 11 - i)) * i;
//                }
//                int rightMostNumber = Integer.parseInt(code.substring(9));
//                int reminder = sum % 11;
//                if (!(reminder == rightMostNumber) && !(reminder == 11 - rightMostNumber)) {
//                    throw new NationalCodeFormatException("کد ملی وارد شده صحیح نیست");
//                }
//
//            }
//        }
//        List<RealCustomer> customerByNationalCode = RealCustomerCRUD.findByNationalCode(realCustomer.getNationalCode());
//        if (customerByNationalCode.size() > 1) {
//            throw new DuplicateInformationException("کد ملی وارد شده تکراری می باشد");
//        }
//    }
}


