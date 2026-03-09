package co.istad.pisoth.fswd_sbapp.controller;

import co.istad.pisoth.fswd_sbapp.dto.DataResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @GetMapping("/{id}/fullstack/{courseType}")
    public DataResponse getStudent(@PathVariable String id,
                                   @PathVariable("courseType") String ct,
                                   @RequestParam (required = false, defaultValue = "male") String gender){

        return new DataResponse(id, ct, gender);
    }
}