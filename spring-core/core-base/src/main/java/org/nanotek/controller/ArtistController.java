package org.nanotek.controller;

import org.nanotek.beans.ArtistCredit;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    @RequestMapping("/load")
    public ArtistCredit greeting(@RequestParam(value="count", defaultValue="1") Long count) {
        return new ArtistCredit();
    }
}