package com.dnslb.dnsloadblancer.RRDNS;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.xbill.DNS.Lookup;
import org.xbill.DNS.Record;
import org.xbill.DNS.TextParseException;
import org.xbill.DNS.Type;
@Service
public class RRDNSservice {
    
        RRDNSservice() {     
        }
        
        @Cacheable(value = "dnsCache", key = "#domain")
        public Record[] resolveIpsWithTtl(String domain) throws TextParseException {
            Record[] records = new Lookup(domain, Type.A).run();
            if (records == null || records.length == 0) {
                throw new TextParseException("No A records found for domain: " + domain);
            }else {
                return records;
            }
        } 
}
