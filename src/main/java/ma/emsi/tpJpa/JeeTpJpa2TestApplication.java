package ma.emsi.tpJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import ma.emsi.tpJpa.entities.Patient;
import ma.emsi.tpJpa.repository.PatientRepository;
import java.util.*;
@SpringBootApplication
public class JeeTpJpa2TestApplication implements CommandLineRunner{
	@Autowired
	private PatientRepository patientRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JeeTpJpa2TestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		patientRepository.save(new Patient(null, "ismail", new Date(), 20, false));
		patientRepository.save(new Patient(null, "aguero", new Date(), 280, false));
		patientRepository.save(new Patient(null, "yassin", new Date(), 86, true));
		patientRepository.save(new Patient(null, "mouad", new Date(), 76, true));
	
		patientRepository.findAll().forEach(p->{
			System.out.println(p.toString());
		});
		
		System.out.println("--------------------");
		//Patient patient = patientRepository.findById(3L).get();
		//System.out.println(patient.toString());
		
		System.out.println("---------------------");
		List<Patient> patients = patientRepository.findByNomContains("ism");
		patients.forEach(p->{
			System.out.println(p.toString() );
		});
		
		System.out.println("-------------------");
		patientRepository.findByMalade(false).forEach(p->{
			System.out.println(p.toString());
		});
		
		System.out.println("-------------------");
		patientRepository.findByNomContainsAndMalade("aguer", false).forEach(p->{
			System.out.println(p.toString());
		});
	
		System.out.println("---------------------");
	
		patientRepository.findAll().forEach(p->{
			System.out.println(p.toString());
		});
		
		System.out.println("---------k------------");
		Page<Patient> page = patientRepository.findAll(PageRequest.of(1, 5));
		List<Patient> list = page.getContent();
		list.forEach(p->{
			System.out.println(p.toString());
		});
		
		
	}

}
