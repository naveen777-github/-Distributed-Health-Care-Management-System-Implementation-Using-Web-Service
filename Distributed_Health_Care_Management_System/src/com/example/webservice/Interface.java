
package com.example.webservice;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style=Style.RPC)
public interface Interface{
    @WebMethod
    void addAppointment(String appointment_Id, String appointment_type, int capacity);
    @WebMethod
    void removeAppointment(String appointment_Id,  String appointment_type);
    @WebMethod
    String listAppointmentAvailability(String appointment_type);
    @WebMethod
    String bookAppointment(String patient_Id, String appointment_Id, String appointment_type);
    @WebMethod
    String cancelAppointment(String patient_Id, String appointment_Id);
    @WebMethod
    String getAppointmentSchedule(String patient_Id);
    @WebMethod
    String swapAppointment(String patientID, String oldAppointmentID, String oldAppointmentType, String newAppointmentID, String newAppointmentType);
}
