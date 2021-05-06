package com.example.ProjetS2;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.ProjetS2.DAO.FilierRepository;
import com.example.ProjetS2.DAO.MatierRepository;
import com.example.ProjetS2.DAO.RoleRepository;
import com.example.ProjetS2.DAO.SemestRepository;
import com.example.ProjetS2.DAO.UtilisateurRepository;
import com.example.ProjetS2.entities.Filiere;
import com.example.ProjetS2.entities.Matiere;
import com.example.ProjetS2.entities.Role;
import com.example.ProjetS2.entities.Semestre;
import com.example.ProjetS2.entities.Utilisateur;
import com.example.ProjetS2.model.Mail;
import com.example.ProjetS2.services.AccountService;

@SpringBootApplication

public class ProjetS2Application implements CommandLineRunner {
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private RoleRepository rolesRepository;

	@Autowired
	private AccountService accountService;
	@Autowired
	private FilierRepository filierrepository;
	@Autowired
	private SemestRepository semesterRepository;
	@Autowired
	private MatierRepository matierRepository;
	
	

	@Bean
	public BCryptPasswordEncoder getBcrypte(){
		return  new BCryptPasswordEncoder();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetS2Application.class, args);
	
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		 // lo.info("Spring Mail - Sending Simple Email with JavaMailSender Example");
		
	
/*
	        Mail mail = new Mail();
	        mail.setFrom("elhadjsidimv@gmail.com");
	        mail.setTo("cheikhbrahimiyahi@gmail.com");
	        mail.setSubject("Sending Simple Email with JavaMailSender Example");
	        mail.setContent("This tutorial demonstrates how to send a simple email using Spring Framework.");

	        emailService.sendSimpleMessage(mail);
		
	*/
		
		/*
		  Utilisateur utilisateur1=accountService.addUser(new
				  Utilisateur("scolar1","med","mv@gmail.com","Scolariter","1234"));
				  Role role1=rolesRepository.save(new Role(null,"SCOLARITER"));
				  accountService.AddRoles("Scolariter","SCOLARITER");
	
		
		  Filiere f1=filierrepository.save(new Filiere(null,"IG"));
		  Filiere f2=filierrepository.save(new Filiere(null,"ID"));
		  Semestre s1=semesterRepository.save(new Semestre(null,"s1"));
		  Semestre s2=semesterRepository.save(new Semestre(null,"s2"));
		  Semestre s3=semesterRepository.save(new Semestre(null,"s3"));
		  Semestre s4=semesterRepository.save(new Semestre(null,"s4"));
		  Semestre s5=semesterRepository.save(new Semestre(null,"s5"));
		  Semestre s6=semesterRepository.save(new Semestre(null,"s6"));

		  Utilisateur utilisateur=accountService.addUser(new
				  Utilisateur("IE17629","Cheikh","Cheikhbrahimiyahi@gmail.com","Cheikh","IE17629",f1));
				  Role role=rolesRepository.save(new Role(null,"ETUDIANT"));
				  accountService.AddRoles("Cheikh","ETUDIANT");
		
				  Utilisateur utilisateur2=accountService.addUser(new
						  Utilisateur("IP18116","Aichana","aichanasid@gmail.com","Aichana","IP18116",f2));
					
						  accountService.AddRoles("Aichana","ETUDIANT");
	      Matiere m1=matierRepository.save(new Matiere("mat1", "algo", s1,f1));
	      Matiere m2=matierRepository.save(new Matiere("mat2", "javaSE", s1,f1));
	      Matiere m3=matierRepository.save(new Matiere("mat3", "python", s2,f1));
	      Matiere m4=matierRepository.save(new Matiere("mat4", "php", s2,f1));
	      Matiere m5=matierRepository.save(new Matiere("mat5", "javaJEE", s3,f1));
	      Matiere m6=matierRepository.save(new Matiere("mat6", "reseaux", s3,f1));
	      Matiere m7=matierRepository.save(new Matiere("mat7", "FR", s4,f1));
	      Matiere m8=matierRepository.save(new Matiere("mat8", "EN", s4,f1));
	      Matiere m9=matierRepository.save(new Matiere("mat9", "gestion", s5,f1));
	      Matiere m10=matierRepository.save(new Matiere("mat10", "c", s5,f1));
	      Matiere m11=matierRepository.save(new Matiere("mat11", "c#", s6,f1));
	      Matiere m12=matierRepository.save(new Matiere("mat12", "bigData", s6,f1));
	      List<Matiere> matieres=new ArrayList<Matiere>();
	      if(f1.getMatiere()==null) {
	      	matieres.add(m1);
	      	matieres.add(m2);
	      	matieres.add(m3);
	      	matieres.add(m4);
	      	matieres.add(m5);
	      	matieres.add(m6);
	      	matieres.add(m7);
	      	matieres.add(m8);
	      	matieres.add(m9);
	      	matieres.add(m10);
	      	matieres.add(m11);
	      	matieres.add(m12);

	    	  
		  f1.setMatiere(matieres);
		  filierrepository.save(f1);
		  
		  }
	      
	      
	      Matiere m13=matierRepository.save(new Matiere("mat13", "algo", s1,f2));
	      Matiere m14=matierRepository.save(new Matiere("mat14", "GL", s1,f2));
	      Matiere m15=matierRepository.save(new Matiere("mat35", "Gestion", s2,f2));
	      Matiere m16=matierRepository.save(new Matiere("mat45", "comptabiliter", s2,f2));
	      Matiere m17=matierRepository.save(new Matiere("mat57", "RO", s3,f2));
	      Matiere m18=matierRepository.save(new Matiere("mat68", "JAVA Framework", s3,f2));
	      Matiere m19=matierRepository.save(new Matiere("mat79", "FR", s4,f2));
	      Matiere m81=matierRepository.save(new Matiere("mat89", "Projet", s4,f2));
	      Matiere m92=matierRepository.save(new Matiere("mat99", "entreprenariia", s5,f2));
	      Matiere m33=matierRepository.save(new Matiere("mat109", "c", s5,f2));
	      Matiere m44=matierRepository.save(new Matiere("mat119", "c#", s6,f2));
	      Matiere m52=matierRepository.save(new Matiere("mat129", "bigData", s6,f2));
	      List<Matiere> matieres3=new ArrayList<Matiere>();
	      if(f2.getMatiere()==null) {
	      	matieres3.add(m13);
	      	matieres3.add(m14);
	      	matieres3.add(m15);
	      	matieres3.add(m16);
	      	matieres3.add(m17);
	      	matieres3.add(m18);
	      	matieres3.add(m19);
	      	matieres3.add(m81);
	      	matieres3.add(m92);
	      	matieres3.add(m33);
	      	matieres3.add(m44);
	      	matieres3.add(m52);

	    	  
		  f2.setMatiere(matieres3);
		  filierrepository.save(f2);
		  
		  }


		*/

	}


}
