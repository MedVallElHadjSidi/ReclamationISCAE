package com.example.ProjetS2.web;

import com.example.ProjetS2.DAO.ReclamRepository;
import com.example.ProjetS2.DAO.RecldevRepository;
import com.example.ProjetS2.DAO.SemestRepository;
import com.example.ProjetS2.DAO.UtilisateurRepository;
import com.example.ProjetS2.entities.Matiere;
import com.example.ProjetS2.entities.ReclamarionDevoir;
import com.example.ProjetS2.entities.Reclamation;
import com.example.ProjetS2.entities.Role;
import com.example.ProjetS2.entities.Semestre;
import com.example.ProjetS2.entities.Utilisateur;
import com.example.ProjetS2.model.ModelReclamation;
import com.example.ProjetS2.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class webService {
    @Autowired
    private AccountService accountService;
    @Autowired
    private SemestRepository semestRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private RecldevRepository reclamRepository;
    
    @Autowired
    private ReclamRepository reclamy;
    
    
    
    
    
    @RequestMapping(value = "/consulter",method = RequestMethod.GET)
	public String ChercherByIdEmployer(Model model,@RequestParam(name = "id") String id){
		Reclamation reclamation=reclamy.findById(Long.parseLong(id)).get();
		reclamation.setInteraction(true);
		reclamy.save(reclamation);
		model.addAttribute("redv",reclamation);


		return "consulter";
	}

    @GetMapping("/")
  public  String index(Model model,   @AuthenticationPrincipal UserDetails currentUser){
        Utilisateur user=utilisateurRepository.findByUsername(currentUser.getUsername());
        System.out.println(user.getNom());
        
        for(Role r:user.getRoles()){
        	if(r.getRoleName().equals("ETUDIANT")){

                List<Semestre> semestreList = semestRepository.findAll();
                model.addAttribute("semestres",semestreList);
        		return "reclamation";
        		
        	}
        	else if(r.getRoleName().equals("SCOLARITER")){
        		return  "redirect:/nouveauxDemande";
        		
        	}
        	
        }






        return "reclamation";
  }
    
    
    
    @GetMapping(value = "/nouveauxDemande")
	public String NouveauxReclamtion(Model model,@RequestParam(name = "page",defaultValue = "0") int page){
		Page<Reclamation>reclamtions=reclamy.NouveauxReclamation(PageRequest.of(page,5));
		model.addAttribute("reclamations",reclamtions.getContent());
		model.addAttribute("pages",new int[reclamtions.getTotalPages()]);
		model.addAttribute("pageactuel",page);

		return "NouveauxReclamations";
	}
    
    
    @GetMapping(value = "/liste")
	public String ListeReclamtionDv(Model model,@RequestParam(name = "page",defaultValue = "0") int page){
		Page<ReclamarionDevoir>reclamtions=reclamRepository.Historiques(PageRequest.of(page,7));
		model.addAttribute("reclamations",reclamtions.getContent());
		model.addAttribute("pages",new int[reclamtions.getTotalPages()]);
		model.addAttribute("pageactuel",page);

		return "listeReclamations";
	}
    
    @GetMapping(value = "/listesc")
  	public String ListeReclamationsc(Model model,@RequestParam(name = "page",defaultValue = "0") int page){
  		Page<Reclamation>reclamtions=reclamy.Historiques(PageRequest.of(page,7));
  		model.addAttribute("reclamations2",reclamtions.getContent());
  		model.addAttribute("pages2",new int[reclamtions.getTotalPages()]);
  		model.addAttribute("pageactuel2",page);

  		return "listeReclamationsc";
  	}
    
    
    
    @PostMapping("/chercherReclamation")
    public  String chercherReclamation(Model model,@RequestParam String matricule,
                               
                                             @RequestParam  String matiere,
                                             @RequestParam  String semestre,
                                             @RequestParam(name = "page",defaultValue = "0") int page
                                
                                          ){
    	
    	
    	Page<Reclamation>reclamtions=reclamy.ChercherHistoriques(matricule, matiere, semestre, PageRequest.of(page,5));
  		model.addAttribute("reclamationsr",reclamtions.getContent());
  		model.addAttribute("pages2",new int[reclamtions.getTotalPages()]);
  		model.addAttribute("pageactuel2",page);
    	
    	
    	
    	return "redirect:/nouveauxDemande";
    	
    }


    
    
    
    
    
    @PostMapping("/reclamtions")
    public  String EnvoyerReclamations(@RequestParam String semestre,
                                             @RequestParam  String type,
                                             @RequestParam  String matiere,
                                             @RequestParam  String description,
                                             @RequestParam  String note,
                                        
                                      @AuthenticationPrincipal UserDetails currentUser
                                          ){
        Utilisateur utilisateur=utilisateurRepository.findByUsername(currentUser.getUsername());
        Semestre semestre1=semestRepository.findByNomSemester(semestre);
  
        double notes=Double.parseDouble(note);
      
        reclamy.save(new Reclamation(matiere, notes, description, type,semestre, utilisateur));
        
       System.out.println(semestre +""+matiere);

        return "redirect:/";
    }


    @PostMapping("/envoyer")
    public  String EnvoyerReclamation(@RequestParam String semestre2,
                                             @RequestParam  String type,
                                             @RequestParam  String matiere,
                                             @RequestParam  String description,
                                             @RequestParam  String notAffiché,
                                             @RequestParam  String notereel,
                                      @AuthenticationPrincipal UserDetails currentUser
                                          ){
        Utilisateur utilisateur=utilisateurRepository.findByUsername(currentUser.getUsername());
        Semestre semestre1=semestRepository.findByNomSemester(semestre2);
        double noteaff=Double.parseDouble(notAffiché);
        double note=Double.parseDouble(notereel);
       reclamRepository.save(new ReclamarionDevoir(matiere, noteaff, description, type, semestre2, utilisateur, note));
        
        System.out.println(semestre2 +""+matiere);

        return "redirect:/";
    }
  @PostMapping("/commencer")
  public  String Reclemation(Model model, @RequestParam(name = "semestre")String semestre,@RequestParam String type,@AuthenticationPrincipal UserDetails currentUser){
      Utilisateur user=utilisateurRepository.findByUsername(currentUser.getUsername());
      System.out.println(user.getUsername());
      List<Matiere>matieres=new ArrayList<>();
      List<String>semestres=new ArrayList<>();
      List<String>types=new ArrayList<>();

      Semestre semestre1=semestRepository.findByNomSemester(semestre);
      semestres.add(semestre1.getNomSemester());
      types.add(type);
      if (semestre1!=null&&user!=null){
          matieres=accountService.MatierReclamtion(user.getFiliere().getIdFiliere(),semestre1.getIdSemester());
      }



            model.addAttribute("semestres",semestres);
            model.addAttribute("type",type);
            model.addAttribute("types",types);
            model.addAttribute("matiers",matieres);

      return "formDevoir";
  }



}
