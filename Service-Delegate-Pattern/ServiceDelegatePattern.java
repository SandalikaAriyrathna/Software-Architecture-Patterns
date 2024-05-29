class ServiceDelegatePattern {

    // IService Interface
    interface IService {
        // Common service methods can be declared here
    }

    // IHospitalService Interface
    interface IHospitalService extends IService {
        void getHospitalDetails();
    }

    // HospitalServiceImpl Class
    static class HospitalServiceImpl implements IHospitalService {
        @Override
        public void getHospitalDetails() {
            System.out.println("Hospital details retrieved.");
        }
    }

    // IDoctorService Interface
    interface IDoctorService extends IService {
        void getDoctorDetails();
    }

    // DoctorServiceImpl Class
    static class DoctorServiceImpl implements IDoctorService {
        @Override
        public void getDoctorDetails() {
            System.out.println("Doctor details retrieved.");
        }
    }

    // IPaymentService Interface
    interface IPaymentService extends IService {
        void processPayment();
    }

    // PaymentServiceImpl Class
    static class PaymentServiceImpl implements IPaymentService {
        @Override
        public void processPayment() {
            System.out.println("Payment processed.");
        }
    }

    // ServiceDelegator Class
    static class ServiceDelegator {
        public static IService getService(String type) {
            if (type.equals("hospital")) {
                return new HospitalServiceImpl();
            } else if (type.equals("doctor")) {
                return new DoctorServiceImpl();
            } else {
                return new PaymentServiceImpl();
            }
        }
    }

    // HospitalController Class
    static class HospitalController {
        public void processRequest() {
            IHospitalService hospitalService = (IHospitalService) ServiceDelegator.getService("hospital");
            hospitalService.getHospitalDetails();
        }

        public static void main(String[] args) {
            HospitalController controller = new HospitalController();
            controller.processRequest();
        }
    }
}
