package cz.czechitas.java2webapps.ukol3.controller;

import cz.czechitas.java2webapps.ukol3.entity.Vizitka;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller

public class VizitkaController {
  private final List<Vizitka> vizitky;


  public VizitkaController() {
    vizitky = List.of(
            new Vizitka("Barbora Bühnová", "Czechitas z. s.","Václavské náměstí 837/11", "11000" ,  null,"+420 800123456", "www.czechitas.cz" ),
            new Vizitka("Mirka Zatloukalová", "Czechitas z. s.","Václavské náměstí 837/11", "11000" , "mirka@czechitas.cs",null, "www.czechitas.cz" ),
            new Vizitka("Monika Ptáčníková", "Czechitas z. s.","Evropská 677/150", "16000" ,  "monika@czechitas.cs","+420 800123456", "www.czechitas.cz" ),
            new Vizitka("Dita (Přikrylová) Formánková", "Czechitas z. s.","Václavské náměstí 837/11", "11000" , "dita@czechitas.cs","+420 800123456", "www.czechitas.cz" )
    );
  }

  @GetMapping("/")
  public ModelAndView vizitky() {
    ModelAndView modelAndView = new ModelAndView("seznam");
    modelAndView.addObject("vizitky",vizitky);
    return modelAndView;
  }

  @GetMapping(path = "/detail", params = "id")
  public ModelAndView detail(int id) {
      ModelAndView modelAndView = new ModelAndView("detail");
      modelAndView.addObject("vizitka", vizitky.get(id));
      return modelAndView;
    }




  }
