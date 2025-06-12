package com.dnslb.dnsloadblancer.RRDNS;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xbill.DNS.Record;
import org.xbill.DNS.TextParseException;

@RestController
@RequestMapping("/dns")
public class RRDNSController {

    private final RRDNSservice rrdnsService;

    public RRDNSController(RRDNSservice rrdnsService) {
        this.rrdnsService = rrdnsService;
    }
    /**
     * Endpoint to resolve IP addresses for a given domain.
     * 
     * @param domain The domain name to resolve.
     * @return A string containing the resolved IP addresses.
     */
    @GetMapping("/resolve")
    public ResponseEntity<Object> resolvearecord(@RequestParam String domain) throws TextParseException{
        Record[] records = rrdnsService.resolveIpsWithTtl(domain);
       
        return ResponseEntity.ok().body(records);
    }

}
