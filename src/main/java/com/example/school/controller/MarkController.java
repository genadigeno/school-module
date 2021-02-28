package com.example.school.controller;

import com.example.school.data.dictionary.DictionaryService;
import com.example.school.data.mark.MarkService;
import com.example.school.data.pupil.PupilService;
import com.example.school.model.Dictionary;
import com.example.school.model.Mark;
import com.example.school.model.Pupil;
import com.example.school.util.CommonUtil;
import com.example.school.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/mark")
public class MarkController {
    private final static Logger log = LoggerFactory.getLogger(MarkController.class);

    private MarkService markService;

    public MarkService getMarkService() {
        return markService;
    }

    @Autowired
    @Qualifier("markService")
    public void setMarkService(MarkService markService) {
        this.markService = markService;
    }

    private DictionaryService dictionaryService;

    public DictionaryService getDictionaryService() {
        return dictionaryService;
    }

    private PupilService pupilService;

    public PupilService getPupilService() {
        return pupilService;
    }

    @Autowired
    @Qualifier("pupilService")
    public void setPupilService(PupilService pupilService) {
        this.pupilService = pupilService;
    }

    @Autowired
    @Qualifier("dictionaryService")
    public void setDictionaryService(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }
    //------------------------------------------------------------------------------------------------------------//

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value = "/{pupilId}")
    public String save(@PathVariable Integer pupilId, @Valid Mark mark, BindingResult result, RedirectAttributes attrs){
        if (result.hasErrors()) {
            attrs.addFlashAttribute("errors", CommonUtil.collectErrors(result.getFieldErrors()));
            return "redirect:/details/"+pupilId;
        }

        Pupil pupil = pupilService.get(pupilId);
        mark.setPupil(pupil);
        System.out.println("Mark()       = " + mark.getAssignedMark());
        System.out.println("AssignDate() = " + mark.getAssignDate());
        System.out.println("Subject()    = " + mark.getSubject().getDictionaryKey());
        System.out.println("Pupil()      = " + mark.getPupil().getLastName());

        markService.save(mark);

        attrs.addFlashAttribute("errors", new ArrayList<String>());
        return "redirect:/details/"+pupilId;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value = "/edit/{id}")
    public String edit(@PathVariable Integer id, @Valid Mark mark, BindingResult result, RedirectAttributes attributes){
        if (result.hasErrors()) {
            attributes.addFlashAttribute("errors", CommonUtil.collectErrors(result.getFieldErrors()));
            return "redirect:/mark/edit/"+id;
        } else if (mark.getId() == null) {
            attributes.addFlashAttribute("errors", CommonUtil.collectErrors("Mark is required"));
            return "redirect:/mark/edit/"+id;
        }

        System.out.println("mark.getMark()       = " + mark.getAssignedMark());
        System.out.println("mark.getAssignDate() = " + mark.getAssignDate());
        System.out.println("mark.getPupil()      = " + mark.getPupil().getLastName());
        System.out.println("mark.getSubject()    = " + mark.getSubject().getDictionaryKey());

        markService.save(mark);

        attributes.addFlashAttribute("errors", new ArrayList<String>());
        return "redirect:/mark/edit/"+id;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/edit/{id}")
    public String marks(@PathVariable Integer id, Model model){
        Mark mark = markService.get(id);
        System.out.println("mark = " + mark);
        model.addAttribute("mark", mark);

        Dictionary parentDictionary = dictionaryService.dictionary(Constants.KEY_SUBJECT);
        if (parentDictionary == null) {
            log.error("parentDictionary is null");
        }
        List<Dictionary> subjects   = dictionaryService.getAllByParent(parentDictionary);

        model.addAttribute("subjects", subjects);
        return "mark-edit";
    }
}
