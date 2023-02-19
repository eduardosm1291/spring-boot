package com.pepelalo.initial.controllers;

import com.pepelalo.initial.models.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/demo")
public class DemoController {
    @GetMapping(value="/getting")
    public String getting() {
        return "getting";
    }

    @GetMapping(value="/user")
    public ModelAndView other(ModelAndView modelmv) {
        modelmv.addObject("titulo", "hola Spring Framewor Model and view");
        modelmv.setViewName("user");
        return modelmv;
    }
    @GetMapping(value="/customer")
    @ResponseBody
    public String customer() {
        return "prueba de customer";
    }
    @RequestMapping("/perfil")
    public String perfil (Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("pepe");
        usuario.setApellido("lalo");
        usuario.setEmail("sadfasd");
        model.addAttribute("usuario",usuario);
        model.addAttribute("titulo","titulo del perfil:".concat(usuario.getNombre()));
        return "perfil";
    }
}
