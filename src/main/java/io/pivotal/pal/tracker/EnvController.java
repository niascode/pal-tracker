package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EnvController {

    private Map<String, String> envMap;

    public EnvController(@Value("${port:NOT SET}") String port,
                         @Value("${memory.limit:NOT SET}") String memory_Limit,
                         @Value("${cf.instance.index:NOT SET}") String cf_instance_index,
                         @Value("${cf.instance.addr:NOT SET}") String cf_instance_addr) {

        envMap = new HashMap<>();
        envMap.put("PORT",port);
        envMap.put("MEMORY_LIMIT",memory_Limit);
        envMap.put("CF_INSTANCE_INDEX",cf_instance_index);
        envMap.put("CF_INSTANCE_ADDR",cf_instance_addr);

    }




    @GetMapping("/env")
    public Map<String, String> getEnv() throws Exception {
        return envMap;
    }
}
