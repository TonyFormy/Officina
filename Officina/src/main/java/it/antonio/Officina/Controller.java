package it.antonio.Officina;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;








@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	private AutoRepository autoRepository; 
	@Autowired
	private GuastoRepository guastoRepository;
	@Autowired
	private PossiedeRepository possiedeRepository;
	public Controller() {
		// TODO Auto-generated constructor stub
		
	}
	
	
	@GetMapping("/index")
	public String visualizza(Model model) {
		return "index";
	}
	
	@GetMapping("/listaGuasti")
	public String visualizza3(Model model) {
		List<Guasto> guasti =  guastoRepository.findAll(); 
		model.addAttribute("guasti",guasti);
		return "listaGuasti";
	}

	@GetMapping("/listaAuto")
	public String visualizza1(Model model) {
		List<Guasto> guasti =  guastoRepository.findAll(); 
		model.addAttribute("guasti",guasti);
		List<Auto> auto =  autoRepository.findAll(); 
		model.addAttribute("auto",auto);
		return "listaAuto";
		
	}
	@GetMapping("/listaAutoGuaste")
	public String visualizzaG(Model model ) 
	{
		List<Possiede> possiedi =  possiedeRepository.findAll(); 
		model.addAttribute("possiedi",possiedi);
		return "listaAutoGuaste";
	}	
	
	@PostMapping("/eliminaAuto")
	public String cancella(@ModelAttribute Auto auto,Model model) 
	{
		autoRepository.deleteById(auto.getIdAuto());
		
		return visualizza1(model);
	}
	
	@PostMapping("/eliminaGuasto")
	public String cancella1(@ModelAttribute Guasto guasto,Model model) 
	{
		guastoRepository.deleteById(guasto.getIdGuasto());
		return visualizza3(model);
	}
	
	@PostMapping("/aggAuto")
	
	public String aggiungi(@ModelAttribute Auto auto,String targa,Model model ) 
	{
		boolean trovato=true;
		if(autoRepository.findByTarga(targa).isEmpty())
		{
			trovato=false;
			autoRepository.save(auto);
		}
		model.addAttribute("trovato",trovato);
		return visualizza1(model);
	}
	
	@PostMapping("/aggGuasto")
	
	public String aggiungi1(@ModelAttribute Guasto guasto,Model model ) 
	{
		guastoRepository.save(guasto);
		return visualizza3(model);
	}	

	@PostMapping("/aggGuastoAuto")
	public String aggiungiG(@ModelAttribute Auto auto,Guasto guasto,int costo,Model model ) 
	{
	
	Possiede possiede= new Possiede();
	Auto a=autoRepository.findById(auto.getIdAuto()).get();
	possiede.setAuto(a);
	Guasto g=guastoRepository.findById(guasto.getIdGuasto()).get();
	possiede.setGuasto(g);
	possiede.setScelta(false);
	possiede.setCosto(costo);
	possiedeRepository.save(possiede);
	boolean aggiunta=true;
	model.addAttribute("aggiunta",aggiunta);
	return visualizza1(model);
	}	

	@PostMapping("/riparaAutoG")
	public String visualizzaGA(@ModelAttribute Possiede possiede,Model model) 
	{
		
		possiede.setScelta(true);
		possiedeRepository.save(possiede);
		return visualizzaG(model);
	}
	@PostMapping("/ricerca")
	public String ricerca(Model model,String ricerca) {
		
		List<Auto> auto =null;
		if(!autoRepository.findByTarga(ricerca).isEmpty())
		{
			auto =  autoRepository.findByTarga(ricerca); 
		}
		else if(!autoRepository.findByMarca(ricerca).isEmpty())
		{
			auto = autoRepository.findByMarca(ricerca);
		}
		else if(!autoRepository.findByModello(ricerca).isEmpty())
		{
			auto = autoRepository.findByModello(ricerca);
			
		}
		model.addAttribute("auto",auto);
		
		return "listaAuto";
	}
		
}

