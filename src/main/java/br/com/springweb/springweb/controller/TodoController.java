package br.com.springweb.springweb.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.springweb.springweb.model.Todo;
import br.com.springweb.springweb.repository.TodoRepository;

@Controller
public class TodoController {

	@Autowired
	private TodoRepository todoRep;

	@RequestMapping(value = "/cadastrarTodo", method = RequestMethod.GET)
	public String form() {
		return "todo/formTodo";
	}

	@RequestMapping(value = "/cadastrarTodo", method = RequestMethod.POST)
	public String salvar(Todo evento) {
		todoRep.save(evento);
		return "redirect:/cadastrarTodo";
	}

	@RequestMapping(value = "todos", method = RequestMethod.GET)
	public ModelAndView listarTodos() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("todos", todoRep.findAll());
		return mv;
	}

	@RequestMapping("/deletar")
	public String deletarTodo(Long id) {
		Optional<Todo> optional = todoRep.findById(id);
		if (optional.isPresent()) {
			todoRep.delete(optional.get());
		}
		return "redirect:/todos";
	}

}
