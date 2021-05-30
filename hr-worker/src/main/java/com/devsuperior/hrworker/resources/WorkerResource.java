package com.devsuperior.hrworker.resources;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

	
	@Value("${test.config}")
	private String testeConfig;
	
	@Autowired
	private Environment env;
	
	@Autowired
	private WorkerRepository repository;
	
	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfigs(){		
		logger.info("CONFIG = " + testeConfig);
		return ResponseEntity.noContent().build();
	}

	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){		
		List<Worker> lista = repository.findAll();		
		return ResponseEntity.ok(lista);		
	}
		
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){		
		logger.info("PORT = " + env.getProperty("local.server.port"));
		
		Optional<Worker> obj = repository.findById(id);
		if(!obj.isEmpty()) {
			return ResponseEntity.ok(obj.get());
		}
		return null;				
	}

}
