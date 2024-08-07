package com.kafka.kafkaex.controller;

import com.kafka.kafkaex.service.kafkapubl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/kafka")
public class controller {
    @Autowired
    kafkapubl kafkapubl;

    @GetMapping("/prod/{msg}")
    public ResponseEntity<?>sendingMsg(@PathVariable String[] msg){

        kafkapubl.message(Arrays.toString(msg));
        return ResponseEntity.ok(msg);

    }
}
