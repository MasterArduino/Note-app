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


    // Отображение списка заметок
    @GetMapping("/")
    public String list(Model model) {
        // Получаем список всех заметок из репозитория
        List<Note> notes = noteRepository.findAll();

        // Передаем список заметок в модель, чтобы их можно было отобразить на странице
        model.addAttribute("notes", notes);
        return "notes/list";
    }

    // Отображение формы создания заметки
    @GetMapping("/create")
    public String createForm(Model model) {
        // Создаем новый объект Note и добавляем его в модель для связывания с формой
        model.addAttribute("note", new Note());
        return "notes/create";
    }

    // Обработка создания заметки
    @PostMapping("/create")
    public String create(@ModelAttribute Note note) {
        if (note.getText() != null && !note.getText().isEmpty()) {
            noteRepository.save(note);
            System.out.println("Note saved: " + note.getId());
        }
        return "redirect:/notes/";
    }


    // Отображение формы редактирования заметки
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        // Ищем заметку по идентификатору и добавляем ее в модель для передачи на страницу редактирования
        Note note = noteRepository.findById(id).orElse(null);
        model.addAttribute("note", note);

        // Возвращаем шаблон страницы редактирования заметки
        return "notes/edit";
    }

    // Обработка редактирования заметки
    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @ModelAttribute Note updatedNote) {
        // Ищем заметку по идентификатору
        Note note = noteRepository.findById(id).orElse(null);

        if (note != null) {
            // Обновляем текст заметки
            note.setText(updatedNote.getText());

            // Сохраняем обновленную заметку
            noteRepository.save(note);
        }

        // Перенаправляем пользователя на список заметок после успешного редактирования
        return "redirect:/notes/";
    }
    // Отображение формы удаления заметки
    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable Long id, Model model) {
        // Ищем заметку по идентификатору
        Note note = noteRepository.findById(id).orElse(null);

        if (note != null) {
            // Если заметка найдена, добавляем ее в модель для отображения на странице удаления
            model.addAttribute("note", note);

            // Возвращаем шаблон страницы удаления заметки
            return "notes/delete";
        } else {
            // Если заметка не найдена, перенаправляем на список заметок
            return "redirect:/notes/";
        }
    }

    // Обработка удаления заметки
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        // Удаляем заметку по идентификатору
        noteRepository.deleteById(id);

        // Перенаправляем пользователя на список заметок после успешного удаления
        return "redirect:/notes/";
    }
}