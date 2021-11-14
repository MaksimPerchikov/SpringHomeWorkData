package ru.ibs.hwdata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ibs.hwdata.repo.GearRepository;

@RestController
@RequestMapping("/api/gear")
public class GearController {

    @Autowired
    GearRepository gearRepository;
}
