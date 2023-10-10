package com.example.simplenoteapp.contloller;

import com.example.simplenoteapp.domain.Note;
import com.example.simplenoteapp.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    private NoteRepository noteRepository;

    @GetMapping("/")
    public String list(Model model) {
        List<Note> notes = noteRepository.findAll();
        model.addAttribute("notes", notes);
        return "notes/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("note", new Note());
        return "notes/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Note note) {
        noteRepository.save(note);
        return "redirect:/notes/";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Note note = noteRepository.findById(id).orElse(null);
        model.addAttribute("note", note);
        return "notes/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @ModelAttribute Note updatedNote) {
        Note note = noteRepository.findById(id).orElse(null);
        if (note != null) {
            note.setText(updatedNote.getText());
            noteRepository.save(note);
        }
        return "redirect:/notes/";
    }





    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable Long id, Model model) {
        Note note = noteRepository.findById(id).orElse(null);
        if (note != null) {
            model.addAttribute("note", note);
            return "notes/delete";
        } else {
            // Обработка случая, если заметка не найдена
            return "redirect:/notes/";
        }
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        noteRepository.deleteById(id);
        return "redirect:/notes/";
    }
}
