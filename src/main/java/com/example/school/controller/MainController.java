package com.example.school.controller;

import com.example.school.data.classRoom.ClassService;
import com.example.school.data.dictionary.DictionaryService;
import com.example.school.data.mark.MarkService;
import com.example.school.data.pupil.PupilService;
import com.example.school.data.school.SchoolService;
import com.example.school.model.*;
import com.example.school.util.CommonUtil;
import com.example.school.util.Constants;
import com.example.school.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.security.RolesAllowed;
import javax.validation.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    private final static Logger log = LoggerFactory.getLogger(MainController.class);

    private PupilService pupilService;

    public PupilService getPupilService() { return pupilService; }

    @Autowired
    @Qualifier("pupilService")
    public void setPupilService(PupilService pupilService) { this.pupilService = pupilService; }

    private DictionaryService dictionaryService;

    public DictionaryService getDictionaryService() {
        return dictionaryService;
    }

    @Autowired
    @Qualifier("dictionaryService")
    public void setDictionaryService(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    private ClassService classService;

    public ClassService getClassService() {
        return classService;
    }

    @Autowired
    @Qualifier("classService")
    public void setClassService(ClassService classService) {
        this.classService = classService;
    }

    private SchoolService schoolService;

    public SchoolService getSchoolService() {
        return schoolService;
    }

    @Autowired
    @Qualifier("schoolService")
    public void setSchoolService(SchoolService schoolService) {
        this.schoolService = schoolService;
    }
    //--------------------------------------------------------------------------------------------------------------//

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @GetMapping(value = "/")
    public String index(Model model, @RequestParam(defaultValue = "0") Integer page,
                                     @RequestParam(defaultValue = "5") Integer size) {
        List<Pupil> pupils = pupilService.getPupils(page, size);
        if (pupils == null) throw new DataNotFoundException();
        model.addAttribute("pupils", pupils);
        return "index";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/permission-denied")
    public String permissionDenied() {
        return "permission-denied";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Pupil pupil = pupilService.get(id);
        System.out.println("pupil = " + pupil);

        Dictionary parentDictionary = dictionaryService.dictionary(Constants.KEY_GENDER);
        List<Dictionary> genders = dictionaryService.getAllByParent(parentDictionary);
        List<ClassRoom> classRooms = classService.getAll();
        List<School> schools = schoolService.getAll();

        model.addAttribute("pupil", pupil);
        model.addAttribute("genders", genders);
        model.addAttribute("classes", classRooms);
        model.addAttribute("schools", schools);

        return "edit";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @GetMapping(value = "/details/{id}")
    public String details(@PathVariable Integer id, Model model) {
        Pupil pupil = pupilService.get(id);
        System.out.println("pupil = " + pupil);
        Dictionary parentDictionary = dictionaryService.dictionary(Constants.KEY_SUBJECT);
        List<Dictionary> subjects = dictionaryService.getAllByParent(parentDictionary);
        model.addAttribute("pupil", pupil);
        model.addAttribute("subjects", subjects);
        return "details";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value = "/update/{id}")
    public String edit(@PathVariable Integer id, @Valid Pupil pupil, BindingResult result, RedirectAttributes attrs) {

        if (result.hasErrors()){
            attrs.addFlashAttribute("errors", CommonUtil.collectErrors(result.getFieldErrors()));
            return "redirect:/edit/"+id;
        } else if (pupil.getId() == null) {
            attrs.addFlashAttribute("errors", CommonUtil.collectErrors("Pupil is required"));
            return "redirect:/edit/"+id;
        }/* else if (pupil.getBirthDate().after(DateUtil.localDateToDate(LocalDate.now().minusYears(5))) ||
                   pupil.getBirthDate().before(DateUtil.localDateToDate(LocalDate.now().minusYears(18)))){
            attrs.addFlashAttribute("errors", CommonUtil.collectErrors("Pupil's age must be between in 6 and 18"));
            return "redirect:/edit/"+id;
        }*/

        System.out.println("PersonalNumber: " + pupil.getPersonalNumber());
        System.out.println("FirstName:      " + pupil.getFirstName());
        System.out.println("LastName:       " + pupil.getLastName());
        System.out.println("Email:          " + pupil.getEmail());
        System.out.println("BirthDate:      " + pupil.getBirthDate());
        System.out.println("Gender:         " + pupil.getGender().getDictionaryKey());
        System.out.println("Class:          " + pupil.getClassRoom().getClassNumber());
        System.out.println("School:         " + pupil.getClassRoom().getSchool().getSchoolName());

        pupilService.save(pupil);

        attrs.addFlashAttribute("errors", new ArrayList<String>());
        return "redirect:/edit/"+id;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/add")
    public String add(Model model) {

        Dictionary parentDictionary = dictionaryService.dictionary(Constants.KEY_GENDER);
        List<Dictionary> genders = dictionaryService.getAllByParent(parentDictionary);
        List<ClassRoom> classRooms = classService.getAll();
        List<School> schools = schoolService.getAll();

        model.addAttribute("genders", genders);
        model.addAttribute("classes", classRooms);
        model.addAttribute("schools", schools);
        model.addAttribute("pupil", new Pupil());
        return "add";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value = "/add")
    public String addPupil(RedirectAttributes attrs, @Valid Pupil pupil, BindingResult result) {
        if (result.hasErrors()){
            attrs.addFlashAttribute("errors", CommonUtil.collectErrors(result.getFieldErrors()));
            return "redirect:/add";
        }
        System.out.println("pupil = " + pupil.getLastName());
        System.out.println("pupil = " + pupil.getFirstName());
        System.out.println("pupil = " + pupil.getEmail());
        System.out.println("pupil = " + pupil.getPersonalNumber());
        System.out.println("pupil = " + pupil.getBirthDate());
        System.out.println("pupil = " + pupil.getClassRoom());
        System.out.println("pupil = " + pupil.getGender());

        pupilService.save(pupil);

        return "redirect:/";
    }
}
