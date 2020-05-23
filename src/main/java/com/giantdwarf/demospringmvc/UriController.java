package com.giantdwarf.demospringmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class UriController {
    public static void main(String[] args) {

        URI uri = UriComponentsBuilder
                .fromUriString("https://example.com/hotels/{hotel}")
                .queryParam("q", "{q}")
                .build("yang","123");

        String url = "https://example.com";
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(url);
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.TEMPLATE_AND_VALUES);
;

        URI uri1 = factory.uriString("hotels/{hotel}")
                .queryParam("q", "{q}")
                .build("yang", "123");


    }


}
