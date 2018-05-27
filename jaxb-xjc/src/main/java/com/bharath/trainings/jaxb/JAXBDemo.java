package com.bharath.trainings.jaxb;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.bharatthippireddy.patient.Patient;

public class JAXBDemo {

	public static void main(String[] args) {

		try {
			// Create Patient object with minimal values
			Patient patient = new Patient();
			patient.setId(123);
			patient.setName("Bharath");

			// Create marshaller anad StringWriter (to hold completed XML)
			JAXBContext context = JAXBContext.newInstance(Patient.class);
			Marshaller marshaller = context.createMarshaller();
			StringWriter writer = new StringWriter();
			marshaller.marshal(patient, writer);

			// System test, did it work?
			System.out.println(writer.toString());

			// Create Unmarshaller, and create a new patient object from the previous XML string
			Unmarshaller unMarshaller = context.createUnmarshaller();
			Patient patientResult = (Patient) unMarshaller.unmarshal(new StringReader(writer.toString()));
			
			// System test, did it work?
			System.out.print(patientResult.getName());
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
